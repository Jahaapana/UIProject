<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Screen Text Mapping</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	
$(document).ready(function() {
				$('#TSCode').bind('blur',function() {
							if ($('#TSCode').val().length >= 1) {
								$('.type1').prop("disabled", false);
							} else {
								$('.type1').prop("disabled", true);
							}
							if (($('#TSName').val().length >= 1) && ($('#TSTCode').val().length >= 1) && ($('#TCode').val().length >= 1) && ($('#TType').val().length >= 1)) {
								$('.type2').prop("disabled", false);
							} else {
								$('.type2').prop("disabled", true);
							}
						});

				$('#TSName').bind('blur', function() {
					if ($('#TSCode').val().length >= 1) {
						$('.type1').prop("disabled", false);
					} else {
						$('.type1').prop("disabled", true);
					}
					if (($('#TSName').val().length >= 1) && ($('#TSTCode').val().length >= 1) && ($('#TCode').val().length >= 1) && ($('#TType').val().length >= 1)) {
						$('.type2').prop("disabled", false);
					} else {
						$('.type2').prop("disabled", true);
					}
				});

				$('#TSTCode').bind('blur', function() {
					if ($('#TSCode').val().length >= 1) {
						$('.type1').prop("disabled", false);
					} else {
						$('.type1').prop("disabled", true);
					}
					if (($('#TSName').val().length >= 1) && ($('#TSTCode').val().length >= 1) && ($('#TCode').val().length >= 1) && ($('#TType').val().length >= 1)) {
						$('.type2').prop("disabled", false);
					} else {
						$('.type2').prop("disabled", true);
					}
				});

				$('#TCode').bind('blur', function() {
					if ($('#TSCode').val().length >= 1) {
						$('.type1').prop("disabled", false);
					} else {
						$('.type1').prop("disabled", true);
					}
					if (($('#TSName').val().length >= 1) && ($('#TSTCode').val().length >= 1) && ($('#TCode').val().length >= 1) && ($('#TType').val().length >= 1)) {
						$('.type2').prop("disabled", false);
					} else {
						$('.type2').prop("disabled", true);
					}
				});
				
				$('#TType').bind('blur', function() {
					if ($('#TSCode').val().length >= 1) {
						$('.type1').prop("disabled", false);
					} else {
						$('.type1').prop("disabled", true);
					}
					if (($('#TSName').val().length >= 1) && ($('#TSTCode').val().length >= 1) && ($('#TCode').val().length >= 1) && ($('#TType').val().length >= 1)) {
						$('.type2').prop("disabled", false);
					} else {
						$('.type2').prop("disabled", true);
					}
				});
});

	function testButtonStatus() {
		if ($('#TSCode').val().length >= 1) {
			$('.type1').prop("disabled", false);
		} else {
			$('.type1').prop("disabled", true);
		}
		if (($('#TType').val().length >= 1) && ($('#TCode').val().length >= 1) && ($('#TSTCode').val().length >= 1) && ($('#TSName').val().length >= 1)) {
			$('.type2').prop("disabled", false);
		} else {
			$('.type2').prop("disabled", true);
		}
		
		// To add class in to result table
		 var table = document.getElementById("result-table");   
		 var rows = table.getElementsByTagName("tr");   
		    for(i = 0; i < rows.length; i++){           
		      if(i % 2 == 0){ 
		        rows[i].className = "even"; 
		      }else{ 
		        rows[i].className = "odd"; 
		      }       
		    } 
	}

	function resetDisabled() {
		document.getElementById('b1').disabled = true;
		document.getElementById('b2').disabled = true;
		document.getElementById('b3').disabled = true;
		document.getElementById('b4').disabled = true;
		document.getElementById("myForm").reset();
	}
	
	function showScreenName(variable){
		//alert(variable);
		//document.getElementById('TSName').value = variable;
		document.getElementById("TSName").value=variable.substring(variable.indexOf(".", 0)+1);
	}
</script>
<style>
.ScrollRequired
{
    max-height: 150px;
    overflow-y: scroll;
}
.even{
 background-color: #ccccff;
}
#TSCode{
width:150px;
}
#TCode{
width:150px;
}
#TType{
width:150px;
}
/* table.result-table{
	tr:nth-child(even) {
	    background: #ccccff;
	} */
/* background-color: #ccccff; */
/*}*/
/* li:nth-child(even) {
    background: blue;
} */
</style>
</head>
<body onload="testButtonStatus()">
<form:form method="POST" action="fromScreenTextMapping" id="myForm" >
<div>
<table align="center" width="350" height="100">
		
			<tr>
				<td><form:label path="screenCode">Screen Code</form:label>
				<form:select id="TSCode" path="screenCode" onchange="showScreenName(this.value);">
					<form:option value="" label="-- Select Any --" />
					<form:options items="${screenCodeOptions}" itemLabel="screenCode" itemValue="Code_Name" />
				</form:select></td>
				<%-- <form:input id="TSCode" path="screenCode" /> --%>

				<td><form:label path="screenName">Screen Name</form:label>
				<form:input id="TSName" path="screenName" readonly="true"/></td>
			</tr>
			<tr></tr>
			<tr>	
				<td><form:label path="screenTextCode">Screen Text Code</form:label>
				<form:input id="TSTCode" path="screenTextCode" /></td>
				
				
			<td><form:label path="textCode">Text Code</form:label>
				<%-- <form:input id="TCode" path="textCode" /> --%>
				<form:select id="TCode" path="textCode" >
					<form:option value="" label="-- Select Any --" />
					<form:options items="${textCodeOptions}" itemLabel="label" itemValue="label" />
				</form:select>
				</td>
				
				<td><form:label path="textType">Text Type</form:label>
				<%-- <form:input id="TType" path="textType" /> --%>
				<form:select id="TType" path="textType" >
					<form:option value="" label="-- Select Any --" />
					<form:options items="${textTypeOptions}" />
				</form:select>
				</td>
			</tr>
			<tr>	
				<form:hidden path="id" />
				<%-- <form:hidden path="createdDate" />
				<form:hidden path="createdBy" />
				<form:hidden path="updatedDate" />
				<form:hidden path="updatedBy" /> --%>
			</tr>
			<tr></tr><tr></tr><tr></tr>
			<tr>
				<td colspan="2">
				<input type="submit" id="b1" value="Search" disabled="disabled" class="type1"  name="Search" />  &nbsp; &nbsp;  &nbsp;
				<input type="reset"  id="b2" value="Reset"  disabled="disabled" class="type1" onclick="resetDisabled()" /> &nbsp; &nbsp; &nbsp;
				<input type="submit" id="b3" value="Save"   disabled="disabled"	class="type2" name="Save"/>&nbsp; &nbsp;  &nbsp;
				<input type="submit" id="b4" value="Delete"   disabled="disabled"	class="type1" name="Delete"/>&nbsp; &nbsp;  &nbsp;
				</td>
			</tr>
			<tr><td colspan="2">${msg}</td></tr>
			<tr></tr>
</table>
</div>
<div class="ScrollRequired">
			<table id="result-table" align="center" width="500" height="100">
				<tr>
					<c:forEach items="${headerinfo}" var="headervalue">
						<th><c:out value="${headervalue}" /></th>
					</c:forEach>
				</tr>
				<c:forEach items="${lists}" var="cText" varStatus="status">
					<tr>
						<%-- <td><a onclick="location.href='updateCreateText/${lists[status.index].label}'"><c:out value="${cText.id}" /></a></td>
						<td><c:out value="${cText.id}" /></td>
						<td><a href="<c:url value='/updateCreateText/${lists[status.index].label}'/>" ><c:out value="${cText.label}" /></a></td>
						<td><c:out value="${cText.description}" /></td>
						<td><c:out value="${cText.language}" /></td> --%>
						<td><a href="<c:url value='/updateScreenTextMapping/${lists[status.index].screenCode}'/>" ><c:out value="${cText.screenCode}" /></a></td>
						<td><c:out value="${cText.screenName}" /></td>
						<td><c:out value="${cText.screenTextCode}" /></td>
						<td><c:out value="${cText.textCode}" /></td>
						<td><c:out value="${cText.textType}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
</form:form>
</body>
</html>