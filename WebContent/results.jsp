<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.mongodb.DBObject,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="wheat">
<table border="1">
<tr><td>UserID</td>
<td>Country</td>
<td>City</td>
<td>Currently Employed</td>
<td>Job Title</td>
<td>Total Years Experience</td>

<td>Salary</td>
<td>Managed Others</td>
<td>ZipCode</td>
 
 </tr>
<%HttpSession sessionsa = request.getSession(true);
ArrayList<DBObject> results = (ArrayList<DBObject>) sessionsa.getAttribute("res");

for(DBObject d:results) 
{%>
<tr>
<td><%=d.get("UserID")%></td>
<td><%=d.get("Country")%></td>
<td><%=d.get("City")%></td>
<td><%=d.get("CurrentlyEmployed")%></td>
<td><%=d.get("JobTitle")%></td>
<td><%=d.get("TotalYearsExperience")%></td>
<td><%=d.get("Salary")%></td>
<td><%=d.get("ManagedOthers")%></td>
<td><%=d.get("ZipCode")%></td>

</tr>
<%} %>
</table>
</body>
</html>