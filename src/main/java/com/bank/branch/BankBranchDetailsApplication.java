package com.bank.branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class BankBranchDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankBranchDetailsApplication.class, args);
	}


}
