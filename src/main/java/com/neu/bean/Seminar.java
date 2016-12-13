package com.neu.bean;
import java.util.Date;

public class Seminar {
	private int seId;
	private int cId;
	private String seName;
	private String seTheme;
	private Date seTime;
	private int seUp;
	private int seDown;

	public Seminar(int seId, int CId, String SeName, String SeTheme, Date SeTime,int SeUp,int SeDown) {
		// TODO Auto-generated constructor stub
		this.seId =seId;
		this.cId=CId;
		this.seName=SeName;
		this.seTheme=SeTheme;
		this.seTime=SeTime;
		this.seUp=SeUp;
		this.seDown=SeDown;
		
	}

	public int getSeId() {
		return seId;
	}

	public void setSeId(int seId) {
		this.seId = seId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
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

	public Date getSeTime() {
		return seTime;
	}

	public void setSeTime(Date seTime) {
		this.seTime = seTime;
	}

	public int getSeUp() {
		return seUp;
	}

	public void setSeUp(int seUp) {
		this.seUp = seUp;
	}

	public int getSeDown() {
		return seDown;
	}

	public void setSeDown(int seDown) {
		this.seDown = seDown;
	}
	
}
