package com.exem.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exem.dao.DustDao;
import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;
import com.exem.service.AlertRecordService;
import com.exem.service.DustInfoInsertService;
import com.exem.util.DustInfo;




@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(
	locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test1_Dao {
	@Autowired ApplicationContext context;
	
	@Autowired 
	DustDao dustDao;
	
	@Autowired
	DustInfoInsertService dustService;
	@Autowired
	AlertRecordService alertRecordService;
		
	DustInfo dust = new DustInfo();

	@Test	@Ignore
	public void insertDustInfo() {
		System.out.println("========================================================");

		DustInfo dustInfo = new DustInfo();
		dustService.insertDustMeasurement(dustInfo.dustInfo());
	
	}
	
	@Test	
	public void testDustInfo() {
		System.out.println("=================???==?=====================================");
		List<DustMeasurement> dustMeasurements = dustDao.readAllDustMeasurement();
		List<AlertCriteria> alertCriteria = dustDao.readAllAlertCriteria();
		alertRecordService.insertAlertRecord(dustMeasurements, alertCriteria);
		System.out.println("=================???=======================================");		
	}
	
	
	
}
