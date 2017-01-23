<!DOCTYPE html>
<html>
<body>
<form action="QueryHandller" name="frm1">
<select name="myselect">

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

<button onclick="myFunction()" type="button">add more constraints</button>

<script>
function myFunction() {
	var form=document.getElementsByName("frm1")[0];
	
		var labls = ["User id","Zip Code","Work History Count","Total Years Experience","State","Salary","Managed Others yes or no"
		             ,"Managed How Many","Major","Job Title","Degree Type","Country","Currently Employed yes or no"];
		 var vals=["UserID","ZipCode","WorkHistoryCount","TotalYearsExperience","State","Salary","ManagedOthers","ManagedHowMany","Major","JobTitle","DegreeType","Country","CurrentlyEmployed"];
		
		  
	//Create and append select list
	var selectList = document.createElement("select");
	selectList.id = "myselect";
	selectList.name="myselect"
		for (var i = 0; i < vals.length; i++) {
		    var option = document.createElement("option");
		    option.value = vals[i];
		    option.text = labls[i];
		    selectList.appendChild(option);
		}
	form.appendChild(selectList);
	    var filter = document.createElement("INPUT");
	    filter.setAttribute("type", "text");
	    filter.setAttribute("name", "filter");
	form.appendChild(filter); 
	}
</script>
<input value="submit" type="submit">
<input type="hidden" name="iden" value="multiquer">
</form>
<a
href="advaced.jsp">Advanced Search</a>
</body>
</html>
