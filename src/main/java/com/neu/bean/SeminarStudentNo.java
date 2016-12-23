package com.neu.bean;

public class SeminarStudentNo {
	private String seName;
	private int studentNo;
	public SeminarStudentNo(String seName,int studentNo) {
		this.setSeName(seName);
		this.setStudentNo(studentNo);
		
	}
	public String getSeName() {
		return seName;
	}
	public void setSeName(String seName) {
		this.seName = seName;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	

}
