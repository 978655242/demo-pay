package com.lianlianpay.mpay.busidemo.common.enums;

import com.lianlianpay.mpay.common.enums.CommonRetCodeEnum;
import com.lianlianpay.mpay.common.enums.CommonRetCodeInterEnum;
import com.lianlianpay.mpay.common.exceptions.CommonBizException;

/**
 * @describe 新业务返回枚举类
 * @PROJECNAME: mpay-busi
 * @author:yudi
 * @Date: 2019/6/14 14:35
 **/
public enum  BusiRetCodeEnum implements CommonRetCodeInterEnum {
    FILE_DOWNLOAD_ERROR("MB1010","文件下载失败"),
    TRADER_PARAM_NOT_EXIST("MB1011", "商户控制参数查询失败"),
    TRADER_PAYMENT_IS_CLOSED("MB1012", "商户支付功能已关闭"),
    TRADER_PROD_NOT_AUTH("MB1013", "商户产品权限不足"),
    TRADER_INFO_NOT_EXIST("MB1014", "商户基本信息查询失败"),
    TRADER_ACCOUNT_NOT_AUTH("MB1015", "商户账户权限不足"),
    TRADER_INFO_NOT_COMPLETE("MB1016", "商户信息不完整[%s]"),
    IMAGE_DATA_EMPTY("MB1017", "上传银行照片数据不能为空"),
    TRADER_APPLY_NOT_EXIST("MB1018", "开户申请数据不存在"),
    TRADER_APPLY_ERROR("MB1019", "开户数据异常"),
    TRADER_APPLY_IS_EXIST("MB1020", "开户申请记录已存在"),
    TRADER_APPLY_STATUS_NOT_SUCCESS("MB1021", "开户申请记录状态不正确"),
    BANK_RESULT_STATUS_NOT_UNKNOW("MB1022", "银行结果状态未知"),
    USER_ADD_FAILED("MB1023", "新增用户信息失败"),
    TRADER_ENDCLEAR_CHNL_NOT_EXIST("MB1024", "商户日终清零渠道配置信息不存在"),
    TRADER_RECHARGE_ACCOUNT_NOT_SAME("MB1025", "商户充值账号信息不一致"),
    AMOUNT_TO_BIG("MB1026", "充值金额大于配置单次最大金额"),
    TRADER_ACCOUNT_QUERY_FAILED("MB1027", "商户账户信息查询失败"),
    BALANCE_QUERY_FAILED("MB1028", "余额查询失败"),
    BALANCE_ENOUGH("MB1029", "余额充足无需充值"),
    USER_INFO_QUERY_FAILED("MB1030", "用户信息查询失败"),
    SIGN_RECORD_QUERY_FAILED("MB1031", "签约记录查询失败"),
    PAY_BILL_CREATE_FAILED("MB1032", "支付单创建失败"),
    SIGN_RECORD_EMPTY("MB1033", "签约记录为空"),
    CUSTOMER_REGISTER_FAILED("MB1034", "客户注册失败"),
    PIC_UPLOAD_FAILED("MB1035", "图片上传失败"),
    REGISTER_QUERY_FAILED("MB1036", "客户注册结果查询失败"),
    DATE_NOT_IN_RANGE("MB1037", "时间不在范围内"),
    TRADER_CHNL_CHNL_UPDATE_FAILED("MB1038", "商户渠道配置更新失败"),
    TRADER_PROD_QUERY_FAILED("MB1039", "商户产品权限查询失败"),
    ENTRUST_APPLY_FAILED("MB1040", "商委签约申请失败"),
    TRADER_ACCT_NOT_MATCH("MB1041", "商户对公户不匹配"),
    BALANCE_NOT_ENOUGH("MB1042", "银行账户余额不足"),
    ENTRUST_NOT_SYNC_FAILED("MB1043", "委托号同步失败"),
    PROD_LIMIT_NOT_PASS("MB1044", "产品限额不通过"),
    SINGLE_AMOUNT_VALIDATE_FAILED("MB1045", "单次充值金额不能大于产品限额][%s]"),
    FILE_TYPE_NOT_SUPPORT("MB1046", "文件类型不支持"),
    CUSTOMER_REGISTER_PROCESS("MB1047", "客户注册处理中"),
    ENTRUST_SYNC_QUERY_FAILED("MB1048", "委托号同步查询失败"),


    //渠道返回
    DONE_SUCC("2007","交易已支付成功");



    private final String code;

    private final String desc;


    BusiRetCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static BusiRetCodeEnum getResultCode(String code) {
        for (BusiRetCodeEnum resultCode : values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }
        throw new CommonBizException(CommonRetCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
