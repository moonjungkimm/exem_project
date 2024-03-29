package com.exem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exem.dao.DustDao;
import com.exem.dto.AlertCriteria;
import com.exem.dto.AlertRecord;
import com.exem.dto.DustMeasurement;


@Service
public class AlertRecordServiceImpl implements AlertRecordService{

	@Autowired
	DustDao dustDao;

	@Override
	public boolean insertAlertRecord(List<DustMeasurement> dustMeasurements, List<AlertCriteria> alertCriteria) {
		AlertRecord alertRecord = new AlertRecord();
		
		int currentPM10 = 0;
		
		int fineDustAlert = 	dustDao.readAllAlertCriteria().get(0).getAlert_concentration_criteria();
		int dustAlert = 		dustDao.readAllAlertCriteria().get(1).getAlert_concentration_criteria();
		int fineDustWarning = 	dustDao.readAllAlertCriteria().get(2).getAlert_concentration_criteria();
		int dustWarning = 		dustDao.readAllAlertCriteria().get(3).getAlert_concentration_criteria();
		
		for(int i=1; i<dustMeasurements.size(); i++) {
			//초미세먼지 경보 확인
			if(dustMeasurements.get(i-1).getPM2_5() >= fineDustAlert && dustMeasurements.get(i).getPM2_5() >= fineDustAlert) {
				alertRecord.setDust_measurement_no(dustMeasurements.get(i).getDust_measurement_no());
				alertRecord.setAlert_criteria_no(1);	//등급1 - 초미세먼지 경보 가장 심각한 상태, 건강에 매우 해로움
				dustDao.insertAlertRecord(alertRecord);
			}
			//미세먼지 경보 확인
			else if(dustMeasurements.get(i-1).getPM10() >= dustAlert && dustMeasurements.get(i).getPM10() >= dustAlert){
				alertRecord.setDust_measurement_no(dustMeasurements.get(i).getDust_measurement_no());
				alertRecord.setAlert_criteria_no(2);	//등급2 - 미세먼지 경보 건강에 매우 해로울 수 있음
				dustDao.insertAlertRecord(alertRecord);
			}
			//초미세먼지 주의보 확인
			else if(dustMeasurements.get(i-1).getPM2_5() >= fineDustWarning && dustMeasurements.get(i).getPM2_5() >= fineDustWarning){
				alertRecord.setDust_measurement_no(dustMeasurements.get(i).getDust_measurement_no());
				alertRecord.setAlert_criteria_no(3);	//등급3 - 초미세먼지 주의보 건강에 해로울 수 있음
				dustDao.insertAlertRecord(alertRecord);
			}
			//미세먼지 주의보 확인
			else if(dustMeasurements.get(i-1).getPM10() >= dustWarning && dustMeasurements.get(i).getPM10() >= dustWarning){
				alertRecord.setDust_measurement_no(dustMeasurements.get(i).getDust_measurement_no());
				alertRecord.setAlert_criteria_no(4);	//등급4 - 미세먼지 주의보 건강에 약간 해로울 수 있음
				dustDao.insertAlertRecord(alertRecord);
			}
			
		}
		
		return false;
	}
	
	

	

}
