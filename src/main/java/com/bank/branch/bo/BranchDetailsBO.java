package com.bank.account.info.bo;

import com.bank.account.info.eo.BranchDetailsEO;
import com.bank.account.info.vo.BranchDetailsOutputVO;
import com.bank.account.info.vo.BranchNewDetailsOutputVO;
import com.bank.account.info.vo.NewBranchDetailsInputVO;
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
