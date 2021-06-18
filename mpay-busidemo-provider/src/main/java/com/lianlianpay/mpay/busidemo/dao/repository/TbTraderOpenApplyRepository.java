package com.lianlianpay.mpay.busidemo.dao.repository;

import com.lianlianpay.mpay.busidemo.dao.mapper.TbTraderChnlConfigDOMapper;
import com.lianlianpay.mpay.busidemo.dao.mapper.TbTraderOpenApplyDOMapper;
import com.lianlianpay.mpay.busidemo.dao.model.TbTraderOpenApplyDO;
import com.lianlianpay.mpay.share.facade.IAesCryptFacade;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
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
    private IAesCryptFacade aesCryptFacade;

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

    public Boolean updateByPrimaryKeySelective(TbTraderOpenApplyDO applyDO) {
        aesEncryptData(applyDO);
        int result = applyDOMapper.updateByPrimaryKeySelective(applyDO);
        return result == 1 ? true : false;
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<TbTraderOpenApplyDO> selectAllByOidPartner(String oidPartner, String chnl) {
        List<TbTraderOpenApplyDO> result = applyDOMapper.selectAllByOidPartner(oidPartner, chnl);
        aesDecryptData(result);
        return result;
    }

    private void aesEncryptData(TbTraderOpenApplyDO openApplyDO) {
        if (openApplyDO == null) {
            return;
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceName())) {
            openApplyDO.setFinanceName(aesCryptFacade.aesEncrypt(openApplyDO.getFinanceName()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceMobile())) {
            openApplyDO.setFinanceMobile(aesCryptFacade.aesEncrypt(openApplyDO.getFinanceMobile()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceIdNo())) {
            openApplyDO.setFinanceIdNo(aesCryptFacade.aesEncrypt(openApplyDO.getFinanceIdNo()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getBankAccount())) {
            openApplyDO.setBankAccount(aesCryptFacade.aesEncrypt(openApplyDO.getBankAccount()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getRegisterJson())) {
            openApplyDO.setRegisterJson(aesCryptFacade.aesEncrypt(openApplyDO.getRegisterJson()));
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
            openApplyDO.setFinanceName(aesCryptFacade.aesDecrypt(openApplyDO.getFinanceName()));
        }

        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceMobile())) {
            openApplyDO.setFinanceMobile(aesCryptFacade.aesDecrypt(openApplyDO.getFinanceMobile()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getFinanceIdNo())) {
            openApplyDO.setFinanceIdNo(aesCryptFacade.aesDecrypt(openApplyDO.getFinanceIdNo()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getBankAccount())) {
            openApplyDO.setBankAccount(aesCryptFacade.aesDecrypt(openApplyDO.getBankAccount()));
        }
        if (!Strings.isNullOrEmpty(openApplyDO.getRegisterJson())) {
            openApplyDO.setRegisterJson(aesCryptFacade.aesDecrypt(openApplyDO.getRegisterJson()));
        }

    }
}
