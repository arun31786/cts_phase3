<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>${title}</title>

</head>
<body>

<form:form action="./getJson" method="post">
    <input type="submit" value="GetJsonResponse" />
</form:form>

    <input type="button" onclick="getAjaxJson()" value="GetJsonAjaxResponse" />
    
	<table id="dataTable">
		<tr>
			<th>Index</th>
			<th>Employee</th>
		</tr>
	</table>
	<script>
		var i = 0;
		var table = document.getElementById("dataTable");
		table.style.display = "none";
	
		function getAjaxJson(){
			var xhr = new XMLHttpRequest();
	
			xhr.onreadystatechange= function(){
				if (xhr.readyState==4 && xhr.status==200){
					console.log(typeof xhr.response);
					var response = JSON.parse(xhr.response);
					console.log(response);
					table.style.display = "block";


					response.forEach(function(res){
						addRows(res);
					})
					
					localStorage.setItem("data", JSON.stringify(response));

					//alert("Table created");
					window.location.href = "http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/";
				}
			}
			xhr.open("POST","http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/getJson",true);
			xhr.send();				
		}

		function addRows(data) {

			var rowCount = table.rows.length;
			var row = table.insertRow(rowCount);

			var firstCell = row.insertCell(0);
			firstCell.innerHTML=++i;

			var secondCell = row.insertCell(1);
			secondCell.innerHTML=data;
		}
	</script>

</body>
</html>
