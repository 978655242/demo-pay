package com.tups.dao.model;

import java.util.Date;

/**
 * 商户开户申请表--日终清零业务
 */
public class TbTraderOpenApplyDO {
    /**
     * 申请ID
     */
    private String applyId;

    /**
     * 商户号
     */
    private String oidPartner;

    /**
     * 客户注册申请流水ID
     */
    private String applySerialId;

    /**
     * 委托授权号
     */
    private String entrustId;

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
     * 财务证件类型（0:身份证）
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
     * 财务手机号
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

    /**
     * 客户注册请求json
     */
    private String registerJson;

    /**
     * 扩展字段
     */
    private String ext;

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

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getOidPartner() {
        return oidPartner;
    }

    public void setOidPartner(String oidPartner) {
        this.oidPartner = oidPartner;
    }

    public String getApplySerialId() {
        return applySerialId;
    }

    public void setApplySerialId(String applySerialId) {
        this.applySerialId = applySerialId;
    }

    public String getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(String entrustId) {
        this.entrustId = entrustId;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
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

    public String getFinanceName() {
        return financeName;
    }

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    public String getFinanceIdType() {
        return financeIdType;
    }

    public void setFinanceIdType(String financeIdType) {
        this.financeIdType = financeIdType;
    }

    public String getFinanceIdNo() {
        return financeIdNo;
    }

    public void setFinanceIdNo(String financeIdNo) {
        this.financeIdNo = financeIdNo;
    }

    public String getFinanceExpStart() {
        return financeExpStart;
    }

    public void setFinanceExpStart(String financeExpStart) {
        this.financeExpStart = financeExpStart;
    }

    public String getFinanceExpEnd() {
        return financeExpEnd;
    }

    public void setFinanceExpEnd(String financeExpEnd) {
        this.financeExpEnd = financeExpEnd;
    }

    public String getFinanceMobile() {
        return financeMobile;
    }

    public void setFinanceMobile(String financeMobile) {
        this.financeMobile = financeMobile;
    }

    public String getComExpireStart() {
        return comExpireStart;
    }

    public void setComExpireStart(String comExpireStart) {
        this.comExpireStart = comExpireStart;
    }

    public String getLegalExpireStart() {
        return legalExpireStart;
    }

    public void setLegalExpireStart(String legalExpireStart) {
        this.legalExpireStart = legalExpireStart;
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

    public String getRegisterJson() {
        return registerJson;
    }

    public void setRegisterJson(String registerJson) {
        this.registerJson = registerJson;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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