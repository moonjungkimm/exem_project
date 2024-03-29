package com.exem.dao;

import com.exem.dto.DustMeasurement;
import com.exem.dto.MeasurementStation;

@MyDao
public interface DustDao {
	//측정소 중복 검사
	public int checkStationCode(int station_code);
	
	//측정소 코드, 이름 insert
	public boolean insertMeasurementStation(MeasurementStation measurementStation);
	
	//3월 미세먼지 데이터 insert
	public boolean insertDustMeasurement(DustMeasurement dustMeasurement);
	
	//경보 발령 정보 insert
	public int insertAlertRecord();
	
	//측정소 점검 정보 insert 
	public int insertInspectionRecord();

	
}
