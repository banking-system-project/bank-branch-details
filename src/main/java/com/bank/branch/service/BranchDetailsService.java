package com.bank.branch.service;

import com.bank.branch.vo.BranchAddressVO;
import com.bank.branch.vo.BranchContactVO;
import com.bank.branch.vo.BranchDetailsOutputVO;
import com.bank.branch.vo.NewBranchDetailsInputVO;

import java.util.List;

public interface BranchDetailsService {
    List<BranchDetailsOutputVO> getAllBranchDetails();
    BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode);
    BranchContactVO branchContactByIfscCode(String ifscCode);
    BranchAddressVO branchAddressByIfscCode(String ifscCode);
    BranchDetailsOutputVO addNewBranchDetail(NewBranchDetailsInputVO newBranchDetailsInputVO);
}
