package com.atguigu.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.login.beans.User;
import com.atguigu.login.dao.UserDao;
import com.atguigu.login.dao.UserDaoImpl;

	
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		
		String username = req.getParameter("uname");
		String password  = req.getParameter("upwd");
		
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserByUsernameAndPassword(username, password);
		if(user == null)
		{
			out.print("<h1>登录失败</h1>");
			//resp.send Redirect("login.html");
			//a转发之前，绑定数据，就是将想要交给下一个组件（JSP）处理的数据
			req.setAttribute("login_msg", "用户名或密码错误");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("login_msg", username);
			RequestDispatcher rd = req.getRequestDispatcher("form.jsp");
			rd.forward(req, resp);
		}
	}
}
