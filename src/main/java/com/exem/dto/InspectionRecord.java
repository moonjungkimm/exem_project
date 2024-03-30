package com.exem.dto;

public class InspectionRecord {
	private int inspection_record_no;
	private int dust_measurement_no;
	public InspectionRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InspectionRecord(int inspection_record_no, int dust_measurement_no) {
		super();
		this.inspection_record_no = inspection_record_no;
		this.dust_measurement_no = dust_measurement_no;
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
	@Override
	public String toString() {
		return "InspectionRecord [inspection_record_no=" + inspection_record_no + ", dust_measurement_no="
				+ dust_measurement_no + "]";
	}
	
}
