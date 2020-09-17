package com.atguigu.login.dao;

import com.atguigu.login.beans.UserT;
public interface Userthing {
	public UserT Putin(String time ,String name ,String thisweek,String nextweek,String nexttime ,String tosay,String id);
	public UserT readbyid(String id) ;
	public UserT readbyidday(String id,int i) ;
}
