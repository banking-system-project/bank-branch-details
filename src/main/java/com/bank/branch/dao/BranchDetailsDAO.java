package com.bank.branch.dao;

import com.bank.branch.dto.BranchDetailsOutputDTO;
import com.bank.branch.mapper.GetBranchDetailsOutputMapper;
import com.bank.branch.mapper.GetbranchDetailsSpecificMapper;
import com.bank.branch.util.SqlQueriesConstants;
import com.bank.branch.vo.BranchDetailsOutputVO;
import com.bank.branch.vo.BranchNewDetailsOutputVO;
import com.bank.branch.vo.NewBranchDetailsInputVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Repository
public class BranchDetailsDAO {

    private static final Logger log = LoggerFactory.getLogger(BranchDetailsDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private GetbranchDetailsSpecificMapper getbranchDetailsSpecificMapper;
    @Autowired
    private GetBranchDetailsOutputMapper getBranchDetailsOutputMapper;
    public List<BranchDetailsOutputVO> getAllBranchDetails() {
        log.info("dao layer: calling to get all branch details");
        List<BranchDetailsOutputDTO> branchDetailsOutputDTOList=null;
        try{
            log.info("dao layer: calling sql query to get all branch details");
            branchDetailsOutputDTOList=(List<BranchDetailsOutputDTO>) jdbcTemplate.query(SqlQueriesConstants.SQL_GET_BRANCH_DETAILS,getBranchDetailsOutputMapper);
            log.info("dao layer: returning all branch details by calling sql query");
        }catch(Exception e){
            log.error("dao layer: error in getting all branch details");
            log.error(e.getMessage());
        }
        log.info("dao layer: returning all branch details");
        return getbranchDetailsSpecificMapper.branchDetailsOutputDTOtoVO(branchDetailsOutputDTOList);
    }

    public BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode) {
        log.info("dao layer: calling to get branch details by ifsc code");
        BranchDetailsOutputDTO branchDetailsOutputDTO = null;
        try{
            log.info("dao layer: calling sql query to get branch details by ifsc code");
            branchDetailsOutputDTO = (BranchDetailsOutputDTO) jdbcTemplate.queryForObject(SqlQueriesConstants.SQL_GET_BRANCH_DETAILS_BY_IFSC_CODE, new Object[] {ifscCode},getBranchDetailsOutputMapper);
            log.info("dao layer: returning branch details by calling sql query");
        }catch (Exception e){
            log.error("dao layer: error in getting branch details by ifsc code");
            log.error(e.getMessage());
        }
        log.info("dao layer: returning branch details");
        return  getbranchDetailsSpecificMapper.branchDetailsOutputDTOtoVO(branchDetailsOutputDTO);
    }

    public BranchNewDetailsOutputVO addNewBranchDetails(NewBranchDetailsInputVO newBranchDetailsInputVO){
        log.info("dao layer: calling to add new branch details");
        BranchNewDetailsOutputVO branchNewDetailsOutputVO = new BranchNewDetailsOutputVO();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTimeStamp = now.format(formatter);

        int result=0;

        try{
            log.info("dao layer: calling sql query to add new branch details");
            result = jdbcTemplate.update(
                    SqlQueriesConstants.SQL_ADD_NEW_BRANCH_DETAILS,
                    new Object[] {
                            newBranchDetailsInputVO.getBranchInfoVO().getBankCode(),
                            newBranchDetailsInputVO.getBranchInfoVO().getIfscCode(),
                            newBranchDetailsInputVO.getBranchInfoVO().getBranchName(),
                            newBranchDetailsInputVO.getBranchAddressVO().getAddress(),
                            newBranchDetailsInputVO.getBranchAddressVO().getDistrict(),
                            newBranchDetailsInputVO.getBranchAddressVO().getState(),
                            newBranchDetailsInputVO.getBranchAddressVO().getPinCode(),
                            newBranchDetailsInputVO.getBranchContactVO().getBankContactNo(),
                            newBranchDetailsInputVO.getBranchContactVO().getBranchEmail(),
                            currentTimeStamp
                    }
            );
            if(result == 1){
                log.info("dao layer: branch details added successfully");
                branchNewDetailsOutputVO.setStatusMsg("branch details updated successfully");
            }
            else {
                log.error("dao layer: error in adding branch details");
                branchNewDetailsOutputVO.setStatusMsg("Something Wrong!!");
            }

        }catch (Exception e){
            branchNewDetailsOutputVO.setStatusMsg(e.getMessage());
            log.error("dao layer: exception in adding branch details");
            throw new RuntimeException(e.getMessage());
        }
        log.info("dao layer: successfully added new branch details");
        return branchNewDetailsOutputVO;
    }
}
