package org.prk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource({"classpath*:applicationContext.xml","classpath*:applicationSecurity.xml"}) 
public class Starter {

	
	public static void main(String[] args) {
		
		   ApplicationContext ctx = SpringApplication.run(Starter.class, args);
	}
}
