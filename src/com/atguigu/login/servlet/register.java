package com.atguigu.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
public class register  extends HttpServlet{
	@Test	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("uname");
		String password  = req.getParameter("upwd");
		System.out.println(username+","+password);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Driver driver = (Driver)clazz.newInstance();
			
			String url="jdbc:mysql://localhost:3306/bigdata_0308?serverTimezone=UTC";
			String user="root";
			String pawd="001124";
			// b.与数据库建立连接
//			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url,user,pawd);
			//4 预编译sql
			String sql = "insert into userpwd(uname,upwd)values(?,?)";
			ps = conn.prepareStatement(sql);
			//5 填充占位符
			ps.setString(1, username);
			ps.setString(2, password);
			//6执行操作
			ps.execute();
			RequestDispatcher rd = req.getRequestDispatcher("backtologin.jsp");
			rd.forward(req, resp);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (ps !=null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
