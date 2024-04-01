package com.exem.dto;

public class InspectionRecord {
	private int inspection_record_no;
	private int dust_measurement_no;
	private String measurement_station_name;
	private int PM10;
	private int PM2_5;
	private String measurement_time;
	public InspectionRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InspectionRecord(int inspection_record_no, int dust_measurement_no, String measurement_station_name,
			int pM10, int pM2_5, String measurement_time) {
		super();
		this.inspection_record_no = inspection_record_no;
		this.dust_measurement_no = dust_measurement_no;
		this.measurement_station_name = measurement_station_name;
		PM10 = pM10;
		PM2_5 = pM2_5;
		this.measurement_time = measurement_time;
	}
	public int getInspection_record_no() {
		return inspection_record_no;
	}
	public void setInspection_record_no(int inspection_record_no) {
		this.inspection_record_no = inspection_record_no;
	}
	public int getDust_measurement_no() {
		return dust_measurement_no;
	}
	public void setDust_measurement_no(int dust_measurement_no) {
		this.dust_measurement_no = dust_measurement_no;
	}
	public String getMeasurement_station_name() {
		return measurement_station_name;
	}
	public void setMeasurement_station_name(String measurement_station_name) {
		this.measurement_station_name = measurement_station_name;
	}
	public int getPM10() {
		return PM10;
	}
	public void setPM10(int pM10) {
		PM10 = pM10;
	}
	public int getPM2_5() {
		return PM2_5;
	}
	public void setPM2_5(int pM2_5) {
		PM2_5 = pM2_5;
	}
	public String getMeasurement_time() {
		return measurement_time;
	}
	public void setMeasurement_time(String measurement_time) {
		this.measurement_time = measurement_time;
	}
	@Override
	public String toString() {
		return "InspectionRecord [inspection_record_no=" + inspection_record_no + ", dust_measurement_no="
				+ dust_measurement_no + ", measurement_station_name=" + measurement_station_name + ", PM10=" + PM10
				+ ", PM2_5=" + PM2_5 + ", measurement_time=" + measurement_time + "]";
	}
	
	
}
