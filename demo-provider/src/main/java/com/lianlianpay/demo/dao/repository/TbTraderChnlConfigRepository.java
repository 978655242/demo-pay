package com.lianlianpay.demo.dao.repository;

import com.lianlianpay.demo.dao.mapper.TbTraderChnlConfigDOMapper;
import com.lianlianpay.demo.dao.model.TbTraderChnlConfigDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @describe ${输入类的描述}
 * @PROJECNAME: demo
 * @author:lihp
 * @Date: 2021/6/18 16:15
 **/
@Repository
public class TbTraderChnlConfigRepository {

    @Resource
    private TbTraderChnlConfigDOMapper applyDOMapper;

    public Boolean insertSelective(TbTraderChnlConfigDO chnlConfigDO) {
        int result = applyDOMapper.insertSelective(chnlConfigDO);
        return result == 1 ? true : false;
    }


}
