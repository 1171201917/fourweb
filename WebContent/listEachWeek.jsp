<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.atguigu.login.dao.UserDao" %>
<%@ page import="com.atguigu.login.dao.UserDaoImpl" %>
<%@ page import="com.atguigu.login.beans.User" %>
<%@ page import="com.atguigu.login.beans.UserT" %>
<%@ page import="com.atguigu.login.dao.Userthing" %>
<%@ page import="com.atguigu.login.dao.UserthingGp" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ResourceBundle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<f:view>
<%	
				UserDao userDao = new UserDaoImpl();
				int i=1;
				String t=null;
				int a=0;
				/*int h=1;
				int p=0;
				while(true)
				{
					User user = userDao.getUserById(h);
					if(user == null)
						break;
					p++;
					h++;
				}*/
				String dd = request.getParameter("weekDiff");
				try {
				     a = Integer.parseInt(dd);
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				String s=null;
				if(a==0)
				s="本周";
				else if(a==-1)
					s="前一周";
				else if(a==-2)
					s="前两周";
				else if(a==-3)
					s="前三周";
				else s="前四周";
				session.setAttribute("i", dd);
		%>
		 <center><h1>MIR 实验室工作进度：<%=s%>的全部登录资料</h1><br><a href=default.jsp>回到主选单</a></center>
		<table border=1 align=center>
		<tr>
		<th align=center >姓名
		<th align=center >本周完成事项
		<th align=center>下周预定完成事项：【预定完成日期】工作描述
		<th align=center >综合说明
		<th align=center> 登录日期
		<%
				Userthing userthing = new UserthingGp(); 
				String id="1";
				//UserT userT =	null;
				int l=1;
				int k=0;
				while(true)
				{
					k++;
					String o=""+k;
					UserT userT= userthing.readbyidday(o,a);
					/*if(k==p)
						break;*/
					if(userT==null)
					{
						break;
					}
					else
					{
						String uname =userT.getName();
						session.setAttribute("uname", uname);
						String thisweek = null;
						thisweek = userT.getThisweek();
						session.setAttribute("thisweek", thisweek);
						String nexttime =userT.getNexttime();
						session.setAttribute("nexttime", nexttime);
						String tosay = userT.getTosay();
						session.setAttribute("tosay", tosay);
						String time = userT.getTime();
						session.setAttribute("time", time);
						String nextweek = userT.getNextweek();
						session.setAttribute("nextweek", nextweek);
					
				
		%>
						<tr>
						<th align=center>${sessionScope.uname}</th>
						<th align=center>${sessionScope.thisweek}</th>
						<th align=center>${sessionScope.nexttime}</th>
						<th align=center>${sessionScope.tosay}</th>
						<th align=center>${sessionScope.time}</th>
		<%
					}
				}
		%>
		</table><center>
		</center>
		<p align=center>
	
</f:view>
</body>
</html>