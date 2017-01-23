<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hello</title>
</head>
<body bgcolor="wheat">
<form action="QueryHandller" method="post">
<center>
<table>

<tr>
<td>User name:</td>
<td><input type="text" name="uname" ></td>
</tr>

<tr>
<td>Password:</td>
<td><input type="password" name="pwd"></td>
</tr>
<tr>
<td><input type="submit" value="Register"></td>
<td><input type="reset" value="Reset"></td>
</tr>
</table>
</center> 
<input type ="hidden" name ="iden" value="register">
</form>
</body>
</html>