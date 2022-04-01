package com.milan.demo.zip.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("files")
public class RestFileController {

	@PostMapping
	public ResponseEntity<?> zipUploadedFiles(@RequestParam("files") MultipartFile[] multipartFiles, HttpServletRequest request) {
		//TODO: Implement logic
		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}
}
