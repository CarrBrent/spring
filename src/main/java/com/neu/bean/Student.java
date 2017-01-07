package com.neu.bean;

public class Student {
	private int sid;
	private String sAccount;
	private String sPwd;
	private String sname;
	private String sPhone;
	
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
	public String getsAccount() {
		return sAccount;
	}
	public void setsAccount(String sAccount) {
		this.sAccount = sAccount;
	}
	public String getsPwd() {
		return sPwd;
	}
	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
	}
	
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public Student(int sId,String sAccount,String sPwd,String sName,String sPhone){
		this.setSid(sId);
		this.setSname(sName);
		this.setsAccount(sAccount);
		this.setsPwd(sPwd);
		this.setsPhone(sPhone);
	}
	
	
	

}
