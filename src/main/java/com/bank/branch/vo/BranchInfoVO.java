package com.bank.account.info.vo;

public class BranchInfoVO {
    private String ifscCode;
    private String bankCode;
    private String branchName;

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "BranchInfoVO{" +
                "ifscCode='" + ifscCode + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
