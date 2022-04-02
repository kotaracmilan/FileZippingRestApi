package com.milan.demo.zip;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.milan.demo.zip.model.UsageId;
import com.milan.demo.zip.model.UsageStatistics;
import com.milan.demo.zip.repository.UsageStatisticsRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class JUnitTestRepository {

	@Resource
	UsageStatisticsRepository repo;

	@Test
	void testPersisting() {

		UsageId id = UsageId.builder().ip("1.1.1.1").date(new Date()).build();
		UsageStatistics us = UsageStatistics.builder().count(1).usageId(id).build();

		UsageStatistics persisted = repo.save(us);

		assertEquals(us.getCount(), persisted.getCount());

	}
}
