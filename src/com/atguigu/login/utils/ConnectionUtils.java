package com.atguigu.login.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionUtils {
	private static String driver = null;
	private static String url=null;
	private static String username =null;
	private static String password = null;
	private static Properties props = new Properties();
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	
	
	static {
		try {
			InputStream in = Connection.class.getClassLoader().getResourceAsStream("db.properties");
			props.load(in);
			
			driver = props.getProperty("jdbc.driver");
			url = props .getProperty("jdbc.url");
			username = props.getProperty("jdbc.username");
			password = props .getProperty("jdbc.password");
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
