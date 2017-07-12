<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style type="text/css">
input {
	width: 300px;
	height: 30px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<form align="center" action=" /JSP_Servlet/checkLogin.jsp" method="get">
		<input type="text" name="username" placeholder=" Username"> 
		<input type="password" name="password" placeholder=" Password"> 
		<input type="submit" value="Login">
	</form>
</body>
</html>