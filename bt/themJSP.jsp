<%@page import="database.ConnectDB"%>
<%@page import="database.Member"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("ten");
		String account = request.getParameter("account");
		String diachi = request.getParameter("diaChi");
		Member member = new Member(id,name,account,diachi);
		ConnectDB run = new ConnectDB();
		run.addMember(member);
		response.sendRedirect("DanhSach.jsp");
	%>
</body>
</html>