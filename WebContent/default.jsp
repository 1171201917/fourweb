<%@ page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.atguigu.login.dao.UserDao" %>
<%@ page import="com.atguigu.login.dao.UserDaoImpl" %>
<%@ page import="com.atguigu.login.beans.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作进度登录网页</title>
</head>
	<body>
	<center><h1>实验室工作进度网页</h1></center><hr>
			<h3><img src="redball.gif">
			填写进度</h3>
			<center><a href="login.jsp"><input type="submit" value="登录"></a>&nbsp;&nbsp;
			<a href="resist.jsp"><input type="submit" value="注册"></a></center>
			<br>
		<ol>
			<li>请务必在每星期五下午五点前填写完毕。过了星期六午夜，系统自动跳到下一周，就无法再填写本周的进度了。
			<li>请务必每一栏都要填写，尤其是「本周预定完成事项」，一定要填入相关的「预定完成时间」。
		</ol>
		<hr>
		<br>	
		<h3><img src="redball.gif">
			资料列表</h3>
			<br>
			<li>每周填写之资料：
			<a target=_blank href="listEachWeek.asp?weekDiff=0">本周</a>、
			<a target=_blank href="listEachWeek.asp?weekDiff=-1">前一周</a>、
			<a target=_blank href="listEachWeek.asp?weekDiff=-2">前两周</a>、
			<a target=_blank href="listEachWeek.asp?weekDiff=-3">前三周</a>、
			<a target=_blank href="listEachWeek.asp?weekDiff=-4">前四周</a>
		<li>每个人的历史资料：
		<%	
				UserDao userDao = new UserDaoImpl();
		int i=1;
				String t=null;
				while(1>0)
				{
					User user = userDao.getUserById(i);
					if(user==null)
					{
						break;
					}
					else{
						String s=user.getUsername();
						session.setAttribute("s", s);//pageContext.setAttribute("s",s);
						if(s.equals(t))
							break;%>
							<a href="form.jsp?name=${sessionScope.s}">${sessionScope.s}</a>
							<% 
						//out.print("<a href=\"form.jsp\">"+s+"<\\a> ");
						t=s;
					}
					i++;
					
				}
		%>
	</body>
</html>








