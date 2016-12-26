package com.neu.bean;

public class StudentEvaluateVo {
	private int sId;
	private String sName;
	private String status;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public StudentEvaluateVo(int sId,String sName,String status){
		this.setsId(sId);
		this.setsName(sName);
		this.setStatus(status);
	}
	
	
	

}
