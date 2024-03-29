package com.exem.dto;

public class DustMeasurement {
	private int dust_measurement_no;
	private int station_code;
	private int PM10;
	private int PM2_5;
	private String measurement_time;
	public DustMeasurement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DustMeasurement(int dust_measurement_no, int station_code, int pM10, int pM2_5, String measurement_time) {
		super();
		this.dust_measurement_no = dust_measurement_no;
		this.station_code = station_code;
		PM10 = pM10;
		PM2_5 = pM2_5;
		this.measurement_time = measurement_time;
	}
	public int getDust_measurement_no() {
		return dust_measurement_no;
	}
	public void setDust_measurement_no(int dust_measurement_no) {
		this.dust_measurement_no = dust_measurement_no;
	}
	public int getStation_code() {
		return station_code;
	}
	public void setStation_code(int station_code) {
		this.station_code = station_code;
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
		return "DustMeasurement [dust_measurement_no=" + dust_measurement_no + ", station_code=" + station_code
				+ ", PM10=" + PM10 + ", PM2_5=" + PM2_5 + ", measurement_time=" + measurement_time + "]";
	}
	
}
