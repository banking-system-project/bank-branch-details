package com.bank.branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankBranchDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankBranchDetailsApplication.class, args);
	}


}
