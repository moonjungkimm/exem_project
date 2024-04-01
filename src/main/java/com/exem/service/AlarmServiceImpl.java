package com.exem.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exem.dao.DustDao;
import com.exem.dto.AlertCriteria;
import com.exem.dto.AlertRecord;
import com.exem.dto.DustMeasurement;
import com.exem.dto.InspectionRecord;
import com.exem.dto.SelectAlertRecord;

@Service
public class AlarmServiceImpl implements AlarmService {

	@Autowired
	private DustDao dustDao;

	private static final int PORT = 5000; // server port 설정

	private static final String SERVER_ADDRESS = "127.0.0.1"; //

	private static final int SERVER_PORT = 5000;

	@Override
	public void recordAlert(List<DustMeasurement> dustMeasurements, List<AlertCriteria> alertCriteria) {

		AlertRecord alertRecord = new AlertRecord();
		InspectionRecord inspectionRecord = new InspectionRecord();

		int fineDustAlert = alertCriteria.get(0).getAlert_concentration_criteria();
		int dustAlert = alertCriteria.get(1).getAlert_concentration_criteria();
		int fineDustWarning = alertCriteria.get(2).getAlert_concentration_criteria();
		int dustWarning = alertCriteria.get(3).getAlert_concentration_criteria();

		if(dustMeasurements.get(0).getPM10() == 0 || dustMeasurements.get(0).getPM2_5() == 0) {
			inspectionRecord.setDust_measurement_no(dustMeasurements.get(0).getDust_measurement_no());
			dustDao.insertInspectionRecord(inspectionRecord);
		}
		
		for (int i = 1; i < dustMeasurements.size(); i++) {
			// 초미세먼지 경보 확인
			if (dustMeasurements.get(i - 1).getPM2_5() > fineDustAlert
					&& dustMeasurements.get(i).getPM2_5() > fineDustAlert) {
				alertRecord.setDust_measurement_no(dustMeasurements.get(i).getDust_measurement_no());
				alertRecord.setAlert_criteria_no(1); // 등급1 - 초미세먼지 경보 가장 심각한 상태, 건강에 매우 해로움
				dustDao.insertAlertRecord(alertRecord);
			}
			// 미세먼지 경보 확인
			else if (dustMeasurements.get(i - 1).getPM10() > dustAlert
					&& dustMeasurements.get(i).getPM10() > dustAlert) {
				alertRecord.setDust_measurement_no(dustMeasurements.get(i).getDust_measurement_no());
				alertRecord.setAlert_criteria_no(2); // 등급2 - 미세먼지 경보 건강에 매우 해로울 수 있음
				dustDao.insertAlertRecord(alertRecord);
			}
			// 초미세먼지 주의보 확인
			else if (dustMeasurements.get(i - 1).getPM2_5() > fineDustWarning
					&& dustMeasurements.get(i).getPM2_5() > fineDustWarning) {
				alertRecord.setDust_measurement_no(dustMeasurements.get(i).getDust_measurement_no());
				alertRecord.setAlert_criteria_no(3); // 등급3 - 초미세먼지 주의보 건강에 해로울 수 있음
				dustDao.insertAlertRecord(alertRecord);
			}
			// 미세먼지 주의보 확인
			else if (dustMeasurements.get(i - 1).getPM10() > dustWarning
					&& dustMeasurements.get(i).getPM10() > dustWarning) {
				alertRecord.setDust_measurement_no(dustMeasurements.get(i).getDust_measurement_no());
				alertRecord.setAlert_criteria_no(4); // 등급4 - 미세먼지 주의보 건강에 약간 해로울 수 있음
				dustDao.insertAlertRecord(alertRecord);
			}

			if (dustMeasurements.get(i - 1).getPM10() == 0 || dustMeasurements.get(i - 1).getPM2_5() == 0) {
				inspectionRecord.setDust_measurement_no(dustMeasurements.get(i - 1).getDust_measurement_no());
				dustDao.insertInspectionRecord(inspectionRecord);
			}

		}

	}

	@Override
	public void server() {
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("station_name", "전체");
		para.put("grade", "0");
		List<SelectAlertRecord> list = dustDao.selectAlertRecord(para);
		List<String> alarmMessages = new ArrayList<>();

		for (SelectAlertRecord dto : list) {
			String stationName = dto.getMeasurement_station_name();
			String alertLevel = dto.getAlert_level();
			String alertTime = dto.getMeasurement_time();
			String.format(alertTime, "");

			alarmMessages.add(stationName + "\t" + alertTime + "\t" + alertLevel);
		}

		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("port : " + PORT);

			while (true) {
				try (Socket clientSocket = serverSocket.accept();
						PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
					System.out.println("Client connected : " + clientSocket.getInetAddress());
					for (String message : alarmMessages) {
						out.println(message);
					}
				} catch (IOException e) {
					System.out.println("Error : " + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println("Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void client() {

		try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			String fromServer;

			while ((fromServer = in.readLine()) != null) {
				System.out.println("Alert: " + fromServer);
			}

		} catch (IOException e) {
			System.out.println("Client error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}