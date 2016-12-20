package com.neu.bean;

public class Student {
	private int sId;
	private String sAccount;
	private String sPwd;
	private String sName;
	private String sPhone;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
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
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public Student(int sId,String sAccount,String sPwd,String sName,String sPhone){
		this.setsId(sId);
		this.setsAccount(sAccount);
		this.setsName(sName);
		this.setsPwd(sPwd);
		this.setsPhone(sPhone);
	}
	
	
	

}
