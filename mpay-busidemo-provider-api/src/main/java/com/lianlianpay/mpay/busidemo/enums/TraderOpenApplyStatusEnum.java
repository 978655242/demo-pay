package com.lianlianpay.mpay.busidemo.enums;

import lombok.Getter;

/**
 * @describe 申请表状态枚举
 * @PROJECNAME: mpay-busi
 * @author:yudi
 * @Date: 2019/6/15 13:59
 **/
@Getter
public enum  TraderOpenApplyStatusEnum {
    INIT("0", "初始化"),
    WAIT_REGISTER_REVIEW("1", "待客户注册审核"),
    WAIT_ENTRUST_REVIEW("2", "委托号同步待审核"),
    WAIT_ENTRUST_SIGN_REVIEW("3","待商委签约结果"),
    WAIT_SIGN("4", "待授权签约"),
    SIGNED("5", "签约完成"),
    REGISTER_REVIEW_REFUSE("6", "客户注册审核拒绝"),
    ENTRUST_REVIEW_REFUSE("7", "委托号同步审核拒绝"),
    ENTRUST_SIGN_REVIEW_FAILED("8", "商委签约失败");


    private final String code;

    private final String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    TraderOpenApplyStatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public static TraderOpenApplyStatusEnum getResultCode(String code) {
        for (TraderOpenApplyStatusEnum resultCode : values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }
        return null;
    }

}
