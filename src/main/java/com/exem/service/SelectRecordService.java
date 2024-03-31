package com.exem.service;

import java.util.List;

import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;

public interface SelectRecordService {
		
	//측정한 미세먼지 데이터 전부 
	public List<DustMeasurement> readAllDustMeasurement();
	
	//경보 발령 기준 및 등급
	public List<AlertCriteria> readAllAlertCriteria();	
}
