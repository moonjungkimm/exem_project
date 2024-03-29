package com.exem.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exem.dao.DustDao;
import com.exem.dto.MeasurementStation;
import com.exem.service.DustService;
import com.exem.util.DustInfo;




@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(
	locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test1_Dao {
	@Autowired ApplicationContext context;
	
	@Autowired 
	DustDao dao;
	
	@Autowired
	DustService dustService;
		
	DustInfo dust = new DustInfo();

	@Test
	public void testDustInfo() {
		System.out.println("========================================================");

		DustInfo dustInfo = new DustInfo();
		dustService.insertDustMeasurement(dustInfo.dustInfo());
	
		
	}
	
	@Test @Ignore
	public void test0() {
		System.out.println("========================================================");
//		dust.dustInfo();
		
		MeasurementStation measurementStation = new MeasurementStation();
		measurementStation.setStation_code(111121);
		measurementStation.setStation_name("중구");
		
		System.out.println(dao.insertMeasurementStation(measurementStation));
		
	}
	
	
	
	
}
