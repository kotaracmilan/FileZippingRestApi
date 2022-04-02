package com.milan.demo.zip.service;

import java.io.File;

import com.milan.demo.zip.exceptions.CustomIOException;

/**
 * Defining data source. It could be either on file system or in the cloud.
 * @author Milan
 *
 */
public interface DataSource {

	/**
	 * Save file inside data store.
	 * Fila supplied is stored in temporary location, and needs to be saved in data storage for long term.
	 * @param file
	 * @return file name
	 * @throws CustomIOException - in case of catching any kind of IO exceptions
	 */
	public String saveFile(File file) throws CustomIOException;
	
	/**
	 * Obtain File object from data storage, based on supplied file name as String object
	 * @param name
	 * @throws CustomIOException - in case of catching any kind of IO exceptions
	 * @return file with the name
	 */
	public File getFile(String name) throws CustomIOException;
}
