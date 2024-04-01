package com.exem.service;

import java.util.List;

import org.json.simple.JSONObject;


public interface InsertDustInfoService {
	
	//미세먼지 데이터 insert
	public int insertDustMeasurement(List<JSONObject> list);
		
}
