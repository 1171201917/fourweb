package com.atguigu.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.login.beans.User;
import com.atguigu.login.beans.UserT;
import com.atguigu.login.dao.UserDao;
import com.atguigu.login.dao.UserDaoImpl;
import com.atguigu.login.dao.Userthing;
import com.atguigu.login.dao.UserthingGp;
import com.atguigu.login.servlet.getdate;

public class Submit extends HttpServlet {
	
	public static int  getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return w;
    }
	
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				req.setCharacterEncoding("utf-8");
				String name=req.getParameter("name");
				String thisweek = req.getParameter("thisweek");
				String nextweek = req.getParameter("nextweek");
				String nexttime = req.getParameter("nexttime");
				String tosay    = req.getParameter("tosay");
				String id = req.getParameter("idname");
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				 Date date= new Date();
				 
				 int i =getWeekOfDate(date);
				 if(i==6)
				 {
					req.setAttribute("login_msg", "已无法填写本周事项");
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				 }
		         String time =  dateFormat.format(date);
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out=resp.getWriter();
				Userthing userthing = new UserthingGp();
				UserT usert = userthing.Putin(time,name,thisweek,nextweek,nexttime,tosay,id);
				req.setAttribute("name", name);
				RequestDispatcher rd = req.getRequestDispatcher("default.jsp");
				rd.forward(req, resp);
	}

}
