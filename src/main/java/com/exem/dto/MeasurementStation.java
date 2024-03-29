package com.exem.dto;

public class MeasurementStation {
	private int station_code;
	private String station_name;
	public MeasurementStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeasurementStation(int station_code, String station_name) {
		super();
		this.station_code = station_code;
		this.station_name = station_name;
	}
	public int getStation_code() {
		return station_code;
	}
	public void setStation_code(int station_code) {
		this.station_code = station_code;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	@Override
	public String toString() {
		return "MeasurementStation [station_code=" + station_code + ", station_name=" + station_name + "]";
	}
	
	
}
