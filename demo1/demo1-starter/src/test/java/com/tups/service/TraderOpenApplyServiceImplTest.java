package com.tups.service;


import com.tups.TestSupport;
import com.tups.service.trade.ITraderOpenApplyService;
import com.tups.service.trade.req.TraderOpenApplyReqDto;
import com.tups.service.trade.res.TraderOpenApplyResDto;
import com.tups.mpay.common.enums.CommonRetCodeEnum;
import com.tups.mpay.common.parameter.ResultModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @describe ${输入类的描述}
 * @PROJECNAME: test
 * @author:yudi
 * @Date: 2021/6/05 13:00
 **/
public class TraderOpenApplyServiceImplTest extends TestSupport {

    @Autowired
    private ITraderOpenApplyService traderOpenApplyService;

    @Test
    public void getApplyInfoTest() {
        TraderOpenApplyReqDto reqDto = new TraderOpenApplyReqDto();
        reqDto.setOidPartner("201907050001652012");
        ResultModel<TraderOpenApplyResDto> reslutModel = traderOpenApplyService.getApplyInfo(reqDto);
        Assert.assertEquals(CommonRetCodeEnum.TRANS_SUCCESS.getCode(),reslutModel.getCode());
    }


}