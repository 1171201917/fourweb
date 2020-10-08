<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.atguigu.login.dao.UserDao" %>
<%@ page import="com.atguigu.login.dao.UserDaoImpl" %>
<%@ page import="com.atguigu.login.beans.User" %>
<%@ page import="com.atguigu.login.beans.UserT" %>
<%@ page import="com.atguigu.login.dao.Userthing" %>
<%@ page import="com.atguigu.login.dao.UserthingGp" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.text.*" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
		String username = (String ) request.getAttribute("username");
		String idname =(String) request.getAttribute("idname");
		Userthing userting = new UserthingGp();
		UserT usert=userting.gettheday(username);
		if(usert!=null)
		{
			String time = usert.getTime();
			request.setAttribute("login_msg", username);
			request.setAttribute("idname", idname);
			try{
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(time);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				 Date date2= new Date();
				 String timenow =  dateFormat.format(date);
				 Date datenow= new SimpleDateFormat("yyyy-MM-dd").parse(timenow);
				 long from1 = date.getTime();  
				 long to1 = datenow.getTime();  
				    int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));
				    Calendar cal = Calendar.getInstance();
			        cal.setTime(datenow);
			        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
			        if (w < 0)
			            w = 0;
				    if(days<w)
				    {
				    	request.setAttribute("login_msg", "本周已提交");
				    	request.getRequestDispatcher("login.jsp").forward(request, response);
				    }
				    else{
				    	request.getRequestDispatcher("form.jsp").forward(request, response);
				    }
			}catch(ParseException px)
			{
				px.printStackTrace();
			}
		}
		else{
			request.getRequestDispatcher("form.jsp").forward(request, response);
		}
%>
</body>
</html>