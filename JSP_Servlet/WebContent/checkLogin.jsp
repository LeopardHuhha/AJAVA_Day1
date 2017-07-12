<%@page import="dbAccess.*"%>
<%@page import="dbAccess.DBAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Check Login</title>
</head>
<body>
<%
response.setCharacterEncoding("utf-8");
response.setContentType("text/html");
request.setCharacterEncoding("utf-8");

String u = request.getParameter("username");
String p = request.getParameter("password");

DBAccess db = new  DBAccess();

if(db.checkLogin(u,p)){	
	request.getRequestDispatcher("danhSach.jsp").forward(request, response);
}
else
{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>