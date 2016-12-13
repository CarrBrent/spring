package com.neu.bean;

public class Course {
	private int CId;
	private int TId;
	private String CNumber;
	private String CName;
	private String CTerm;
	public Course(int i, int j, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
		this.CId = i;
		this.TId = j;
		this.CNumber = string;
		this.CName = string2;
		this.CTerm = string3;
	}
	public int getCId() {
		return CId;
	}
	public void setCId(int cId) {
		CId = cId;
	}
	public int getTId() {
		return TId;
	}
	public void setTId(int tId) {
		TId = tId;
	}
	public String getCNumber() {
		return CNumber;
	}
	public void setCNumber(String cNumber) {
		CNumber = cNumber;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getCTerm() {
		return CTerm;
	}
	public void setCTerm(String cTerm) {
		CTerm = cTerm;
	}
	
}
