package com.exem.dto;

public class SelectAlertRecord {
	private int alert_record_no;
	private String measurement_station_name;
	private String measurement_area;
	private String alert_level;
	private String measurement_time;
	public SelectAlertRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SelectAlertRecord(int alert_record_no, String measurement_station_name, String measurement_area,
			String alert_level, String measurement_time) {
		super();
		this.alert_record_no = alert_record_no;
		this.measurement_station_name = measurement_station_name;
		this.measurement_area = measurement_area;
		this.alert_level = alert_level;
		this.measurement_time = measurement_time;
	}
	public int getAlert_record_no() {
		return alert_record_no;
	}
	public void setAlert_record_no(int alert_record_no) {
		this.alert_record_no = alert_record_no;
	}
	public String getMeasurement_station_name() {
		return measurement_station_name;
	}
	public void setMeasurement_station_name(String measurement_station_name) {
		this.measurement_station_name = measurement_station_name;
	}
	public String getMeasurement_area() {
		return measurement_area;
	}
	public void setMeasurement_area(String measurement_area) {
		this.measurement_area = measurement_area;
	}
	public String getAlert_level() {
		return alert_level;
	}
	public void setAlert_level(String alert_level) {
		this.alert_level = alert_level;
	}
	public String getMeasurement_time() {
		return measurement_time;
	}
	public void setMeasurement_time(String measurement_time) {
		this.measurement_time = measurement_time;
	}
	@Override
	public String toString() {
		return "SelectAlertRecord [alert_record_no=" + alert_record_no + ", measurement_station_name="
				+ measurement_station_name + ", measurement_area=" + measurement_area + ", alert_level=" + alert_level
				+ ", measurement_time=" + measurement_time + "]";
	}
	
	
}
