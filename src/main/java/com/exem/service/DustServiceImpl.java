package com.exem.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exem.dao.DustDao;
import com.exem.dto.DustMeasurement;
import com.exem.dto.MeasurementStation;

@Service
public class DustServiceImpl implements DustService{

	@Autowired
	DustDao dustDao;
	
	@Override
	public boolean insertDustMeasurement(List<JSONObject> list) {
		int station_code = 0;
		String station_name = "";
		String measurement_time = "";
		int PM10 = 0;
		int PM2_5 = 0;
			
		try {
			for(int i=0; i<list.size(); i++) {
				MeasurementStation measurementStation = new MeasurementStation();
				DustMeasurement dustMeasurement = new DustMeasurement();
				
				station_code = Integer.parseInt((String) list.get(i).get("측정소코드"));
				station_name = (String) list.get(i).get("측정소명");
				measurement_time = (String) list.get(i).get("날짜");
				
				//미세먼지 측정 값이 null인 경우에 0으로 바꿔서 저장
				Object pm10Object = list.get(i).get("PM10");
				PM10 = pm10Object != null ? Integer.parseInt((String) pm10Object) : 0;
				Object pm25Object = list.get(i).get("PM2.5");
				PM2_5 = pm25Object != null ? Integer.parseInt((String) pm25Object) : 0;
				
				//시간이 '24'인 경우 날짜 하루 늘리고 시간을 '00'으로 변경
				if (measurement_time.endsWith(" 24")) {
				    // '24'를 '00'으로 변경
				    measurement_time = measurement_time.replace(" 24", " 00");
				    // 문자열을 LocalDateTime으로 파싱
				    LocalDateTime dateTime = LocalDateTime.parse(measurement_time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
				    // 날짜를 하루 늘림
				    dateTime = dateTime.plusDays(1);
				    // LocalDateTime을 다시 문자열로 변환하여 measurement_time에 할당
				    measurement_time = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
				}
				
				
				
				//db의 측정소 코드와 중복 검사 후 측정소코드, 이름 저장
				if( dustDao.checkStationCode(station_code) == 0) {
					measurementStation.setStation_code(station_code);
					measurementStation.setStation_name(station_name);
					dustDao.insertMeasurementStation(measurementStation);
				}
				//미세먼지 측정 데이터 저장
				dustMeasurement.setMeasurement_time(measurement_time);
				dustMeasurement.setStation_code(station_code);
				dustMeasurement.setPM10(PM10);
				dustMeasurement.setPM2_5(PM2_5);
				
				dustDao.insertDustMeasurement(dustMeasurement);
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}



}
