package com.bank.branch.dao;

import com.bank.branch.dto.BranchDetailsOutputDTO;
import com.bank.branch.mapper.GetBranchDetailsOutputMapper;
import com.bank.branch.mapper.GetbranchDetailsSpecificMapper;
import com.bank.branch.util.SqlQueriesConstants;
import com.bank.branch.vo.BranchDetailsOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
