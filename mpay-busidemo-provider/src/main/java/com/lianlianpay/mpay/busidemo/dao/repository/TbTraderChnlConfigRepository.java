package com.lianlianpay.mpay.busidemo.dao.repository;

import com.lianlianpay.mpay.busidemo.dao.mapper.TbTraderChnlConfigDOMapper;
import com.lianlianpay.mpay.busidemo.dao.model.TbTraderChnlConfigDO;
import com.lianlianpay.mpay.share.facade.IAesCryptFacade;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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
    private IAesCryptFacade aesCryptFacade;

    public Boolean insertSelective(TbTraderChnlConfigDO chnlConfigDO) {
        aesEncryptData(chnlConfigDO);
        int result = mapper.insertSelective(chnlConfigDO);
        return result == 1 ? true : false;
    }

    private void aesEncryptData(TbTraderChnlConfigDO chnlConfigDO) {
        if (chnlConfigDO == null) {
            return;
        }
        if (!Strings.isNullOrEmpty(chnlConfigDO.getBankAccount())) {
            chnlConfigDO.setBankAccount(aesCryptFacade.aesEncrypt(chnlConfigDO.getBankAccount()));
        }

    }


}
