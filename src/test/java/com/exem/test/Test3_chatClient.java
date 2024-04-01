package com.exem.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exem.service.AlarmService;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(
	locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Test3_chatClient {
	@Autowired ApplicationContext context;
	
	@Autowired
	AlarmService alarmService;
	
	
	@Test 	@Ignore
    public void testAlertServer() {
		
      alarmService.server();
    }
	
	@Test 	//@Ignore
    public void testAlertClient() {
		
      alarmService.client();
      
    }

	
	
}
