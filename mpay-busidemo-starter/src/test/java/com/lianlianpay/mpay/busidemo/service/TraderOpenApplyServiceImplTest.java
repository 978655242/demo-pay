package com.lianlianpay.mpay.busidemo.service;


import com.lianlianpay.mpay.busidemo.TestSupport;
import com.lianlianpay.mpay.busidemo.service.trade.ITraderOpenApplyService;
import com.lianlianpay.mpay.busidemo.dto.trade.TraderOpenApplyReqDto;
import com.lianlianpay.mpay.busidemo.dto.trade.TraderOpenApplyResDto;
import com.lianlianpay.mpay.common.enums.CommonRetCodeEnum;
import com.lianlianpay.mpay.common.parameter.ResultModel;
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