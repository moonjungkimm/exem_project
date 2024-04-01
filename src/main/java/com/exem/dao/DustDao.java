package com.exem.dao;

import java.util.List;
import java.util.Map;

import com.exem.dto.AlertCriteria;
import com.exem.dto.AlertRecord;
import com.exem.dto.DustMeasurement;
import com.exem.dto.InspectionRecord;
import com.exem.dto.MeasurementStation;
import com.exem.dto.SelectAlertRecord;

@MyDao
public interface DustDao {
	//측정소 중복 검사
	public int checkStationCode(int station_code);
	
	//측정소 코드, 이름 insert
	public int insertMeasurementStation(MeasurementStation measurementStation);
	
	//3월 미세먼지 데이터 insert
	public int insertDustMeasurement(DustMeasurement dustMeasurement);
	
	//경보 발령 정보 insert
	public int insertAlertRecord(AlertRecord alertRecord);
	
	//측정한 미세먼지 데이터 전부 
	public List<DustMeasurement> readAllDustMeasurement();
	
	//경보 발령 기준 및 등급
	public List<AlertCriteria> readAllAlertCriteria();

	//측정소 점검 정보 insert 
	public int insertInspectionRecord(InspectionRecord inspectionRecord);
	
	//정보 발령 정보 List
	public List<SelectAlertRecord> selectAlertRecord(Map<String, Object> para);
	
	//측정소 점검 정보 List
	public List<InspectionRecord> inspectionSelectAlertRecord(Map<String, Object> para);
	
	//경보 발령 정보 갯수
	public int countAlertRecord();
}
