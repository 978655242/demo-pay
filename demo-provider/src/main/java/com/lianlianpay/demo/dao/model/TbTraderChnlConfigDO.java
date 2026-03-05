package com.lianlianpay.demo.dao.model;

import java.util.Date;

/**
 * 商户渠道配置信息
 */
public class TbTraderChnlConfigDO {
    /**
     * 商户号
     */
    private String oidPartner;

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
     * 银行协议地址
     */
    private String bankContractFile;

    /**
     * 合作协议地址
     */
    private String authContractFile;

    /**
     * 充值触发余额阈值
     */
    private Long limitBalance;

    /**
     * 单次充值限额
     */
    private Long singleMaxRecharge;

    private Date createTime;

    private Date updateTime;

    public String getOidPartner() {
        return oidPartner;
    }

    public void setOidPartner(String oidPartner) {
        this.oidPartner = oidPartner;
    }

    public String getBankChnl() {
        return bankChnl;
    }

    public void setBankChnl(String bankChnl) {
        this.bankChnl = bankChnl;
    }

    public String getBankCustomerId() {
        return bankCustomerId;
    }

    public void setBankCustomerId(String bankCustomerId) {
        this.bankCustomerId = bankCustomerId;
    }

    public String getBankChnlName() {
        return bankChnlName;
    }

    public void setBankChnlName(String bankChnlName) {
        this.bankChnlName = bankChnlName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankContractFile() {
        return bankContractFile;
    }

    public void setBankContractFile(String bankContractFile) {
        this.bankContractFile = bankContractFile;
    }

    public String getAuthContractFile() {
        return authContractFile;
    }

    public void setAuthContractFile(String authContractFile) {
        this.authContractFile = authContractFile;
    }

    public Long getLimitBalance() {
        return limitBalance;
    }

    public void setLimitBalance(Long limitBalance) {
        this.limitBalance = limitBalance;
    }

    public Long getSingleMaxRecharge() {
        return singleMaxRecharge;
    }

    public void setSingleMaxRecharge(Long singleMaxRecharge) {
        this.singleMaxRecharge = singleMaxRecharge;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}