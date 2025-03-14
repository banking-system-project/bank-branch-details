package com.bank.account.info.vo;

public class NewBranchDetailsInputVO {
    private BranchAddressVO branchAddressVO;
    private BranchContactVO branchContactVO;
    private BranchInfoVO branchInfoVO;

    public BranchAddressVO getBranchAddressVO() {
        return branchAddressVO;
    }

    public void setBranchAddressVO(BranchAddressVO branchAddressVO) {
        this.branchAddressVO = branchAddressVO;
    }

    public BranchContactVO getBranchContactVO() {
        return branchContactVO;
    }

    public void setBranchContactVO(BranchContactVO branchContactVO) {
        this.branchContactVO = branchContactVO;
    }

    public BranchInfoVO getBranchInfoVO() {
        return branchInfoVO;
    }

    public void setBranchInfoVO(BranchInfoVO branchInfoVO) {
        this.branchInfoVO = branchInfoVO;
    }
}
