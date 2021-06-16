package com.lianlianpay.mpay.busidemo.dao.repository;

import com.lianlianpay.mpay.busidemo.dao.mapper.TbTraderChnlConfigDOMapper;
import com.lianlianpay.mpay.busidemo.dao.mapper.TbTraderOpenApplyDOMapper;
import com.lianlianpay.mpay.busidemo.dao.model.TbTraderChnlConfigDO;
import com.lianlianpay.mpay.busidemo.dao.model.TbTraderOpenApplyDO;
import com.lianlianpay.mpay.busidemo.enums.TraderOpenApplyStatusEnum;
import com.lianlianpay.mpay.share.facade.IAesCryptFacade;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.apache.commons.collections.CollectionUtils.isEmpty;

/**
 * @describe ${输入类的描述}
 * @PROJECNAME: mpay-busi
 * @author:yudi
 * @Date: 2019/6/15 13:29
 **/
@Repository
public class TbTraderOpenApplyRepository {
    @Resource
    private TbTraderOpenApplyDOMapper applyDOMapper;
    @Resource
    private TbTraderChnlConfigDOMapper chnlConfigDOMapper;
    @Autowired
    private IAesCryptFacade aesCryptLocalService;

    public Boolean insertSelective(TbTraderOpenApplyDO traderOpenApply) {
        aesEncryptData(traderOpenApply);
        int result = applyDOMapper.insertSelective(traderOpenApply);
        return result == 1 ? true : false;
    }

    public TbTraderOpenApplyDO selectByPrimaryKey(String applyId) {
        TbTraderOpenApplyDO result = applyDOMapper.selectByPrimaryKey(applyId);
        aesDecryptData(result);
        return result;
    }

    public List<TbTraderOpenApplyDO> getRecordByApplySerialId(String applySerialId) {
        Example example = new Example(TbTraderOpenApplyDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applySerialId", applySerialId);
        example.orderBy("createTime").desc();
        List<TbTraderOpenApplyDO> result = applyDOMapper.selectByExample(example);
        aesDecryptData(result);
        return result;
    }

    public Boolean updateStatus(String applyId, TraderOpenApplyStatusEnum sourceStatus,
        TraderOpenApplyStatusEnum targetStatus) {
        TbTraderOpenApplyDO traderOpenApply = new TbTraderOpenApplyDO();
        traderOpenApply.setUpdateTime(new Date());
        traderOpenApply.setStatus(targetStatus.getCode());
        Example example = new Example(TbTraderOpenApplyDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applyId", applyId);
        criteria.andEqualTo("status", sourceStatus.getCode());
        int result = applyDOMapper.updateByExampleSelective(traderOpenApply, example);
        return result == 1 ? true : false;
    }

    public Boolean updateByPrimaryKeySelective(TbTraderOpenApplyDO applyDO) {
        aesEncryptData(applyDO);
        int result = applyDOMapper.updateByPrimaryKeySelective(applyDO);
        return result == 1 ? true : false;
    }

    /**
     * 根据申请ID和原始状态更新 update
     *
     * @param applyId
     * @param sourceStatus
     * @param update
     * @return
     */
    public Boolean updateStatus(String applyId, TraderOpenApplyStatusEnum sourceStatus, TbTraderOpenApplyDO update) {
        Example example = new Example(TbTraderOpenApplyDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applyId", applyId);
        criteria.andEqualTo("status", sourceStatus.getCode());
        aesEncryptData(update);
        int result = applyDOMapper.updateByExampleSelective(update, example);
        return result == 1 ? true : false;
    }

    /**
     * 根据状态列表查询
     *
     * @param oidPartner
     * @return
     */
    public List<TbTraderOpenApplyDO> selectByStatusList(String oidPartner, String chnl, List<String> status) {
        Example example = new Example(TbTraderOpenApplyDO.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("oidPartner", oidPartner);
        criteria.andEqualTo("bankChnl", chnl);
        criteria.andIn("status", status);
        example.orderBy("createTime").desc();
        List<TbTraderOpenApplyDO> result = applyDOMapper.selectByExample(example);
        aesDecryptData(result);
        return result;
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<TbTraderOpenApplyDO> selectAllByOidPartner(String oidPartner, String chnl) {
        Example example = new Example(TbTraderOpenApplyDO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("oidPartner", oidPartner);
        criteria.andEqualTo("bankChnl", chnl);
        example.orderBy("createTime").desc();
        List<TbTraderOpenApplyDO> result = applyDOMapper.selectByExample(example);
        aesDecryptData(result);
        return result;
    }

    /**
     * 根据状态列表查询
     *
     * @param oidPartner
     * @return
     */
    public TbTraderOpenApplyDO selectByStatus(String oidPartner, String chnl, TraderOpenApplyStatusEnum status) {
        TbTraderOpenApplyDO record = new TbTraderOpenApplyDO();
        record.setBankChnl(chnl);
        record.setOidPartner(oidPartner);
        record.setStatus(status.getCode());
        TbTraderOpenApplyDO result = applyDOMapper.selectOne(record);
        aesDecryptData(result);
        return result;
    }

    public List<TbTraderOpenApplyDO> selectByStatus(TraderOpenApplyStatusEnum statusEnum) {
        TbTraderOpenApplyDO record = new TbTraderOpenApplyDO();
        record.setStatus(statusEnum.getCode());
        List<TbTraderOpenApplyDO> result = applyDOMapper.select(record);
        aesDecryptData(result);
        return result;
    }


    private void aesEncryptData(TbTraderChnlConfigDO chnlConfigDO) {
        if (chnlConfigDO == null) {
            return;
        }
        if (!Strings.isNullOrEmpty(chnlConfigDO.getBankAccount())) {
            chnlConfigDO.setBankAccount(aesCryptLocalService.aesEncrypt(chnlConfigDO.getBankAccount()));
        }

    }

    private void aesEncryptData(TbTraderOpenApplyDO openApplyDO) {
        if (openApplyDO == null) {
            return;
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceName())) {
            openApplyDO.setFinanceName(aesCryptLocalService.aesEncrypt(openApplyDO.getFinanceName()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceMobile())) {
            openApplyDO.setFinanceMobile(aesCryptLocalService.aesEncrypt(openApplyDO.getFinanceMobile()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceIdNo())) {
            openApplyDO.setFinanceIdNo(aesCryptLocalService.aesEncrypt(openApplyDO.getFinanceIdNo()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getBankAccount())) {
            openApplyDO.setBankAccount(aesCryptLocalService.aesEncrypt(openApplyDO.getBankAccount()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getRegisterJson())) {
            openApplyDO.setRegisterJson(aesCryptLocalService.aesEncrypt(openApplyDO.getRegisterJson()));
        }

    }

    private void aesDecryptData(List<TbTraderOpenApplyDO> openApplyDOList) {
        if (isEmpty(openApplyDOList)) {
            return;
        }
        for (TbTraderOpenApplyDO openApplyDO : openApplyDOList) {
            aesDecryptData(openApplyDO);
        }

    }

    private void aesDecryptData(TbTraderOpenApplyDO openApplyDO) {
        if (openApplyDO == null) {
            return;
        }

        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceName())) {
            openApplyDO.setFinanceName(aesCryptLocalService.aesDecrypt(openApplyDO.getFinanceName()));
        }

        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceMobile())) {
            openApplyDO.setFinanceMobile(aesCryptLocalService.aesDecrypt(openApplyDO.getFinanceMobile()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceIdNo())) {
            openApplyDO.setFinanceIdNo(aesCryptLocalService.aesDecrypt(openApplyDO.getFinanceIdNo()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getBankAccount())) {
            openApplyDO.setBankAccount(aesCryptLocalService.aesDecrypt(openApplyDO.getBankAccount()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getRegisterJson())) {
            openApplyDO.setRegisterJson(aesCryptLocalService.aesDecrypt(openApplyDO.getRegisterJson()));
        }

    }
}
