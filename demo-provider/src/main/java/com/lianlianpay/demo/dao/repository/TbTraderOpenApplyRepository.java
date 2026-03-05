package com.lianlianpay.demo.dao.repository;

import com.lianlianpay.demo.dao.mapper.TbTraderChnlConfigDOMapper;
import com.lianlianpay.demo.dao.mapper.TbTraderOpenApplyDOMapper;
import com.lianlianpay.demo.dao.model.TbTraderChnlConfigDO;
import com.lianlianpay.demo.dao.model.TbTraderOpenApplyDO;
import com.lianlianpay.mpay.common.enums.CommonRetCodeEnum;
import com.lianlianpay.mpay.common.exceptions.CommonBizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @describe ${输入类的描述}
 * @PROJECNAME: demo
 * @author:yudi
 * @Date: 2019/6/15 13:29
 **/
@Repository
@Slf4j
public class TbTraderOpenApplyRepository {

    @Resource
    private TbTraderOpenApplyDOMapper applyDOMapper;

    @Resource
    private TbTraderChnlConfigDOMapper chnlConfigDOMapper;

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

    @Transactional(rollbackFor = Exception.class)
    public void transApplyUpdate(TbTraderOpenApplyDO updateApplyDO, TbTraderChnlConfigDO chnlConfigDO) {
        int resultCount = applyDOMapper.updateByPrimaryKeySelective(updateApplyDO);
        if( resultCount!= 1 ){
            log.info("开户申请更新系统异常");
            throw new CommonBizException(CommonRetCodeEnum.DB_EXCUTE_ERROR);
        }
        resultCount = chnlConfigDOMapper.insert(chnlConfigDO);
        if( resultCount != 1 ){
            log.info("商户渠道配置新增系统异常");
            throw new CommonBizException(CommonRetCodeEnum.DB_EXCUTE_ERROR);
        }
    }

}
