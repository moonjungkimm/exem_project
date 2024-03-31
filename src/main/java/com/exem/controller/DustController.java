package com.exem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exem.dao.DustDao;
import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;
import com.exem.service.AlertService;
import com.exem.service.InsertDustInfoService;
import com.exem.service.InsertRecordService;
import com.exem.service.SelectRecordService;
import com.exem.util.ReadDustInfo;

@Controller
public class DustController {
	
	@Autowired
	InsertDustInfoService dustService;
	
	@Autowired
	InsertRecordService insertRecordService;

	@Autowired
	SelectRecordService selectRecordService;
	
	@Autowired
	AlertService alertService;
	
	@RequestMapping(value="/index.moon", method=RequestMethod.GET)
	   public String main(Model model) {
		   return "/home";
	 }
	
	@RequestMapping(value="/insertDustInfo.moon", method = RequestMethod.GET)
	public String insertDustInfo(ReadDustInfo dustInfo, Model model) {
		if(dustService.insertDustMeasurement(dustInfo.dustInfo()) == true) {
			model.addAttribute("result", "success");
		}else {
			model.addAttribute("result", "fail");
		}
		return "insertDustInfo";
	}
	
	@RequestMapping(value="/insertRecord.moon", method = RequestMethod.GET)
	@ResponseBody
	public String insertRecord(Model model) {
		//3월 미세먼지 전체 전체 data
		List<DustMeasurement> dustMeasurements = selectRecordService.readAllDustMeasurement();
		//경보 발령 기준 data
		List<AlertCriteria> alertCriteria = selectRecordService.readAllAlertCriteria();
		
		if(insertRecordService.insertAlertRecord(dustMeasurements,alertCriteria) == true){
			model.addAttribute("result", "success");
		}else {
			model.addAttribute("result", "fail");
		}
		
		
		return "insertDustInfo";
	}
	
}
