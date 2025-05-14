package com.bank.branch.bo;

import com.bank.branch.eo.BranchDetailsEO;
import com.bank.branch.vo.BranchDetailsOutputVO;
import com.bank.branch.vo.BranchNewDetailsOutputVO;
import com.bank.branch.vo.NewBranchDetailsInputVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BranchDetailsBO {

    private static final Logger log = LoggerFactory.getLogger(BranchDetailsBO.class);

    @Autowired
    public BranchDetailsEO branchDetailsEO;
    public List<BranchDetailsOutputVO> getAllBranchDetails() {
        log.info("business layer: calling to get all branch details");
        return branchDetailsEO.getAllBranchDetails();
    }

    public BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode) {
        log.info("business layer: calling to get branch details by ifsc code");
        return branchDetailsEO.branchDetailsByIfscCode(ifscCode);
    }

    public BranchNewDetailsOutputVO addNewBranchDetails(NewBranchDetailsInputVO newBranchDetailsInputVO) {
        log.info("business layer: calling to add new branch details");
        return branchDetailsEO.addNewBranchDetails(newBranchDetailsInputVO);
    }
}
