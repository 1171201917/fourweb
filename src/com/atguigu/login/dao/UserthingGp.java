package com.atguigu.login.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;

import com.atguigu.login.beans.User;
import com.atguigu.login.beans.UserT;

public class UserthingGp implements Userthing{
	UserT u=null;
	@Override
	public UserT Putin(String time, String name, String thisweek, String nextweek, String nexttime, String tosay) {
		try {
			// a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver driver = (Driver)clazz.newInstance();
			
			String url="jdbc:mysql://localhost:3306/bigdata_0308?serverTimezone=UTC";
			String user="root";
			String pawd="001124";
			// b.与数据库建立连接
//			DriverManager.registerDriver(driver);
			Connection conn = DriverManager.getConnection(url,user,pawd);
			// c.发送sql,执行
			String sql = "insert into work(time,name,thisweek,nextweek,nexttime,tosay)values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//5 填充占位符
			ps.setString(1, time);
			ps.setString(2, name);
			ps.setString(3, thisweek);
			ps.setString(4, nextweek);
			ps.setString(5, nexttime);
			ps.setString(6, tosay);
			//6执行操作
			ps.execute();
		
			return u;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
