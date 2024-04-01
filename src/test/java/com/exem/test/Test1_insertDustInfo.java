package com.exem.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exem.dao.DustDao;
import com.exem.service.InsertRecordService;
import com.exem.service.InsertDustInfoService;
import com.exem.util.ReadDustInfo;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(
	locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test1_insertDustInfo {
	@Autowired ApplicationContext context;
	
	@Autowired 
	DustDao dustDao;
	
	@Autowired
	InsertDustInfoService dustService;
	@Autowired
	InsertRecordService alertRecordService;
		
	ReadDustInfo dust = new ReadDustInfo();

	@Test	@Ignore
	public void insertDustInfo() {
		
		//db에 미세먼지 정보 data 저장
		System.out.println("========================================================");
		
		//미세먼지 정보 json 파일 Read
		ReadDustInfo dustInfo = new ReadDustInfo();
		
		//db에 전체 data 저장   		      //불러온 json 파일
		dustService.insertDustMeasurement(dustInfo.dustInfo());
	
	}	
		
	
}
