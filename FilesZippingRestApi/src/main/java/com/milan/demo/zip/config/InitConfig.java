package com.milan.demo.zip.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.milan.demo.zip.service.implementation.ZipFileCompression;

@Configuration
public class InitConfig {

	@Bean
	public ZipFileCompression initZipFileCompression() throws IOException {
		return new ZipFileCompression();
	}
}
