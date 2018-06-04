package com.feecalculator.dto;

import com.feecalculator.common.StaticConstants;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.StringJoiner;

public class Transaction {

    private String externalTxnId;

    private String clientId;

    private String securityId;

    private String txnType;

    private Date txnDate;

    private Double marketValue;

    private String priorityFlag;

    private Double processingFees;

    public String getExternalTxnId() {
        return externalTxnId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public String getTxnType() {
        return txnType;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public String getPriorityFlag() {
        return priorityFlag;
    }

    public Double getProcessingFees() {
        return processingFees;
    }

    public void setExternalTxnId(String externalTxnId) {
        this.externalTxnId = externalTxnId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    public void setPriorityFlag(String priorityFlag) {
        this.priorityFlag = priorityFlag;
    }

    public void setProcessingFees(Double processingFees) {
        this.processingFees = processingFees;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\t\t");
        sj.add(clientId).add("");
        sj.add(StringUtils.rightPad(txnType, 8, "")).add("");
        sj.add((txnDate != null) ? txnDate.toString() : "").add("");
        sj.add(priorityFlag).add("");
        sj.add((processingFees != null) ? processingFees.toString() : "0.00");
        return sj.toString();
    }
}