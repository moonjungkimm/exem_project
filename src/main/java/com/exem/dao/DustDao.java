package com.exem.dao;

import java.util.List;

import org.json.simple.JSONObject;

import com.exem.dto.AlertCriteria;
import com.exem.dto.AlertRecord;
import com.exem.dto.DustMeasurement;
import com.exem.dto.MeasurementStation;

@MyDao
public interface DustDao {
	//측정소 중복 검사
//	public boolean checkStationCode(int station_code);
	
	//측정소 코드, 이름 insert
	public boolean insertMeasurementStation(MeasurementStation measurementStation);
	
	//3월 미세먼지 데이터 insert
	public boolean insertDustMeasurement(DustMeasurement dustMeasurement);
	
	//경보 발령 정보 insert
	public boolean insertAlertRecord(AlertRecord alertRecord);
	
	//측정소 점검 정보 insert 
	public int insertInspectionRecord();
	
	
	//측정한 미세먼지 데이터 전부 
	public List<DustMeasurement> readAllDustMeasurement();
	
	//경보 발령 기준 및 등급
	public List<AlertCriteria> readAllAlertCriteria();

	
}
