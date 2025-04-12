package com.bank.branch.mapper;

import com.bank.branch.dto.BranchDetailsOutputDTO;
import com.bank.branch.vo.BranchAddressVO;
import com.bank.branch.vo.BranchContactVO;
import com.bank.branch.vo.BranchDetailsOutputVO;
import com.bank.branch.vo.BranchInfoVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GetbranchDetailsSpecificMapper {

    public List<BranchDetailsOutputVO> branchDetailsOutputDTOtoVO(List<BranchDetailsOutputDTO> branchDetailsOutputDTOList){
        if(branchDetailsOutputDTOList ==null){
            return null;
        }
        List<BranchDetailsOutputVO> list=new ArrayList<>(branchDetailsOutputDTOList.size());
        for(BranchDetailsOutputDTO branchDetailsOutputDTO:branchDetailsOutputDTOList){

            BranchAddressVO branchAddressVO=new BranchAddressVO();
            BranchContactVO branchContactVO=new BranchContactVO();
            BranchInfoVO branchInfoVO=new BranchInfoVO();
            BranchDetailsOutputVO branchDetailsOutputVO=new BranchDetailsOutputVO();
            //map address details

            branchAddressVO.setAddress(branchDetailsOutputDTO.getAddress());
            branchAddressVO.setDistrict(branchDetailsOutputDTO.getDistrict());
            branchAddressVO.setState(branchDetailsOutputDTO.getState());
            branchAddressVO.setPinCode(branchDetailsOutputDTO.getPinCode());
            //map contact details
            branchContactVO.setBranchEmail(branchDetailsOutputDTO.getBranchEmail());
            branchContactVO.setBankContactNo(branchDetailsOutputDTO.getBankContactNo());
            //map info details
            branchInfoVO.setBranchName(branchDetailsOutputDTO.getBranchName());
            branchInfoVO.setBankCode(branchDetailsOutputDTO.getBankCode());
            branchInfoVO.setIfscCode(branchDetailsOutputDTO.getIfscCode());

            branchDetailsOutputVO.setBranchAddressVO(branchAddressVO);
            branchDetailsOutputVO.setBranchInfoVO(branchInfoVO);
            branchDetailsOutputVO.setBranchContactVO(branchContactVO);
            System.out.println(branchDetailsOutputVO.toString());

            list.add(branchDetailsOutputVO);

        }
        return list;
    }

    public BranchDetailsOutputVO branchDetailsOutputDTOtoVO(BranchDetailsOutputDTO branchDetailsOutputDTO){
        BranchAddressVO branchAddressVO=new BranchAddressVO();
        BranchContactVO branchContactVO=new BranchContactVO();
        BranchInfoVO branchInfoVO=new BranchInfoVO();
        BranchDetailsOutputVO branchDetailsOutputVO=new BranchDetailsOutputVO();
        //map address details

        branchAddressVO.setAddress(branchDetailsOutputDTO.getAddress());
        branchAddressVO.setDistrict(branchDetailsOutputDTO.getDistrict());
        branchAddressVO.setState(branchDetailsOutputDTO.getState());
        branchAddressVO.setPinCode(branchDetailsOutputDTO.getPinCode());
        //map contact details
        branchContactVO.setBranchEmail(branchDetailsOutputDTO.getBranchEmail());
        branchContactVO.setBankContactNo(branchDetailsOutputDTO.getBankContactNo());
        //map info details
        branchInfoVO.setBranchName(branchDetailsOutputDTO.getBranchName());
        branchInfoVO.setBankCode(branchDetailsOutputDTO.getBankCode());
        branchInfoVO.setIfscCode(branchDetailsOutputDTO.getIfscCode());

        branchDetailsOutputVO.setBranchAddressVO(branchAddressVO);
        branchDetailsOutputVO.setBranchInfoVO(branchInfoVO);
        branchDetailsOutputVO.setBranchContactVO(branchContactVO);

        return branchDetailsOutputVO;
    }
}
