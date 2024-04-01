package com.exem.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exem.dao.DustDao;
import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;
import com.exem.dto.InspectionRecord;
import com.exem.dto.SelectAlertRecord;


@Service
public class SelectRecordServiceImpl implements SelectRecordService{

	@Autowired
	DustDao dustDao;

	
	@Override
	public List<DustMeasurement> readAllDustMeasurement() {
		return dustDao.readAllDustMeasurement();
	}

	@Override
	public List<AlertCriteria> readAllAlertCriteria() {
		return dustDao.readAllAlertCriteria();
	}


	@Override
	public List<SelectAlertRecord> selectAlertRecord(Map<String, Object> para) {
		return dustDao.selectAlertRecord(para);
	}

	@Override
	public List<InspectionRecord> inspectionSelectAlertRecord(Map<String, Object> para) {
		return dustDao.inspectionSelectAlertRecord(para);
	}


}
