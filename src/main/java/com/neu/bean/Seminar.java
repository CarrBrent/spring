package com.neu.bean;

public class Seminar {
	private Integer seId;
	private String seName;
	private String seTheme;
	private String seTime;
	private Integer seUp;
	private Integer seDown;
	
	private Integer cid;
	private String cname;
	
	private Integer tid;
	private String tname;
	public Seminar(int tId,int seId, int cid, String cname,String SeName, String SeTheme, String SeTime,int seUp,int seDown,String tname) {
		// TODO Auto-generated constructor stub
		this.setCid(cid);
		this.setCname(cname);
		this.setSeDown(seDown);
		this.setSeId(seId);
		this.setSeName(SeName);
		this.setSeTheme(SeTheme);
		this.setSeTime(SeTheme);
		this.setSeUp(seUp);
		this.setTid(tId);
		this.setTname(tname);
		
	}
	public Integer getSeId() {
		return seId;
	}
	public void setSeId(Integer seId) {
		this.seId = seId;
	}
	public String getSeName() {
		return seName;
	}
	public void setSeName(String seName) {
		this.seName = seName;
	}
	public String getSeTheme() {
		return seTheme;
	}
	public void setSeTheme(String seTheme) {
		this.seTheme = seTheme;
	}
	public String getSeTime() {
		return seTime;
	}
	public void setSeTime(String seTime) {
		this.seTime = seTime;
	}
	public Integer getSeUp() {
		return seUp;
	}
	public void setSeUp(Integer seUp) {
		this.seUp = seUp;
	}
	public Integer getSeDown() {
		return seDown;
	}
	public void setSeDown(Integer seDown) {
		this.seDown = seDown;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
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
