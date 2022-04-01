package com.milan.demo.zip.service;

import java.io.File;

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
	 */
	public void saveFile(File file);
	
	/**
	 * Obtain File object from data storage, based on supplied file name as String object
	 * @param name
	 * @return
	 */
	public File getFile(String name);
}
