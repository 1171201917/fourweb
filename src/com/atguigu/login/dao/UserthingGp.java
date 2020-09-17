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
	public UserT Putin(String time, String name, String thisweek, String nextweek, String nexttime, String tosay,String id) {
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver driver = (Driver)clazz.newInstance();
			
			String url="jdbc:mysql://localhost:3306/bigdata_0308?serverTimezone=UTC";
			String user="root";
			String pawd="001124";
			// b.�����ݿ⽨������
//			DriverManager.registerDriver(driver);
			Connection conn = DriverManager.getConnection(url,user,pawd);
			// c.����sql,ִ��
			String sql = "insert into work(time,name,thisweek,nextweek,nexttime,tosay,id)values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			//5 ���ռλ��
			ps.setString(1, time);
			ps.setString(2, name);
			ps.setString(3, thisweek);
			ps.setString(4, nextweek);
			ps.setString(5, nexttime);
			ps.setString(6, tosay);
			ps.setString(7,id);
			//6ִ�в���
			ps.execute();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public UserT readbyid(String id) {
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver driver = (Driver)clazz.newInstance();
			
			String url="jdbc:mysql://localhost:3306/bigdata_0308?serverTimezone=UTC";
			String user="root";
			String pawd="001124";
			// b.�����ݿ⽨������
//			DriverManager.registerDriver(driver);
			Connection conn = DriverManager.getConnection(url,user,pawd);
			// c.����sql,ִ��
			String sql = "select time,thisweek,nextweek,nexttime,tosay from work where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//5 ���ռλ��
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				u=new UserT();
				u.setNexttime(rs.getString("nexttime"));
				u.setThisweek(rs.getString("thisweek"));
				u.setTosay(rs.getString("tosay"));
				u.setTime(rs.getString("time"));
			}
			return u;
			//6ִ�в���
			//ps.execute();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public UserT readbyidday(String id,int i) {
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver driver = (Driver)clazz.newInstance();
			
			String url="jdbc:mysql://localhost:3306/bigdata_0308?serverTimezone=UTC";
			String user="root";
			String pawd="001124";
			// b.�����ݿ⽨������
//			DriverManager.registerDriver(driver);
			Connection conn = DriverManager.getConnection(url,user,pawd);
			// c.����sql,ִ��
			String sql = "select name,time,thisweek,nextweek,nexttime,tosay from work where id=? order by number desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			//5 ���ռλ��
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			int j=1;
			while(rs.next())
			{
				j--;
				if(j==i)
				{
					//rs.close();
					break;
				}
			}
			u=new UserT();
			u.setName(rs.getString("name"));
			u.setNexttime(rs.getString("nexttime"));
			u.setNextweek(rs.getString("nextweek"));
			u.setThisweek(rs.getString("thisweek"));
			u.setTosay(rs.getString("tosay"));
			u.setTime(rs.getString("time"));
			return u;
			//6ִ�в���
			//ps.execute();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
