package com.milan.demo.zip.service.implementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.milan.demo.zip.exceptions.CustomIOException;
import com.milan.demo.zip.service.FileCompressionService;

public class ZipFileCompression implements FileCompressionService {

	private String absouluteLocationOfTempDir;

	public ZipFileCompression() throws IOException {
		super();
		absouluteLocationOfTempDir = Paths.get(System.getProperty("java.io.tmpdir")).toAbsolutePath().toString();
	}

	@Override
	public String getCompressionAlgorithm() {
		return "zip";
	}

	@Override
	public File compressFiles(MultipartFile[] files) throws CustomIOException {
		String zipFileName = generateRandomName() + ".zip";
		try (FileOutputStream fos = new FileOutputStream(absouluteLocationOfTempDir + "/" + zipFileName);
				ZipOutputStream zipOut = new ZipOutputStream(fos);) {

			for (MultipartFile srcFile : files) {
				InputStream fis = srcFile.getInputStream();// new FileInputStream(fileToZip);
				ZipEntry zipEntry = new ZipEntry(srcFile.getOriginalFilename());
				zipOut.putNextEntry(zipEntry);

				byte[] bytes = new byte[1024];
				int length;
				while ((length = fis.read(bytes)) >= 0) {
					zipOut.write(bytes, 0, length);
				}
				fis.close();
			}

			zipOut.close();
			fos.close();

			return new File(zipFileName);
		}

		catch (Exception ex) {
			throw new CustomIOException(ex.getMessage());
		}

	}

///////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////// PRIVATE METHODS////////////////////////////////////////////////////////////

	private String generateRandomName() {
		StringBuilder sb = new StringBuilder();
		sb.append("file-").append(System.nanoTime()).append(new Random().nextInt());
		return sb.toString();
	}
}
