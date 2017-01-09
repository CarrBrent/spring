package com.neu.bean;

public class StudentEvaluateVo {
	private int sid;
	private String sname;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public StudentEvaluateVo(int sId,String sName){
		this.setSid(sId);
		this.setSname(sName);
	}
	
	
	

}
