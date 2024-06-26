package com.exem.service;

import java.util.List;
import java.util.Map;

import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;
import com.exem.dto.InspectionRecord;
import com.exem.dto.SelectAlertRecord;

public interface SelectRecordService {
		
	//측정한 미세먼지 데이터 전부 
	public List<DustMeasurement> readAllDustMeasurement();
	
	//경보 발령 기준 및 등급
	public List<AlertCriteria> readAllAlertCriteria();	
	
	//정보 발령 정보 List
	public List<SelectAlertRecord> selectAlertRecord(Map<String, Object> para);
	
	//측정소 점검 정보 List
	public List<InspectionRecord> inspectionSelectAlertRecord(Map<String, Object> para);
}
