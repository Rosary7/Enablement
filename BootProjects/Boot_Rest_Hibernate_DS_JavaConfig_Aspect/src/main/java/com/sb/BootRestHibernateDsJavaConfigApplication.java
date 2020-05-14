package com.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.aspect.EmpService;

@SpringBootApplication
public class BootRestHibernateDsJavaConfigApplication implements CommandLineRunner{

	@Autowired
	private EmpService empService;
	
	public static void main(String[] args) {
		SpringApplication.run(BootRestHibernateDsJavaConfigApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		 
		try {
			 empService.throwException();
		} catch (Exception e) {
			// Need not handle. We have handled with Aspect  
		}
 
	}
	
}
