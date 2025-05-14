package com.bank.branch.eo;

import com.bank.branch.dao.BranchDetailsDAO;
import com.bank.branch.vo.BranchDetailsOutputVO;
import com.bank.branch.vo.BranchNewDetailsOutputVO;
import com.bank.branch.vo.NewBranchDetailsInputVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BranchDetailsEO {

    private static final Logger log = LoggerFactory.getLogger(BranchDetailsEO.class);

    @Autowired
    public BranchDetailsDAO branchDetailsDAO;

    public List<BranchDetailsOutputVO> getAllBranchDetails() {
        log.info("entity layer: calling to get all branch details");
        return branchDetailsDAO.getAllBranchDetails();
    }

    public BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode) {
        log.info("entity layer: calling to get branch details by ifsc code");
        return branchDetailsDAO.branchDetailsByIfscCode(ifscCode);
    }

    public BranchNewDetailsOutputVO addNewBranchDetails(NewBranchDetailsInputVO newBranchDetailsInputVO) {
        log.info("entity layer: calling to add new branch details");
        return branchDetailsDAO.addNewBranchDetails(newBranchDetailsInputVO);
    }
}
