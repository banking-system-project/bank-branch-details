package com.bank.branch.service;

import com.bank.branch.bo.BranchDetailsBO;
import com.bank.branch.vo.BranchAddressVO;
import com.bank.branch.vo.BranchContactVO;
import com.bank.branch.vo.BranchDetailsOutputVO;
import com.bank.branch.vo.NewBranchDetailsInputVO;
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
        return null;
    }

    @Override
    public BranchContactVO branchContactByIfscCode(String ifscCode) {
        return null;
    }

    @Override
    public BranchAddressVO branchAddressByIfscCode(String ifscCode) {
        return null;
    }

    @Override
    public BranchDetailsOutputVO addNewBranchDetail(NewBranchDetailsInputVO newBranchDetailsInputVO) {
        return null;
    }
}
