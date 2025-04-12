package com.bank.branch.mapper;

import com.bank.branch.dto.BranchDetailsOutputDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GetBranchDetailsOutputMapper implements RowMapper {
    public BranchDetailsOutputDTO mapRow(ResultSet rs,int rowNo) throws SQLException{
        BranchDetailsOutputDTO branchDetailsOutputDTO=new BranchDetailsOutputDTO();
        branchDetailsOutputDTO.setIfscCode(rs.getString("IFSC_CODE"));
        branchDetailsOutputDTO.setBankCode(rs.getString("BANK_CODE"));
        branchDetailsOutputDTO.setBranchName(rs.getString("BRANCH_NAME"));
        branchDetailsOutputDTO.setAddress(rs.getString("ADDRESS"));
        branchDetailsOutputDTO.setDistrict(rs.getString("DISTRICT"));
        branchDetailsOutputDTO.setState(rs.getString("STATE"));
        branchDetailsOutputDTO.setPinCode(rs.getString("PIN_CODE"));
        branchDetailsOutputDTO.setBankContactNo(rs.getString("BANK_CONTACT"));
        branchDetailsOutputDTO.setBranchEmail(rs.getString("BRANCH_EMAIL"));
        branchDetailsOutputDTO.setDateOfIssue(rs.getDate("DATE_OF_ISSUE"));

        return branchDetailsOutputDTO;
    }
}
