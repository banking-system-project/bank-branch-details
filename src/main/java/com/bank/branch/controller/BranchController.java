package com.bank.branch.controller;

import com.bank.branch.dto.BranchDetailsOutputDTO;
import com.bank.branch.service.BranchDetailsServiceImpl;
import com.bank.branch.vo.BranchDetailsOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/branch")
public class BranchController {

    @Autowired
    BranchDetailsServiceImpl branchDetailsService;
    @GetMapping("/test")
    public String test(){
        return "Hello world";
    }

    @PostMapping("/getAllBranchDetails")
    public ResponseEntity<Object> getAllBranchDetails() {
        List<BranchDetailsOutputVO> branchDetailsOutputVOList= branchDetailsService.getAllBranchDetails();
        return new ResponseEntity<>(branchDetailsOutputVOList, HttpStatus.OK);
    }
    @GetMapping("/branchDetailsByIfscCode")
    public ResponseEntity<Object> branchDetailsByIfscCode(@RequestParam String ifscCode){
        BranchDetailsOutputVO branchDetailsOutputVO=branchDetailsService.branchDetailsByIfscCode(ifscCode);
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }

}
