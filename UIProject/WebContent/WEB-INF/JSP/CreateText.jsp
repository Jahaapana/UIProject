<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Text</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	$(document).ready(function() {

		$('#Tlabel').bind('blur', function() {
			if ($('#Tlabel').val().length >= 1) {
				$('.inputDisabled2').prop("disabled", false);
			} else {
				$('.inputDisabled2').prop("disabled", true);
			}
			if ($('#Tlabel').val().length >= 1) {
				if ($('#Tdescription').val().length >= 1) {
					$('.inputDisabled').prop("disabled", false);
				}
			} else {
				$('.inputDisabled').prop("disabled", true);
			}
		});

		$('#Tdescription').bind('blur', function() {
			if ($('#Tlabel').val().length >= 1) {
				$('.inputDisabled2').prop("disabled", false);
			} else {
				$('.inputDisabled2').prop("disabled", true);
			}
			if ($('#Tdescription').val().length >= 1) {
				if ($('#Tlabel').val().length >= 1) {
					$('.inputDisabled').prop("disabled", false);
				}
			} else {
				$('.inputDisabled').prop("disabled", true);
			}
		});
	});

function testButtonStatus(){
	if ($('#Tlabel').val().length >= 1) {
		$('.inputDisabled2').prop("disabled", false);
	} else {
		$('.inputDisabled2').prop("disabled", true);
	}
	if ($('#Tdescription').val().length >= 1) {
		if ($('#Tlabel').val().length >= 1) {
			$('.inputDisabled').prop("disabled", false);
		}
	} else {
		$('.inputDisabled').prop("disabled", true);
	}
}
function resetDisabled(){
	document.getElementById('b1').disabled=true;
	document.getElementById('b2').disabled=true;
	document.getElementById('b3').disabled=true;
	document.getElementById("myForm").reset();
}
</script>
<style>
.ScrollRequired
{
    max-height: 150px;
    overflow-y: scroll;
}
table#result-table th {  
    color: white;  
    background-color: gray;  
}
table#result-table tr:nth-child(even) {  
    background-color: #eee;  
}  
table#result-table tr:nth-child(odd) {  
    background-color: #fff;  
}    
</style>
</head>
<body onload="testButtonStatus()">
	<form:form method="POST" action="FromCreateText" id="myForm" >
	<div >
		<table align="center" width="350" height="100">
			<tr>
				<td><form:label path="label">Label</form:label></td>
				<td><form:input id="Tlabel" path="label" /></td>

				<td><form:label path="description">Description</form:label></td>
				<td><form:input id="Tdescription" path="description" /></td>
				
				<form:hidden path="id" />
				<form:hidden path="createdDate" />
				<form:hidden path="createdBy" />
				<form:hidden path="updatedDate" />
				<form:hidden path="updatedBy" />
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit" id="b1" value="Search" disabled="disabled" class="inputDisabled2"  name="Search" />  &nbsp; &nbsp;  &nbsp;
				<input type="reset"  id="b2" value="Reset"  disabled="disabled" class="inputDisabled2" onclick="resetDisabled()" /> &nbsp; &nbsp; &nbsp;
				<input type="submit" id="b3" value="Save"   disabled="disabled"	class="inputDisabled" name="Save"/>
				</td>
			</tr>
			<tr><td colspan="2">${msg}</td></tr>
			<tr></tr>
		</table>
		</div>
		<div class="ScrollRequired">
			<table id="result-table" align="center" width="450" height="100">
				<tr>
					<c:forEach items="${headerinfo}" var="headervalue">
						<th><c:out value="${headervalue}" /></th>
					</c:forEach>
				</tr>
				<c:forEach items="${lists}" var="cText" varStatus="status">
					<tr>
						<%-- <td><a onclick="location.href='updateCreateText/${lists[status.index].label}'"><c:out value="${cText.id}" /></a></td> --%>
						<td><c:out value="${cText.id}" /></td>
						<td><a href="<c:url value='/updateCreateText/${lists[status.index].label}'/>" ><c:out value="${cText.label}" /></a></td>
						<td><c:out value="${cText.description}" /></td>
						<td><c:out value="${cText.language}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form:form>
  </body>
</html>