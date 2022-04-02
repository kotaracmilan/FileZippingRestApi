package com.milan.demo.zip.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.milan.demo.zip.exceptions.CustomIOException;

/**
 * Implement compressing algorithm
 * 
 * @author Milan
 *
 */
public interface FileCompressionService {

	/**
	 * Return the name of the compression algorithm used
	 * 
	 * @return
	 */
	public String getCompressionAlgorithm();

	/**
	 * Returns compressed file from supplied MultipartFile array supplied
	 * 
	 * @param files
	 * @return
	 * @throws CustomIOException
	 */

	public File compressFiles(MultipartFile[] files) throws CustomIOException;
}
