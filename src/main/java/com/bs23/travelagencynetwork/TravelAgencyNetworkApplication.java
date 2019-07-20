package com.bs23.travelagencynetwork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.bs23.travelagencynetwork")
public class TravelAgencyNetworkApplication {
	private static final Logger logger = LogManager.getLogger(TravelAgencyNetworkApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TravelAgencyNetworkApplication.class, args);
	}
}
