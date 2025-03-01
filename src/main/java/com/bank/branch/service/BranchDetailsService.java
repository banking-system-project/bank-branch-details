package com.bank.branch.service;

import com.bank.branch.vo.*;

import java.util.List;

public interface BranchDetailsService {
    List<BranchDetailsOutputVO> getAllBranchDetails();
    BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode);
    BranchContactVO branchContactByIfscCode(String ifscCode);
    BranchAddressVO branchAddressByIfscCode(String ifscCode);
    BranchNewDetailsOutputVO addNewBranchDetail(NewBranchDetailsInputVO newBranchDetailsInputVO);

}
