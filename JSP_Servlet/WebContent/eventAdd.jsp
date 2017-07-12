<%@page import="java.util.ArrayList"%>
<%@page import="dbAccess.*"%>
<%@page import="dbAccess.DBAccess"%>
<%@page import="dbAccess.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Account</title>
</head>
<body>
	<%
		response.setCharacterEncoding("utf-8");//kiểu trả về tiếng việt
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");//kiểu gửi đi tiếng việt

		String u = request.getParameter("txt_user");//gán dữ liệu từ client cho biến
		String p = request.getParameter("txt_pass");
		String e = request.getParameter("txt_email");

		Account acc = new Account();//gán dữ liệu từ biến cho obj
		acc.setUser(u);
		acc.setPass(p);
		acc.setEmail(e);

		DBAccess db = new DBAccess();//tạo kết nối db
		db.addAcc(u, p, e);//thêm vào db
		response.sendRedirect("danhSach.jsp");//chuyển trang
	%>
</body>
</html>