package com.lianlianpay.mpay.busidemo.dao.mapper;

import com.lianlianpay.mpay.busidemo.dao.model.TbTraderOpenApplyDO;
import com.llpay.framework.autoconfigure.jdbc.tkmapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbTraderOpenApplyDOMapper {

    int deleteByPrimaryKey(String applyId);

    int insert(TbTraderOpenApplyDO record);

    int insertSelective(TbTraderOpenApplyDO record);

    TbTraderOpenApplyDO selectByPrimaryKey(String applyId);

    int updateByPrimaryKeySelective(TbTraderOpenApplyDO record);

    int updateByPrimaryKey(TbTraderOpenApplyDO record);

    List<TbTraderOpenApplyDO> selectAllByOidPartner(@Param("oidPartner") String oidPartner,@Param("bankChnl") String bankChnl);
}