package com.bank.account.info.dao;

import com.bank.account.info.dto.BranchDetailsOutputDTO;
import com.bank.account.info.mapper.GetBranchDetailsOutputMapper;
import com.bank.account.info.mapper.GetbranchDetailsSpecificMapper;
import com.bank.account.info.util.SqlQueriesConstants;
import com.bank.account.info.vo.BranchDetailsOutputVO;
import com.bank.account.info.vo.BranchNewDetailsOutputVO;
import com.bank.account.info.vo.NewBranchDetailsInputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Repository
public class BranchDetailsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private GetbranchDetailsSpecificMapper getbranchDetailsSpecificMapper;
    @Autowired
    private GetBranchDetailsOutputMapper getBranchDetailsOutputMapper;
    public List<BranchDetailsOutputVO> getAllBranchDetails() {
        List<BranchDetailsOutputDTO> branchDetailsOutputDTOList=null;
        try{
            branchDetailsOutputDTOList=(List<BranchDetailsOutputDTO>) jdbcTemplate.query(SqlQueriesConstants.SQL_GET_BRANCH_DETAILS,getBranchDetailsOutputMapper);


        }catch(Exception e){
            e.printStackTrace();
        }
        return getbranchDetailsSpecificMapper.branchDetailsOutputDTOtoVO(branchDetailsOutputDTOList);
    }

    public BranchDetailsOutputVO branchDetailsByIfscCode(String ifscCode) {
        BranchDetailsOutputDTO branchDetailsOutputDTO = null;
        try{
            branchDetailsOutputDTO = (BranchDetailsOutputDTO) jdbcTemplate.queryForObject(SqlQueriesConstants.SQL_GET_BRANCH_DETAILS_BY_IFSC_CODE, new Object[] {ifscCode},getBranchDetailsOutputMapper);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  getbranchDetailsSpecificMapper.branchDetailsOutputDTOtoVO(branchDetailsOutputDTO);
    }

    public BranchNewDetailsOutputVO addNewBranchDetails(NewBranchDetailsInputVO newBranchDetailsInputVO){
        BranchNewDetailsOutputVO branchNewDetailsOutputVO = new BranchNewDetailsOutputVO();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTimeStamp = now.format(formatter);

        int result=0;
        System.out.println("In DAO layer");
        try{
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
                System.out.println("done");
                branchNewDetailsOutputVO.setStatusMsg("user details updated successfully");
            }
            else {
                branchNewDetailsOutputVO.setStatusMsg("Something Wrong!!");
            }

        }catch (Exception e){
            branchNewDetailsOutputVO.setStatusMsg(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        return branchNewDetailsOutputVO;
    }
}
