package com.bank.branch.bo;

import com.bank.branch.eo.BranchDetailsEO;
import com.bank.branch.vo.BranchDetailsOutputVO;
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
}
