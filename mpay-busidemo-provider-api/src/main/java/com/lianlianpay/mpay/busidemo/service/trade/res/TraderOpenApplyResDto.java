package com.lianlianpay.mpay.busidemo.service.trade.res;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @describe ${输入类的描述}
 * @PROJECNAME: mpay-busi
 * @author:yudi
 * @Date: 2019/6/15 13:51
 **/
@Data
public class TraderOpenApplyResDto implements Serializable {

    private static final long serialVersionUID = -42988032060168140L;
    /**
     * 申请ID
     */
    private String applyId;

    /**
     * 商户号
     */
    private String oidPartner;

    /**
     * 商户名称
     */
    private String traderName;

    /**
     * 银行渠道编码
     */
    private String bankChnl;

    /**
     * 银行客户编码
     */
    private String bankCustomerId;

    /**
     * 银行渠道名称
     */
    private String bankChnlName;

    /**
     * 银行账号
     */
    private String bankAccount;
    /**
     * 银行账户名称
     */
    private String bankAccountName;

    /**
     * 财务名称
     */
    private String financeName;

    /**
     * 财务证件类型（101:身份证）
     */
    private String financeIdType;

    /**
     * 财务证件号
     */
    private String financeIdNo;

    /**
     * 财务证件起
     */
    private String financeExpStart;

    /**
     * 财务证件结束日期
     */
    private String financeExpEnd;

    /**
     * 财务人员手机号
     */
    private String financeMobile;

    /**
     * 企业证件开始日期
     */
    private String comExpireStart;

    /**
     * 法人证件开始日期
     */
    private String legalExpireStart;

    /**
     * 银行协议地址
     */
    private String bankContractFile;

    /**
     * 合作协议地址
     */
    private String authContractFile;
    private String registerJson;

    /**
     * 备注
     */
    private String remark;

    /**
     * 0:初始化1：客户注册待审核2：委托号同步待审核3:商委签约待审核4：待授权签约5授权签约完成6：客户注册审核拒绝 7：委托号同步审核拒绝8：商委签约失败
     */
    private String status;

    private Date createTime;

    private Date updateTime;
}
