<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<center><h1>欢迎登录</h1></center><hr>
		<form action="login" method="post" >
			<center><img src="redball.gif">用户名：<input type="text" name="uname">
			<%
				String loginMsg = (String) request.getAttribute("login_msg");
			%>
			<span><font color="red"><%=loginMsg==null?"":loginMsg%></font></span>
			<br><br>
			<img src="redball.gif">密码 ： <input type="password" name="upwd"><br><br>
			<input type="submit" value="登录"><br></center>
		</form>
</body>
</html>