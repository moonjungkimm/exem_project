package com.exem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exem.dao.DustDao;
import com.exem.dto.AlertCriteria;
import com.exem.dto.AlertRecord;
import com.exem.dto.DustMeasurement;
import com.exem.dto.InspectionRecord;


@Service
public class InsertRecordServiceImpl implements InsertRecordService{

	@Autowired
	DustDao dustDao;

	@Override
	public boolean insertAlertRecord(List<DustMeasurement> dustMeasurements, List<AlertCriteria> alertCriteria) {
		AlertRecord alertRecord = new AlertRecord();
		InspectionRecord inspectionRecord = new InspectionRecord();
		
		int fineDustAlert = 	dustDao.readAllAlertCriteria().get(0).getAlert_concentration_criteria();	//초미세먼지 경보
		int dustAlert = 		dustDao.readAllAlertCriteria().get(1).getAlert_concentration_criteria();	//미세먼지 경보
		int fineDustWarning = 	dustDao.readAllAlertCriteria().get(2).getAlert_concentration_criteria();	//초미세먼지 주의보	
		int dustWarning = 		dustDao.readAllAlertCriteria().get(3).getAlert_concentration_criteria();	//미세먼지 주의보
		
		try {
			
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
				
				//미세먼지, 초미세먼지 측정 data가 0인 경우
				//측정소 점검 정보 insert
				if(dustMeasurements.get(i).getPM10() == 0 || dustMeasurements.get(i).getPM2_5() == 0) {
					inspectionRecord.setDust_measurement_no(i);
					dustDao.insertInspectionRecord(inspectionRecord);
				}
					
			}	//end for
		
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	

	

}
