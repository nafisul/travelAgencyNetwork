package com.bs23.travelagencynetwork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelagencynetworkApplication {
	private static final Logger logger = LogManager.getLogger(TravelagencynetworkApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TravelagencynetworkApplication.class, args);
	}
}
