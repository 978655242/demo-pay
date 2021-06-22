package com.lianlianpay.mpay.busidemo.dao.repository;

import com.lianlianpay.mpay.busidemo.dao.mapper.TbTraderChnlConfigDOMapper;
import com.lianlianpay.mpay.busidemo.dao.model.TbTraderChnlConfigDO;
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

    public Boolean insertSelective(TbTraderChnlConfigDO chnlConfigDO) {
        int result = mapper.insertSelective(chnlConfigDO);
        return result == 1 ? true : false;
    }


}
