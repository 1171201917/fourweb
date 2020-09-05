package com.atguigu.preparedstatement.crud;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class PreparedStatementUpdate {
	@Test
	public void testInsert() throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			InputStream is = PreparedStatementUpdate.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties pros = new Properties();
			pros.load(is);

			String user = pros.getProperty("user");
			String password = pros.getProperty("password");
			String url = pros.getProperty("url");
			String driverClass = pros.getProperty("dricerClass");

			Class.forName(driverClass);

			conn = DriverManager.getConnection(url, user, password);
			//4 Ô¤±àÒësql
			String sql = "insert into test1(id,username,password)values(?,?,?)";
			ps = conn.prepareStatement(sql);
			//5 Ìî³äÕ¼Î»·û
			ps.setInt(1, 14126);
			ps.setString(2, "ÄÄß¸");
			ps.setString(3, "sadffff");
			System.out.print("³É¹¦");
			//6Ö´ÐÐ²Ù×÷
			ps.execute();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (ps !=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
