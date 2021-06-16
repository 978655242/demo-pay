package com.lianlianpay.mpay.busidemo.dao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "TB_TRADER_OPEN_APPLY")
public class TbTraderOpenApplyDO {
    /**
     * 申请ID
     */
    @Id
    @Column(name = "apply_id")
    private String applyId;

    /**
     * 商户号
     */
    @Column(name = "oid_partner")
    private String oidPartner;

    /**
     * 客户注册申请流水ID
     */
    @Column(name = "apply_serial_id")
    private String applySerialId;

    /**
     * 委托授权号
     */
    @Column(name = "entrust_id")
    private String entrustId;

    /**
     * 商户名称
     */
    @Column(name = "trader_name")
    private String traderName;

    /**
     * 银行渠道编码
     */
    @Column(name = "bank_chnl")
    private String bankChnl;

    /**
     * 银行客户编码
     */
    @Column(name = "bank_customer_id")
    private String bankCustomerId;

    /**
     * 银行渠道名称
     */
    @Column(name = "bank_chnl_name")
    private String bankChnlName;

    /**
     * 银行账号
     */
    @Column(name = "bank_account")
    private String bankAccount;

    /**
     * 银行账户名称
     */
    @Column(name = "bank_account_name")
    private String bankAccountName;

    /**
     * 财务名称
     */
    @Column(name = "finance_name")
    private String financeName;

    /**
     * 财务证件类型（0:身份证）
     */
    @Column(name = "finance_id_type")
    private String financeIdType;

    /**
     * 财务证件号
     */
    @Column(name = "finance_id_no")
    private String financeIdNo;

    /**
     * 财务证件起
     */
    @Column(name = "finance_exp_start")
    private String financeExpStart;

    /**
     * 财务证件结束日期
     */
    @Column(name = "finance_exp_end")
    private String financeExpEnd;

    /**
     * 财务人员手机号
     */
    @Column(name = "finance_mobile")
    private String financeMobile;

    /**
     * 企业证件开始日期
     */
    @Column(name = "com_expire_start")
    private String comExpireStart;

    /**
     * 法人证件开始日期
     */
    @Column(name = "legal_expire_start")
    private String legalExpireStart;

    /**
     * 银行协议地址
     */
    @Column(name = "bank_contract_file")
    private String bankContractFile;

    /**
     * 合作协议地址
     */
    @Column(name = "auth_contract_file")
    private String authContractFile;

    /**
     * 备注
     */
    private String remark;

    /**
     * 0:初始化1：客户注册待审核2：委托号同步待审核3:商委签约待审核4：待授权签约5授权签约完成6：客户注册审核拒绝 7：委托号同步审核拒绝8：商委签约失败
     */
    private String status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 客户注册请求json
     */
    @Column(name = "register_json")
    private String registerJson;

    /**
     * 扩展字段
     */
    private String ext;

}