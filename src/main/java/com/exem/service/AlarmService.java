package com.exem.service;

import java.util.List;

import com.exem.dto.AlertCriteria;
import com.exem.dto.DustMeasurement;

public interface AlarmService {
	// 경보 발령 기준 충족 시 발령 정보를 기록하는 메서드
	public void recordAlert(List<DustMeasurement> dustMeasurements, List<AlertCriteria> alertCriteria);

	// server 열기
	public void server();

	// client 열기
	public void client();
}
