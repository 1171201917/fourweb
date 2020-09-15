<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<%
				String loginMsg = (String) request.getAttribute("login_msg");
				String idname = (String ) request.getAttribute("idname");
				session.setAttribute("loginMsg", loginMsg);
				session.setAttribute("idname", idname);
			%>		
		<center><h1>登录<%=loginMsg%>的本周工作进度</h1><br><a href=default.jsp>回到主选单</a></center>
		<form method=post action="putin">
		<table border=1 align=center>
		<tr>
		<th align=center colspan=2>上周预定完成事项
		<th align=center rowspan=2>本周完成事项
		<th align=center colspan=2>下周预定完成事项
		<th align=center rowspan=2>综合说明
		<tr>
		<th align=center>工作描述<th align=center>预定完成日期
		<th align=center>工作描述<th align=center>预定完成日期
		<tr>
		<th align=center></th>
		<th align=center></th>
		<th align=center><textarea name="thisweek" rows="7" cols="15" ></textarea></th>
		<th align=center><textarea name="nextweek" rows="7" cols="15" ></textarea></th>
		<th align=center><textarea name="nexttime" rows="7" cols="10" ></textarea></th>
		<th align=center><textarea name="tosay" rows="7" cols="20" ></textarea></th>
		</table><center>
		<input type="hidden"  name="name" value="${sessionScope.loginMsg}"/>
		<input type="hidden"  name="idname" value="${sessionScope.idname}"/>
		<input type=submit value="送出表单">
		<input type=reset  value="恢复原值">
		</center>
		<p align=center>
	
		</form>
</body>
</html>