package com.lianlianpay.demo.service.trade;

import com.lianlianpay.demo.dto.trade.TraderOpenApplyResDto;
import com.lianlianpay.demo.dto.trade.TraderOpenApplyReqDto;
import com.lianlianpay.mpay.common.parameter.ResultModel;

/**
 * @describe 样例参考
 * @PROJECNAME: demo
 * @author:yudi
 * @Date: 2019/6/15 13:46
 **/
public interface ITraderOpenApplyService {
    /**
     * 根据商户号申请记录查询
     * 
     * @return
     */
    ResultModel<TraderOpenApplyResDto> getApplyInfo(TraderOpenApplyReqDto reqDto);

}
