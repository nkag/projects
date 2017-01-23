<!DOCTYPE html>
<html>
<body>
<form action="QueryHandller" name="frm1">
Make it OR<input type="checkbox" name="orcheck" value="orcheck">
<button onclick="addRange()" type="button">add range constraint</button>
<button onclick="addNormal()" type="button">add normal constraint</button>

<script>
function addRange() {
	var form=document.getElementsByName("frm1")[0];
	
		var labls = ["Zip Code","Work History Count","Total Years Experience","Salary","Managed How Many"];
		 var vals=["ZipCode","WorkHistoryCount","TotalYearsExperience","Salary","ManagedHowMany"];
		
		  
	//Create and append select list
	var selectList = document.createElement("select");
	selectList.id = "rangeselect";
	selectList.name="rangeselect"
		for (var i = 0; i < vals.length; i++) {
		    var option = document.createElement("option");
		    option.value = vals[i];
		    option.text = labls[i];
		    selectList.appendChild(option);
		    
		}
	form.appendChild(selectList);
	var lfilter = document.createElement("INPUT");
	lfilter.setAttribute("type", "text");
	lfilter.setAttribute("name", "lfilter");
	form.appendChild(lfilter); 
	var rfilter = document.createElement("INPUT");
    rfilter.setAttribute("type", "text");
    rfilter.setAttribute("name", "rfilter");
    form.appendChild(rfilter); 
	
	}
	
	
	
	
function addNormal() {
	var form=document.getElementsByName("frm1")[0];
	
		var labls = ["User id","Zip Code","Work History Count","Total Years Experience","State","Salary","Managed Others yes or no"
		             ,"Managed How Many","Major","Job Title","Degree Type","Country","Currently Employed yes or no"];
		 var vals=["UserID","ZipCode","WorkHistoryCount","TotalYearsExperience","State","Salary","ManagedOthers","ManagedHowMany","Major","JobTitle","DegreeType","Country","CurrentlyEmployed"];
		
		  
	//Create and append select list
	var selectList = document.createElement("select");
	selectList.id = "normalselect";
	selectList.name="normalselect"
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
<input type="hidden" name="iden" value="advquer">
</form>
<a
href="advaced.jsp">Advanced Search</a>
</body>
</html>
