<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<style type="text/css">
.auto-style1 {
	font-family: arial, sans-serif;
	font-size: 24px;
	letter-spacing: normal;
	background-color: #FFFFFF;
}
.auto-style2 {
	margin-left: 96px;
}
.auto-style3 {
	margin-left: 101px;
}
.auto-style4 {
	font-size: small;
}
.auto-style9 {
	margin-top: 0px;
}
</style>
</head>
<img alt="" class="auto-style9" height="237" src=".\page0001.jpg" width="772" /><br />
<body bgcolor="wheat" align="center">
<form action="QueryHandller" method="post">
<center>
<table>

<tr><h1>
<td>User name:</td>
<td><input type="text" name="uname" ></td>
</tr>

<tr>
<td>Password:</td>
<td><input type="password" name="pwd"></td>
</tr>
<tr>
<td><input type="submit" value="Login"></td>
<td><a href="register.jsp" style="color: #CC0000">Register</a></td>
</tr></h1>
</table>
</center> 
<input type="hidden" value="login" name ="iden">
</form>
</body>
</html>