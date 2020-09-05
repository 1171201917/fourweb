<%@ page import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style>
			body {
				background-color: grey;
}
		</style>
<title>Insert title here</title>
</head>
<body>
		<h1>欢迎登录</h1>
		<form action="login" method="post">
			用户名：<input type="text" name="uname">
			<%
				request.getAttribute(	 
			%>
			<br>
			密码 ： <input type="password" name="upwd"><br>
			<input type="submit" value="登录"><br>
		</form>
</body>
</html>