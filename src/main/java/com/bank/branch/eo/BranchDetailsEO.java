package com.bank.account.info.eo;

import com.bank.account.info.dao.BranchDetailsDAO;
import com.bank.account.info.vo.BranchDetailsOutputVO;
import com.bank.account.info.vo.BranchNewDetailsOutputVO;
import com.bank.account.info.vo.NewBranchDetailsInputVO;
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
