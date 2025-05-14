package com.bank.branch.controller;

import com.bank.branch.service.BranchDetailsServiceImpl;
import com.bank.branch.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/branch")
public class BranchController {

    private static final Logger log = LoggerFactory.getLogger(BranchController.class);

    @Autowired
    BranchDetailsServiceImpl branchDetailsService;

    @PostMapping("/getAllBranchDetails")
    public ResponseEntity<Object> getAllBranchDetails() {
        log.info("controller layer: calling to get all branch details");
        List<BranchDetailsOutputVO> branchDetailsOutputVOList= branchDetailsService.getAllBranchDetails();
        log.info("controller layer: returning all branch details");
        return new ResponseEntity<>(branchDetailsOutputVOList, HttpStatus.OK);
    }
    @GetMapping("/branchDetailsByIfscCode")
    public ResponseEntity<Object> branchDetailsByIfscCode(@RequestParam String ifscCode){
        log.info("controller layer: calling to get branch details by ifsc code");
        BranchDetailsOutputVO branchDetailsOutputVO=branchDetailsService.branchDetailsByIfscCode(ifscCode);
        log.info("controller layer: returning branch details by ifsc code");
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }
    @GetMapping("/branchContactByIfscCode")
    public ResponseEntity<Object> branchContactByIfscCode(@RequestParam String ifscCode){
        log.info("controller layer: calling to get branch contact by ifsc code");
        BranchContactVO branchDetailsOutputVO=branchDetailsService.branchContactByIfscCode(ifscCode);
        log.info("controller layer: returning branch contact by ifsc code");
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }
    @GetMapping("/branchAddressByIfscCode")
    public ResponseEntity<Object> branchAddressByIfscCode(@RequestParam String ifscCode){
        log.info("controller layer: calling to get branch address by ifsc code");
        BranchAddressVO branchDetailsOutputVO=branchDetailsService.branchAddressByIfscCode(ifscCode);
        log.info("controller layer: returning branch address by ifsc code");
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }

    @PostMapping("/addNewBranchDetails")
    public ResponseEntity<Object> addNewBranchDetails(@RequestBody NewBranchDetailsInputVO newBranchDetailsInputVO){
        log.info("controller layer: calling to add new branch details");
        BranchNewDetailsOutputVO newBranchDetailsOutputVO = branchDetailsService.addNewBranchDetail(newBranchDetailsInputVO);
        log.info("controller layer: Added new branch details");
        return new ResponseEntity<>(newBranchDetailsOutputVO, HttpStatus.OK);
    }

}
