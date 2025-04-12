package com.bank.branch.controller;

import com.bank.branch.service.BranchDetailsServiceImpl;
import com.bank.branch.vo.*;
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
    @GetMapping("/branchContactByIfscCode")
    public ResponseEntity<Object> branchContactByIfscCode(@RequestParam String ifscCode){
        BranchContactVO branchDetailsOutputVO=branchDetailsService.branchContactByIfscCode(ifscCode);
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }
    @GetMapping("/branchAddressByIfscCode")
    public ResponseEntity<Object> branchAddressByIfscCode(@RequestParam String ifscCode){
        BranchAddressVO branchDetailsOutputVO=branchDetailsService.branchAddressByIfscCode(ifscCode);
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }

    @PostMapping("/addNewBranchDetails")
    public ResponseEntity<Object> addNewBranchDetails(@RequestBody NewBranchDetailsInputVO newBranchDetailsInputVO){
        BranchNewDetailsOutputVO newBranchDetailsOutputVO = branchDetailsService.addNewBranchDetail(newBranchDetailsInputVO);
        return new ResponseEntity<>(newBranchDetailsOutputVO, HttpStatus.OK);
    }

}
