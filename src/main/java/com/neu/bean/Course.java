package com.neu.bean;

public class Course {
	private Integer cid;
	private String cnumber;
	private String cname;
	private String cterm;
	
	private Integer tid;
	private String tname;
	
	public Course(int cid, int tid, String cnumber, String cname, String cterm,String tname) {
		// TODO Auto-generated constructor stub
		this.setCid(cid);
		this.setCname(cname);
		this.setCnumber(cnumber);
		this.setCterm(cterm);
		this.setTid(tid);
		this.setTname(tname);
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCnumber() {
		return cnumber;
	}
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCterm() {
		return cterm;
	}
	public void setCterm(String cterm) {
		this.cterm = cterm;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
