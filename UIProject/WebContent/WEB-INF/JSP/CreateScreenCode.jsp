<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Screen Code Creation</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
	
$(document).ready(function() {
				$('#TSCode').bind('blur',function() {
							if ($('#TSCode').val().length >= 1) {
								$('.type1').prop("disabled", false);
							} else {
								$('.type1').prop("disabled", true);
							}
							if (($('#TDesc').val().length >= 1) && ($('#TSType').val().length >= 1) && ($('#TSCode').val().length >= 1) && ($('#TSName').val().length >= 1)) {
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
					if (($('#TDesc').val().length >= 1) && ($('#TSType').val().length >= 1) && ($('#TSCode').val().length >= 1) && ($('#TSName').val().length >= 1)) {
						$('.type2').prop("disabled", false);
					} else {
						$('.type2').prop("disabled", true);
					}
				});

				$('#TDesc').bind('blur', function() {
					if ($('#TSCode').val().length >= 1) {
						$('.type1').prop("disabled", false);
					} else {
						$('.type1').prop("disabled", true);
					}
					if (($('#TDesc').val().length >= 1) && ($('#TSType').val().length >= 1) && ($('#TSCode').val().length >= 1) && ($('#TSName').val().length >= 1)) {
						$('.type2').prop("disabled", false);
					} else {
						$('.type2').prop("disabled", true);
					}
				});

				$('#TSType').bind('blur', function() {
					if ($('#TSCode').val().length >= 1) {
						$('.type1').prop("disabled", false);
					} else {
						$('.type1').prop("disabled", true);
					}
					if (($('#TDesc').val().length >= 1) && ($('#TSType').val().length >= 1) && ($('#TSCode').val().length >= 1) && ($('#TSName').val().length >= 1)) {
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
		if (($('#TDesc').val().length >= 1) && ($('#TSType').val().length >= 1) && ($('#TSCode').val().length >= 1) && ($('#TSName').val().length >= 1)) {
			$('.type2').prop("disabled", false);
		} else {
			$('.type2').prop("disabled", true);
		}
	}

	function resetDisabled() {
		document.getElementById('b1').disabled = true;
		document.getElementById('b2').disabled = true;
		document.getElementById('b3').disabled = true;
		document.getElementById('b4').disabled = true;
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

<form:form method="POST" action="fromCreateScreenCode" id="myForm" >
<div>
<table align="center" width="350" height="100">
				<tr>
					<td align="center" colspan="2"><b><u>Create Screen Code</u></b></td>
					<td><a href="/UIProject">Back</a></td>
				</tr>
				<tr></tr><tr></tr><tr></tr>
				<tr>
				<td><form:label path="screenCode">Screen Code</form:label>
				<form:input id="TSCode" path="screenCode" /></td>

				<td><form:label path="screenName">Screen Name</form:label>
				<form:input id="TSName" path="screenName" /></td>
				
				<td><form:label path="description">Description</form:label>
				<form:input id="TDesc" path="description" /></td>
			</tr>	
				
			<tr><td><form:label path="screenType">Screen Type</form:label>
				<form:select id="TSType" path="screenType">
					<form:option value="" label="--- Select ---" />
					<form:options items="${screenTypeList}" itemLabel="label" itemValue="value" />
				</form:select></td>
			</tr>
			<tr>	
			<td colspan="2"><form:label path="cTypeSelect">Select</form:label> <form:checkbox path="cTypeSelect" /> &nbsp; &nbsp;  &nbsp;
			 <form:label path="cTypeInsert">Insert</form:label> <form:checkbox path="cTypeInsert" /> &nbsp; &nbsp;  &nbsp;
			 <form:label path="cTypeUpdate">Update</form:label> <form:checkbox path="cTypeUpdate" /> &nbsp; &nbsp;  &nbsp;
			 <form:label path="cTypeDelete">Delete</form:label> <form:checkbox path="cTypeDelete" /></td>
			<!-- URL for check box creation in spring forms : https://www.mkyong.com/spring-mvc/spring-mvc-checkbox-and-checkboxes-example/ -->
			
				<%-- <form:hidden path="id" /> --%>
				<form:hidden path="createdDate" />
				<form:hidden path="createdBy" />
				<form:hidden path="updatedDate" />
				<form:hidden path="updatedBy" />
			
			</tr>
			<%-- <form:hidden path="id" /> --%>
			
			<tr>
				<td colspan="2">
				<input type="submit" id="b1" value="Search" disabled="disabled" class="type1"  name="Search" />  &nbsp; &nbsp;  &nbsp;
				<input type="reset"  id="b2" value="Reset"  disabled="disabled" class="type1" onclick="resetDisabled()" /> &nbsp; &nbsp; &nbsp;
				<input type="submit" id="b3" value="Save"   disabled="disabled"	class="type2" name="Save"/>&nbsp; &nbsp;  &nbsp;
				<input type="submit" id="b4" value="Delete"   disabled="disabled"	class="type1" name="Delete"/>&nbsp; &nbsp;  &nbsp;
				</td>
			</tr>
			<tr><td colspan="2" style="color:red">${msg}</td></tr>
			<tr></tr>
</table>
<!-- deleting the row on click of button -->
<!-- $(".deleteMe").on("click", function(){
   $(this).closest("li").remove(); 
});
<ul>
    <li>item one <div class='deleteMe'>X</div></li>
    <li>item two <div class='deleteMe'>X</div></li>
    <li>item three <div class='deleteMe'>X</div></li>
    ....
</ul> -->
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
						<td><a href="<c:url value='/updateCreateScreenCode/${lists[status.index].screenCode}'/>" ><c:out value="${cText.screenCode}" /></a></td>
						<td><c:out value="${cText.screenName}" /></td>
						<td><c:out value="${cText.screenType}" /></td>
						<td><c:out value="${cText.description}" /></td>
						<td><c:out value="${cText.cTypeSelect}" /></td>
						<td><c:out value="${cText.cTypeInsert}" /></td>
						<td><c:out value="${cText.cTypeUpdate}" /></td>
						<td><c:out value="${cText.cTypeDelete}" /></td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
</form:form>
</body>
</html>