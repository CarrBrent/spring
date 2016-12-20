package com.neu.bean;

public class GroupVo {
	private String grName;
	private String stNames;
	public GroupVo(String grName,String stNames) {
		this.setGrName(grName);
		this.setStNames(stNames);
	}
	public String getGrName() {
		return grName;
	}
	public void setGrName(String grName) {
		this.grName = grName;
	}
	public String getStNames() {
		return stNames;
	}
	public void setStNames(String stNames) {
		this.stNames = stNames;
	}
	
	

}
