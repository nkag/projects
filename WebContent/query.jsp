<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hello</title>
</head>
<body bgcolor="wheat">

<form action="QueryHandller">


Select the filtering field
<select name="selecter">

  <option value="UserID">User id</option>
  <option value="ZipCode">Zip Code</option>
  <option value="WorkHistoryCount">Work History Count</option>
  <option value="TotalYearsExperience">Total Years Experience</option>
  <option value="State">State</option>
  <option value="Salary">Salary</option>
  <option value="ManagedOthers">Managed Others yes or no</option>
  <option value="ManagedHowMany">Managed How Many</option>
  <option value="Major">Major</option>
  <option value="JobTitle">Job Title</option>
  <option value="DegreeType">Degree Type</option>
  <option value="Country">Country</option>
  <option value="CurrentlyEmployed">Currently Employed yes or no</option>
  
  
</select>
 
<br>
value for filtering:<br>
<input type="text" name="filter">
<br>
<input type="submit" value="Submit">
<input type="hidden" name="iden" value="singlequer">
</form> 

</body>
</html>