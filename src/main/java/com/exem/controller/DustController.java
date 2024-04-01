package com.exem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;
import com.exem.dto.InspectionRecord;
import com.exem.dto.SelectAlertRecord;
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
	
	
	
	@RequestMapping(value="/index.moon", method=RequestMethod.GET)
	   public String main(Model model) {
		   return "home";
	 }
	
	@RequestMapping(value="/insertDustInfo.moon", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> insertDustInfo(ReadDustInfo dustInfo) {
		Map<String, String> map = new HashMap<String, String>();
		int result = dustService.insertDustMeasurement(dustInfo.dustInfo());
		
		if(result == 1) {
			map.put("result", "dataInsertSuccess");
		}else if(result == 2){
			map.put("result", "dataExist");
		}else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@RequestMapping(value="/insertRecord.moon", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> insertRecord(Model model) {
		Map<String, String> map = new HashMap<String, String>();
		//3월 미세먼지 전체 전체 data
		List<DustMeasurement> dustMeasurements = selectRecordService.readAllDustMeasurement();
		//경보 발령 기준 data
		List<AlertCriteria> alertCriteria = selectRecordService.readAllAlertCriteria();
		
		int result = insertRecordService.insertAlertRecord(dustMeasurements,alertCriteria);
		
		if(result == 1) {
			map.put("result", "dataInsertSuccess");
		}else if(result == 2){
			map.put("result", "dataExist");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}
	
	@RequestMapping(value="/selectRecord.moon", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectAlertRecord> selectRecord(@RequestParam("alertCriteria") String alertCriteria,
	                                            @RequestParam("measurementStation") String measurementStation) {
		Map<String, Object> para = new HashMap<>();
		para.put("station_name", measurementStation);
		para.put("grade", alertCriteria);
	    List<SelectAlertRecord> records = selectRecordService.selectAlertRecord(para);
	    return records;
	}

	
	@RequestMapping(value="/selectInspectionRecord.moon", method = RequestMethod.GET)
	@ResponseBody
	public List<InspectionRecord> selectInspectionRecord(@RequestParam("inspectionStation") String inspectionStation) {
		System.out.println(inspectionStation);
		Map<String, Object> para = new HashMap<>();
		para.put("station_name", inspectionStation);
	    List<InspectionRecord> records = selectRecordService.inspectionSelectAlertRecord(para);
	    return records;
	}

	
}
