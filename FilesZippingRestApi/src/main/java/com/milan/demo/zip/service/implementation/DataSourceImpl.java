package com.milan.demo.zip.service.implementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.milan.demo.zip.exceptions.CustomIOException;
import com.milan.demo.zip.service.DataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataSourceImpl implements DataSource {

	@Value("${file.permanent-directory}")
	private String baseDirLocation;

	@PostConstruct
	public void init() {
		try {
			if (!Files.exists(Paths.get(baseDirLocation))) {
				log.info("Directory does not exists - creating: " + baseDirLocation);
				Files.createDirectories(Paths.get(baseDirLocation));
			}
		} catch (Exception ex) {
			log.error("Error creating BaseDir: " + ex.getMessage());
			throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
		}
	}

	@Override
	public String saveFile(File file) throws CustomIOException {

		try {
			Files.copy(file.toPath(), Paths.get(baseDirLocation, file.getName()).toAbsolutePath(),
					StandardCopyOption.REPLACE_EXISTING);
			log.info("Saved file to storage: " + file.getName());
		} catch (IOException exception) {
			log.error(exception.getMessage());
			throw new CustomIOException(exception);
		}
		return file.getName();
	}

	@Override
	public File getFile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
