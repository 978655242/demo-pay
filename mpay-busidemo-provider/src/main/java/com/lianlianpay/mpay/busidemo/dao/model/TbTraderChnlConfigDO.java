package com.lianlianpay.mpay.busidemo.dao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "TB_TRADER_CHNL_CONFIG")
public class TbTraderChnlConfigDO {
    /**
     * 商户号
     */
    @Id
    @Column(name = "oid_partner")
    private String oidPartner;

    /**
     * 银行渠道编码
     */
    @Id
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
     * 充值触发余额阈值
     */
    @Column(name = "limit_balance")
    private Long limitBalance;

    @Column(name = "single_max_recharge")
    private Long singleMaxRecharge;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

}