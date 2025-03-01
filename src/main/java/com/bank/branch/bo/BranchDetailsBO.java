package com.bank.branch.bo;

import com.bank.branch.eo.BranchDetailsEO;
import com.bank.branch.vo.BranchDetailsOutputVO;
import com.bank.branch.vo.BranchNewDetailsOutputVO;
import com.bank.branch.vo.NewBranchDetailsInputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BranchDetailsBO {
    @Autowired
    public BranchDetailsEO branchDetailsEO;
    public List<BranchDetailsOutputVO> getAllBranchDetails() {
        return branchDetailsEO.getAllBranchDetails();
    }

    public BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode) {
        return branchDetailsEO.branchDetailsByIfscCode(ifscCode);
    }

    public BranchNewDetailsOutputVO addNewBranchDetails(NewBranchDetailsInputVO newBranchDetailsInputVO) {
        return branchDetailsEO.addNewBranchDetails(newBranchDetailsInputVO);
    }
}
