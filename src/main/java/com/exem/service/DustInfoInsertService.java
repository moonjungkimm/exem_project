package com.exem.service;

import java.util.List;

import org.json.simple.JSONObject;

import com.exem.dto.AlertRecord;

public interface DustInfoInsertService {
	
	//미세먼지 데이터 insert
	public boolean insertDustMeasurement(List<JSONObject> list);
		
}
