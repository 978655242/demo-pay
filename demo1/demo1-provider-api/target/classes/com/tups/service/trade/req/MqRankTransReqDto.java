package com.tups.service.trade.req;

import com.tups.mpay.common.parameter.BaseReqDTO;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @ClassName: MqRankTransReqDto
 * @Description: mq交易消息通知
 * @Author: lihp
 * @Date: 2021/6/18 9:52
 **/
@Data
@Builder
public class MqRankTransReqDto extends BaseReqDTO {

    /**
     * 用户号
     */
    @NotBlank(message = "用户号不能为空")
    private String userId;

    /**
     * 投资,赎回订单号
     */
    private String noOrder;
    /**
     * 订单完成时间
     */
    private Date dtOrder;
    /**
     * 订单金额单位为厘
     */
    private String amt;

    /**
     * 购买单号-赎回时传入
     */
    private String purchaseNoOrder;

	/**
	 * 渠道编码
	 */
    private String chnlCode;


    @Override
    public String validateLogic() {
        return null;
    }
}
