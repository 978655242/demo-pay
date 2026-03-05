package com.lianlianpay.demo.dao.mapper;

import com.lianlianpay.demo.dao.model.TbTraderChnlConfigDO;
import com.llpay.framework.autoconfigure.jdbc.tkmapper.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TbTraderChnlConfigDOMapper {

    int deleteByPrimaryKey(@Param("oidPartner") String oidPartner, @Param("bankChnl") String bankChnl);

    int insert(TbTraderChnlConfigDO record);

    int insertSelective(TbTraderChnlConfigDO record);

    TbTraderChnlConfigDO selectByPrimaryKey(@Param("oidPartner") String oidPartner, @Param("bankChnl") String bankChnl);

    int updateByPrimaryKeySelective(TbTraderChnlConfigDO record);

    int updateByPrimaryKey(TbTraderChnlConfigDO record);

}