package com.exem.service;

import java.util.List;

import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;

public interface InsertRecordService {
		
	//경보 발령 정보 insert
	public boolean insertAlertRecord(List<DustMeasurement> dustMeasurements, List<AlertCriteria> alertCriteria);
	
//	측정소 점검 정보 insert 
//	public boolean insertInspectionRecord(InspectionRecord inspectionRecord);
	
}
