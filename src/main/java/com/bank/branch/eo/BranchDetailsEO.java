package com.bank.branch.eo;

import com.bank.branch.dao.BranchDetailsDAO;
import com.bank.branch.vo.BranchDetailsOutputVO;
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
}
