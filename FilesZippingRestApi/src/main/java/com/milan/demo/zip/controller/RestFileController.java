package com.milan.demo.zip.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.milan.demo.zip.exceptions.CustomIOException;
import com.milan.demo.zip.exceptions.UnsupportedAlgorithmException;
import com.milan.demo.zip.service.FileManager;
import com.milan.demo.zip.service.StatisticsService;

@RestController
@RequestMapping("files")
public class RestFileController {

	@Autowired
	private FileManager fileManager;

	@Autowired
	private StatisticsService statisticsService;

	@PostMapping
	public ResponseEntity<?> zipUploadedFiles(MultipartFile[] multipartFiles, HttpServletRequest request)
			throws CustomIOException, UnsupportedAlgorithmException {
		String ip = request.getRemoteAddr();
		statisticsService.addData(ip);

		Resource zipedFiles = fileManager.compressFiles(multipartFiles, "zip");

		return ResponseEntity.ok().contentType(MediaType.MULTIPART_FORM_DATA)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + zipedFiles.getFilename() + "\"")
				.body(zipedFiles);

	}
}
