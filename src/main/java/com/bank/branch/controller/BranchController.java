package com.bank.branch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {

    @GetMapping("/bank/branch/test")
    public String test(){
        return "Hello world";
    }
}
