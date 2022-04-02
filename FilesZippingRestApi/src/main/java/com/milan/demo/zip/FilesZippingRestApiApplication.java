package com.milan.demo.zip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
		exclude = DataSourceAutoConfiguration.class)

public class FilesZippingRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilesZippingRestApiApplication.class, args);
	}

}
