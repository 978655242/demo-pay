package com.lianlianpay.mpay.busidemo.dao.repository;

import com.lianlianpay.mpay.busidemo.dao.mapper.TbTraderOpenApplyDOMapper;
import com.lianlianpay.mpay.busidemo.dao.model.TbTraderOpenApplyDO;
import com.lianlianpay.mpay.share.facade.IAesCryptFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


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

    @Autowired
    private IAesCryptFacade aesCryptFacade;

    public Boolean insertSelective(TbTraderOpenApplyDO traderOpenApply) {
        int result = applyDOMapper.insertSelective(traderOpenApply);
        return result == 1 ? true : false;
    }

    public TbTraderOpenApplyDO selectByPrimaryKey(String applyId) {
        TbTraderOpenApplyDO result = applyDOMapper.selectByPrimaryKey(applyId);
        return result;
    }

    public Boolean updateByPrimaryKeySelective(TbTraderOpenApplyDO applyDO) {
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
        return result;
    }

}
