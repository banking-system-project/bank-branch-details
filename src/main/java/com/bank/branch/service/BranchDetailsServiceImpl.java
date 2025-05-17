package com.bank.branch.service;

import com.bank.branch.bo.BranchDetailsBO;
import com.bank.branch.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchDetailsServiceImpl implements BranchDetailsService{
    private static final Logger log = LoggerFactory.getLogger(BranchDetailsServiceImpl.class);

    @Autowired
    public BranchDetailsBO branchDetailsBO;

    public List<BranchDetailsOutputVO> getAllBranchDetails() {
        log.info("service layer: calling to get all branch details");
        return branchDetailsBO.getAllBranchDetails();
    }

    @Override
    public BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode) {
        log.info("service layer: calling to get branch details by ifsc code");
        return branchDetailsBO.branchDetailsByIfscCode(ifscCode);
    }

    @Override
    public BranchContactVO branchContactByIfscCode(String ifscCode) {
        log.info("service layer: calling to get branch contact by ifsc code");
        BranchDetailsOutputVO branchDetailsOutputVO = branchDetailsBO.branchDetailsByIfscCode(ifscCode);
        log.info("service layer: returning branch contact by ifsc code");
        return branchDetailsOutputVO.getBranchContactVO();
    }

    @Override
    public BranchAddressVO branchAddressByIfscCode(String ifscCode) {
        log.info("service layer: calling to get branch address by ifsc code");
        BranchDetailsOutputVO branchDetailsOutputVO = branchDetailsBO.branchDetailsByIfscCode(ifscCode);
        log.info("service layer: returning branch address by ifsc code");
        return branchDetailsOutputVO.getBranchAddressVO();
    }

    @Override
    public BranchNewDetailsOutputVO addNewBranchDetail(NewBranchDetailsInputVO newBranchDetailsInputVO) {
        log.info("service layer: calling to add new branch details");
        return branchDetailsBO.addNewBranchDetails(newBranchDetailsInputVO);
    }
}
