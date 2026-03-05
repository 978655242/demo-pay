package com.tups.manager.strategy;

import com.tups.service.trade.req.MqRankTransReqDto;
import com.tups.mpay.common.parameter.ResultModel;

/**
 * @ClassName: PromotionStrategy
 * @Description: 营销执行策略
 * @Author: lihp
 * @Date: 2021/6/18 9:53
 **/
public interface PromotionStrategy {
    /**
     * 营销执行策略（接口支持幂等）
     * @param reqDto
     * @return
     */
    ResultModel execPromotion(MqRankTransReqDto reqDto);

}
