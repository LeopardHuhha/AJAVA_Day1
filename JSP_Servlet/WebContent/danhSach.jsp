<%@page import="java.util.ArrayList"%>
<%@page import="dbAccess.*"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account List</title>
</head>
<body>
	<label>Chào mừng trở lại</label>

	<table border="1" align="center">
		<thead style="font-weight: bold">
			<tr style="font-size: 120%">
				<td>ID</td>
				<td>Username</td>
				<td>Password</td>
				<td>Email</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Account> accList = new ArrayList<Account>();
				DBAccess run = new DBAccess();
				accList = run.getAccList();
				for (int i = 0; i < accList.size(); i++) {
			%>
			<tr>
				<td><%=i + 1%></td>
				<td><%=accList.get(i).getUser()%></td>
				<td><%=accList.get(i).getPass()%></td>
				<td><%=accList.get(i).getEmail()%></td>
				<td><a href="danhSach.jsp"
					style="text-decoration: none; color: #0000ee">Add</a> <a
					href="edit.jsp?id=<%=(int) accList.get(i).getId()%>"
					style="text-decoration: none">Edit</a> <a
					href="eventDel.jsp?id=<%=(int) accList.get(i).getId()%>"
					style="text-decoration: none">Del</a></td>
			</tr>

			<%
				}
			%>
		</tbody>
	</table>
	<form align="center" style="margin-top: 30px" action="eventAdd.jsp"
		method="post">
		<input type="text" name="txt_user" placeholder=" Username" /><br>
		<input type="text" name="txt_pass" placeholder=" Password" /><br>
		<input type="text" name="txt_email" placeholder=" Email" /><br>
		<button style="margin-top: 10px" type="submit">Add</button>
	</form>
</body>
</html>