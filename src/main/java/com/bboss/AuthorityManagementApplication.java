package com.bboss;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import com.bboss.config.SessionManagerListener;


@SpringBootApplication
@ServletComponentScan
//@EnableEurekaClient
public class AuthorityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorityManagementApplication.class, args);
	}
	
	
	
	
}
