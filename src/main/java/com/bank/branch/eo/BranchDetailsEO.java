package com.bank.branch.eo;

import com.bank.branch.dao.BranchDetailsDAO;
import com.bank.branch.vo.BranchDetailsOutputVO;
import com.bank.branch.vo.BranchNewDetailsOutputVO;
import com.bank.branch.vo.NewBranchDetailsInputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BranchDetailsEO {
    @Autowired
    public BranchDetailsDAO branchDetailsDAO;
    public List<BranchDetailsOutputVO> getAllBranchDetails() {
        return branchDetailsDAO.getAllBranchDetails();
    }

    public BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode) {
        return branchDetailsDAO.branchDetailsByIfscCode(ifscCode);
    }

    public BranchNewDetailsOutputVO addNewBranchDetails(NewBranchDetailsInputVO newBranchDetailsInputVO) {
        return branchDetailsDAO.addNewBranchDetails(newBranchDetailsInputVO);
    }
}
