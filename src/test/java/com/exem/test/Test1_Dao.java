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
import com.exem.service.InsertRecordService;
import com.exem.service.InsertDustInfoService;
import com.exem.util.DustInfo;




@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(
	locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test1_Dao {
	@Autowired ApplicationContext context;
	
	@Autowired 
	DustDao dustDao;
	
	@Autowired
	InsertDustInfoService dustService;
	@Autowired
	InsertRecordService alertRecordService;
		
	DustInfo dust = new DustInfo();

	@Test	@Ignore
	public void insertDustInfo() {
		//db에 미세먼지 정보 data 저장
		System.out.println("========================================================");

		DustInfo dustInfo = new DustInfo();
		dustService.insertDustMeasurement(dustInfo.dustInfo());
	
	}	
	
	@Test	
	public void testDustInfo() {
		//경보 발령 정보 데이터 저장
		System.out.println("======================================================");
		//3월 미세먼지 전체 전체 data
		List<DustMeasurement> dustMeasurements = dustDao.readAllDustMeasurement();
		//경보 발령 기준 data
		List<AlertCriteria> alertCriteria = dustDao.readAllAlertCriteria();
		
		alertRecordService.insertAlertRecord(dustMeasurements, alertCriteria);
	}
	
	
	
}
