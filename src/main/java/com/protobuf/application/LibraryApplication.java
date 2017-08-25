package com.protobuf.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.protobuf"})
public class LibraryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	
}
