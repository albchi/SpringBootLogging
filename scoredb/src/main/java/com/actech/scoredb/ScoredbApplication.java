package com.actech.scoredb;



import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.sentry.Sentry;


/*

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
*/

/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

*/

@SpringBootApplication
@RestController // ADD THIS


public class ScoredbApplication {

	public static final Logger logger = LoggerFactory.getLogger(ScoredbApplication.class);

	// private static final Logger log = LoggerFactory.getLogger(ScoredbApplication.class);
	public static void main(String[] args) 
	throws ExecutionException, InterruptedException, IOException 
	{

		logger.info("XAC : Starting in main");
		   
		logger.trace("XAC Log level: TRACE");
        logger.info("XAC Log level: INFO");
        logger.debug("XAC Log level: DEBUG");
        logger.error("XAC Log level: ERROR");
        logger.warn("XAC Log level: WARN");

		SpringApplication.run(ScoredbApplication.class, args);
	}

	@GetMapping("/") // ENDPOINT first API is at slash // ADD THIS
    public String canBeAnything() {
		
		logger.info("XAC : in default endpoint");   

		return "Welcome to the Secrete Database. v0.1";
    }

	@GetMapping("/test") 
    public String testMsg() {
		int a = 1006, b;
		logger.info("XAC : in /test endpoint");   

		try {
			System.out.println(" Trying to print this message");
			b = a / 0;
		}
		catch (Exception e) {
			Sentry.captureException(e);
			System.out.println("Try failed with thie Exception" + e);
		}
   		return "Test OK!";
    }


}
