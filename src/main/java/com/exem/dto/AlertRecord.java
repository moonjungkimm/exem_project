package com.exem.dto;

public class AlertRecord {
	private int alert_recode_no;
	private int dust_measurement_no;
	private int alert_criteria_no;
	public AlertRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlertRecord(int alert_recode_no, int dust_measurement_no, int alert_criteria_no) {
		super();
		this.alert_recode_no = alert_recode_no;
		this.dust_measurement_no = dust_measurement_no;
		this.alert_criteria_no = alert_criteria_no;
	}
	public int getAlert_recode_no() {
		return alert_recode_no;
	}
	public void setAlert_recode_no(int alert_recode_no) {
		this.alert_recode_no = alert_recode_no;
	}
	public int getDust_measurement_no() {
		return dust_measurement_no;
	}
	public void setDust_measurement_no(int dust_measurement_no) {
		this.dust_measurement_no = dust_measurement_no;
	}
	public int getAlert_criteria_no() {
		return alert_criteria_no;
	}
	public void setAlert_criteria_no(int alert_criteria_no) {
		this.alert_criteria_no = alert_criteria_no;
	}
	@Override
	public String toString() {
		return "AlertRecord [alert_recode_no=" + alert_recode_no + ", dust_measurement_no=" + dust_measurement_no
				+ ", alert_criteria_no=" + alert_criteria_no + "]";
	}
	
}
