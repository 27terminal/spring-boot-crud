package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private static final Logger log4Logger = LogManager.getLogger(DemoApplication.class);
    private static final org.slf4j.Logger sfl4Logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		log4Logger.error("log4j logging");
		sfl4Logger.error("slf4j loggin");
	}
}
