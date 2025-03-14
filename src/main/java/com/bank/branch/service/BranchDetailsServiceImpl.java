package com.bank.account.info.service;

import com.bank.account.info.bo.BranchDetailsBO;
import com.bank.account.info.vo.*;
import com.bank.branch.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchDetailsServiceImpl implements BranchDetailsService{
    @Autowired
    public BranchDetailsBO branchDetailsBO;
    public List<BranchDetailsOutputVO> getAllBranchDetails() {
        return branchDetailsBO.getAllBranchDetails();
    }

    @Override
    public BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode) {
        return branchDetailsBO.branchDetailsByIfscCode(ifscCode);
    }

    @Override
    public BranchContactVO branchContactByIfscCode(String ifscCode) {
        BranchDetailsOutputVO branchDetailsOutputVO = branchDetailsBO.branchDetailsByIfscCode(ifscCode);
        return branchDetailsOutputVO.getBranchContactVO();
    }

    @Override
    public BranchAddressVO branchAddressByIfscCode(String ifscCode) {
        BranchDetailsOutputVO branchDetailsOutputVO = branchDetailsBO.branchDetailsByIfscCode(ifscCode);
        return branchDetailsOutputVO.getBranchAddressVO();
    }

    @Override
    public BranchNewDetailsOutputVO addNewBranchDetail(NewBranchDetailsInputVO newBranchDetailsInputVO) {
        BranchNewDetailsOutputVO branchNewDetailsOutputVO = branchDetailsBO.addNewBranchDetails(newBranchDetailsInputVO);
        return branchNewDetailsOutputVO;
    }
}
