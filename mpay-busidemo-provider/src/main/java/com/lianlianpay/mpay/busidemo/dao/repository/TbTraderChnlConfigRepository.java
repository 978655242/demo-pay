package com.lianlianpay.mpay.busidemo.dao.repository;

import com.lianlianpay.mpay.busidemo.dao.mapper.TbTraderChnlConfigDOMapper;
import com.lianlianpay.mpay.busidemo.dao.model.TbTraderChnlConfigDO;
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
 * @Date: 2019/6/18 16:15
 **/
@Repository
public class TbTraderChnlConfigRepository {
    @Resource
    private TbTraderChnlConfigDOMapper mapper;
    @Autowired
    private IAesCryptFacade aesCryptLocalService;

    public Boolean insertSelective(TbTraderChnlConfigDO chnlConfigDO) {
        aesEncryptData(chnlConfigDO);
        int result = mapper.insertSelective(chnlConfigDO);
        return result == 1 ? true : false;
    }

    public TbTraderChnlConfigDO selectByOidPartnerAndChnl(String oidPartner, String bankChnl) {
        TbTraderChnlConfigDO chnlConfigDO = new TbTraderChnlConfigDO();
        chnlConfigDO.setOidPartner(oidPartner);
        chnlConfigDO.setBankChnl(bankChnl);
        TbTraderChnlConfigDO result = mapper.selectOne(chnlConfigDO);
        aesDecryptData(result);
        return result;
    }

    public List<TbTraderChnlConfigDO> selectList(TbTraderChnlConfigDO chnlConfigDO) {
        List<TbTraderChnlConfigDO> result = mapper.select(chnlConfigDO);
        aesDecryptData(result);
        return result;
    }

    public Boolean updateSelectiveByPrimaryKey(TbTraderChnlConfigDO chnlConfigDO) {
        aesEncryptData(chnlConfigDO);
        int result = mapper.updateByPrimaryKeySelective(chnlConfigDO);
        return result == 1 ? true : false;
    }

    public List<TbTraderChnlConfigDO> selectAll() {
        List<TbTraderChnlConfigDO> result = mapper.selectAll();
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

    private void aesDecryptData(TbTraderChnlConfigDO chnlConfigDO) {
        if (chnlConfigDO == null) {
            return;
        }
        if (!Strings.isNullOrEmpty(chnlConfigDO.getBankAccount())) {
            chnlConfigDO.setBankAccount(aesCryptLocalService.aesDecrypt(chnlConfigDO.getBankAccount()));
        }

    }

    private void aesDecryptData(List<TbTraderChnlConfigDO> chnlConfigDOList) {
        if (isEmpty(chnlConfigDOList)) {
            return;
        }
        for (TbTraderChnlConfigDO chnlConfigDO : chnlConfigDOList) {
            if (!Strings.isNullOrEmpty(chnlConfigDO.getBankAccount())) {
                chnlConfigDO.setBankAccount(aesCryptLocalService.aesDecrypt(chnlConfigDO.getBankAccount()));
            }
        }

    }

}
