package com.today.vo;

public class TodayVO {
	private String tt;
	private String dt;
	private String wt;
	
	public TodayVO() {}
	
	public TodayVO(String tt, String dt, String wt) {
		this.tt=tt; //Title
		this.dt=dt; //Date
		this.wt=wt; //Write
	}

	public String getTt() {
		return tt;
	}

	public void setTt(String tt) {
		this.tt = tt;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getWt() {
		return wt;
	}

	public void setWt(String wt) {
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "TodayVO [tt=" + tt + ", dt=" + dt + ", wt=" + wt + "]";
	}
	
}
