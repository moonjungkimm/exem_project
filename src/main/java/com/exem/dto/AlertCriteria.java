package com.exem.dto;

public class AlertCriteria {
	private int alert_criteria_no;
	private String substance;
	private String alert_level;
	private int alert_concentration_criteria;
	private int alert_duration_criteria;
	private int grade;
	private String description;
	public AlertCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlertCriteria(int alert_criteria_no, String substance, String alert_level, int alert_concentration_criteria,
			int alert_duration_criteria, int grade, String description) {
		super();
		this.alert_criteria_no = alert_criteria_no;
		this.substance = substance;
		this.alert_level = alert_level;
		this.alert_concentration_criteria = alert_concentration_criteria;
		this.alert_duration_criteria = alert_duration_criteria;
		this.grade = grade;
		this.description = description;
	}
	public int getAlert_criteria_no() {
		return alert_criteria_no;
	}
	public void setAlert_criteria_no(int alert_criteria_no) {
		this.alert_criteria_no = alert_criteria_no;
	}
	public String getSubstance() {
		return substance;
	}
	public void setSubstance(String substance) {
		this.substance = substance;
	}
	public String getAlert_level() {
		return alert_level;
	}
	public void setAlert_level(String alert_level) {
		this.alert_level = alert_level;
	}
	public int getAlert_concentration_criteria() {
		return alert_concentration_criteria;
	}
	public void setAlert_concentration_criteria(int alert_concentration_criteria) {
		this.alert_concentration_criteria = alert_concentration_criteria;
	}
	public int getAlert_duration_criteria() {
		return alert_duration_criteria;
	}
	public void setAlert_duration_criteria(int alert_duration_criteria) {
		this.alert_duration_criteria = alert_duration_criteria;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AlertCriteria [alert_criteria_no=" + alert_criteria_no + ", substance=" + substance + ", alert_level="
				+ alert_level + ", alert_concentration_criteria=" + alert_concentration_criteria
				+ ", alert_duration_criteria=" + alert_duration_criteria + ", grade=" + grade + ", description="
				+ description + "]";
	}


	
}
