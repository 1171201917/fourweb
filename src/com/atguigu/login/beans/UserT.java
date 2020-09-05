package com.atguigu.login.beans;

public class UserT {
	private String time;
	private String name;
	private String thisweek;
	private String nextweek;
	private String nexttime;
	private String tosay;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String thisweek() {
		return thisweek;
	}
	public void setThisweek(String thisweek) {
		this.thisweek = thisweek;
	}
	public String getNextweek() {
		return nextweek;
	}
	public void setNextweek(String nextweek) {
		this.nextweek = nextweek;
	}
	public String getNexttime() {
		return nexttime;
	}
	public void setNexttime(String nexttime) {
		this.nexttime = nexttime;
	}
	public String getTosay() {
		return tosay;
	}
	public void setTosay(String tosay) {
		this.tosay = tosay;
	}
	@Override
	public String toString() {
		return "UserT [time=" + time + ", name=" + name + ", thisweek"+thisweek+", nextweek=" + nextweek +", nexttime" +nexttime+", tosay"+tosay+"]";
	}
}
