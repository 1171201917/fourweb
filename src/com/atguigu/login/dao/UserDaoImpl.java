package com.atguigu.login.dao;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;
import com.atguigu.login.beans.User;
//import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl  implements UserDao{
	User u=null;
	public User getUserById(int id) {
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
			String sql = "select uname,upwd from userpwd where id=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				u=new User();
				u.setUsername(rs.getString("uname"));
				u.setPassword(rs.getString("upwd"));
			}
			return u;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public User getUserByUsernameAndPassword(String uname, String upwd) {
		// TODO Auto-generated method stub
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
			String sql = "select uname,upwd from userpwd where uname=? and upwd=?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upwd);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				u=new User();
				u.setUsername(rs.getString("uname"));
				u.setPassword(rs.getString("upwd"));
			}
			return u;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
