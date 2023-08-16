package com.department.aul.models;

import java.util.List;

public class Data {
	private String department;
	private List<String> studentId;
	private List<Integer> mark;
	private Double percentage;
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<Integer> getMark() {
		return mark;
	}
	public List<String> getStudentId() {
		return studentId;
	}
	public void setStudentId(List<String> studentId) {
		this.studentId = studentId;
	}
	public void setMark(List<Integer> mark) {
		this.mark = mark;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	
}
