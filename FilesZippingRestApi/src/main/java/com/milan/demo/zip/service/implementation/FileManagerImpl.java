package com.milan.demo.zip.service.implementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.milan.demo.zip.exceptions.CustomIOException;
import com.milan.demo.zip.exceptions.UnsupportedAlgorithmException;
import com.milan.demo.zip.service.DataSource;
import com.milan.demo.zip.service.FileManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileManagerImpl implements FileManager {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private ZipFileCompression zipFileCompression;

	private String absouluteLocationOfTempDir;

	@PostConstruct
	public void init() throws IOException {
		absouluteLocationOfTempDir = Paths.get(System.getProperty("java.io.tmpdir")).toAbsolutePath().toString();
	}

	@Override
	public Resource compressFiles(MultipartFile[] files, String compressionAlgorithm)
			throws CustomIOException, UnsupportedAlgorithmException {

		if (!compressionAlgorithm.equals("zip"))
			throw new UnsupportedAlgorithmException("Unsuported algorithm");

		File zippedFile = zipFileCompression.compressFiles(files);

		for (MultipartFile mf : files) {
			File tmpFile = createFileFromMultiFile(mf);
			dataSource.saveFile(tmpFile);
		}

		return getFileAsResource(zippedFile.getName());
	}

	@Override
	public Resource getFileAsResource(String fileName) throws CustomIOException {

		Path filePath = Paths.get(absouluteLocationOfTempDir, fileName).toAbsolutePath().normalize();
		try {
			Resource resource = new UrlResource(filePath.toUri());
			return resource;
		} catch (Exception ex) {
			log.error("Error while creating resource for file " + filePath);
			throw new CustomIOException(ex.getMessage());
		}
	}

	private File createFileFromMultiFile(MultipartFile multipartFile) {
		// TODO: Implement method
		return null;
	}

}
