package com.bank.branch.controller;

import com.bank.branch.service.BranchDetailsServiceImpl;
import com.bank.branch.service.KafkaServiceImpl;
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

    @Autowired
    KafkaServiceImpl kafkaService;

    @PostMapping("/getAllBranchDetails")
    public ResponseEntity<Object> getAllBranchDetails() {
        log.info("controller layer: calling to get all branch details");
        List<BranchDetailsOutputVO> branchDetailsOutputVOList= branchDetailsService.getAllBranchDetails();
        BranchEventVO branchEvent = new BranchEventVO();
        log.info("controller layer: creating an event for getting all branch details");
        branchEvent.setMessage(branchDetailsOutputVOList.toString()+" is fetched successfully");
        log.info("controller layer: sending event for getting all branch details");
        kafkaService.sendMessage(branchEvent);
        log.info("controller layer: returning all branch details");
        return new ResponseEntity<>(branchDetailsOutputVOList, HttpStatus.OK);
    }
    @GetMapping("/branchDetailsByIfscCode")
    public ResponseEntity<Object> branchDetailsByIfscCode(@RequestParam String ifscCode){
        log.info("controller layer: calling to get branch details by ifsc code");
        BranchDetailsOutputVO branchDetailsOutputVO=branchDetailsService.branchDetailsByIfscCode(ifscCode);
        BranchEventVO branchEvent = new BranchEventVO();
        log.info("controller layer: creating an event for getting branch details");
        branchEvent.setMessage("Branch "+branchDetailsOutputVO.getBranchInfoVO().getBranchName()+" is fetched successfully using "+ifscCode);
        branchEvent.setStatus("completed");
        log.info("controller layer: sending event for getting branch details");
        kafkaService.sendMessage(branchEvent);
        log.info("controller layer: returning branch details by ifsc code");
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }
    @GetMapping("/branchContactByIfscCode")
    public ResponseEntity<Object> branchContactByIfscCode(@RequestParam String ifscCode){
        log.info("controller layer: calling to get branch contact by ifsc code");
        BranchContactVO branchDetailsOutputVO=branchDetailsService.branchContactByIfscCode(ifscCode);
        BranchEventVO branchEvent = new BranchEventVO();
        log.info("controller layer: creating an event for getting branch contact");
        branchEvent.setMessage("Branch "+branchDetailsOutputVO.getBranchEmail()+
                " & "+branchDetailsOutputVO.getBankContactNo()+ "is fetched successfully using "+ifscCode);
        branchEvent.setStatus("completed");
        log.info("controller layer: sending event for getting branch contact details");
        kafkaService.sendMessage(branchEvent);
        log.info("controller layer: returning branch contact by ifsc code");
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }
    @GetMapping("/branchAddressByIfscCode")
    public ResponseEntity<Object> branchAddressByIfscCode(@RequestParam String ifscCode){
        log.info("controller layer: calling to get branch address by ifsc code");
        BranchAddressVO branchDetailsOutputVO=branchDetailsService.branchAddressByIfscCode(ifscCode);
        BranchEventVO branchEvent = new BranchEventVO();
        log.info("controller layer: creating an event for getting branch address details");
        branchEvent.setMessage("Branch "+branchDetailsOutputVO.getAddress()+" & "+branchDetailsOutputVO.getPinCode()+" & "+branchDetailsOutputVO.getDistrict()+" is fetched successfully using "+ifscCode);
        branchEvent.setStatus("completed");
        log.info("controller layer: sending event for getting branch address details");
        kafkaService.sendMessage(branchEvent);
        log.info("controller layer: returning branch address by ifsc code");
        return new ResponseEntity<>(branchDetailsOutputVO, HttpStatus.OK);
    }

    @PostMapping("/addNewBranchDetails")
    public ResponseEntity<Object> addNewBranchDetails(@RequestBody NewBranchDetailsInputVO newBranchDetailsInputVO){
        log.info("controller layer: calling to add new branch details");
        BranchNewDetailsOutputVO newBranchDetailsOutputVO = branchDetailsService.addNewBranchDetail(newBranchDetailsInputVO);
        log.info("controller layer: Added new branch details");
        BranchEventVO branchEvent = new BranchEventVO();
        log.info("controller layer: creating an event for new branch details");
        branchEvent.setMessage("New Branch "+newBranchDetailsInputVO.getBranchInfoVO().getBranchName()+" added successfully");
        branchEvent.setStatus("completed");
        log.info("controller layer: sending event for new branch details");
        kafkaService.sendMessage(branchEvent);
        log.info("controller layer: returning new branch details");
        return new ResponseEntity<>(newBranchDetailsOutputVO, HttpStatus.OK);
    }

}
