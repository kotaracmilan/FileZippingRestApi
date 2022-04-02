package com.milan.demo.zip;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.milan.demo.zip.exceptions.CustomIOException;
import com.milan.demo.zip.model.UsageStatistics;
import com.milan.demo.zip.service.DataSource;
import com.milan.demo.zip.service.FileManager;
import com.milan.demo.zip.service.StatisticsService;

@ExtendWith(MockitoExtension.class)
public class JUnitTestService {

	@Mock
	private FileManager fmi;

	@Mock
	private DataSource dataSource;

	@Mock
	private StatisticsService statisticsService;

	File file1, file2;

	@Test
	public void testFileManager() throws Exception {
		MockMultipartFile file = new MockMultipartFile("file", "hello.txt", MediaType.TEXT_PLAIN_VALUE,
				"Hello, World!".getBytes());

		MultipartFile fim[] = { file };
		Resource res = fmi.compressFiles(fim, "zip");

		assertNotNull(res);
	}

	@Test
	public void testDataSource() throws IOException, CustomIOException {
		File file = new File("test.txt");
		String name = dataSource.saveFile(file);
		File obtainedFiel = dataSource.getFile(name);

		assertTrue(!obtainedFiel.exists());

		file.delete();
	}

	@Test
	void testStatisticService() {
		Date dateTest = new Date();

		UsageStatistics us1 = statisticsService.addData("1.1.1.1");
		UsageStatistics us2 = statisticsService.getStatisticsForIpAndDate("1.1.1.1", dateTest);

		assertEquals(us1.getCount(), us2.getCount());

	}
}
