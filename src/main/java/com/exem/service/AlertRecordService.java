package com.exem.service;

import java.util.List;

import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;

public interface AlertRecordService {
		
	//경보 발령 정보 insert
	public boolean insertAlertRecord(List<DustMeasurement> dustMeasurements, List<AlertCriteria> alertCriteria);
	
}
