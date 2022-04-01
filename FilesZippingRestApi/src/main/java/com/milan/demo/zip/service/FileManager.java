package com.milan.demo.zip.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Managing business logic with files.
 * Currently only handling zipping process
 * 
 * 
 * @author Milan
 *
 */
public interface FileManager {

	
	/**
	 * Zip supplied MultipartFile array, and returns Resource object to zipped file.
	 * ZipFile is named randomly generated.
	 * 
	 * @param files - MultipartFile array
	 * @return ZipFile - compressed zip file
	 */
	public Resource compressFiles(MultipartFile[] files) throws Exception;
	
	
}
