<%@page import="dbAccess.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Account</title>
</head>
<body>
	<%
		response.setCharacterEncoding("utf-8");//kiểu trả về tiếng việt
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");//kiểu gửi đi tiếng việt

		int id = Integer.parseInt(request.getParameter("id"));
		/* DBAccess db = new DBAccess(); */
		DBAccess.delAcc(id);
		response.sendRedirect("danhSach.jsp");
	%>
</body>
</html>