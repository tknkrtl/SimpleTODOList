<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Form</title>

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<style type="text/css">
		
		.error{
		color:red;
		}
		.success{
		color: green;
		}
	</style>
	
</head>

	

	
<body>
	
	<div id="wrapper">
	
		<div id="header">
			<h2> Task Form </h2>
		</div>
	
	</div>
	
		<div id="container">
		
			<form:form action="verifyTask" modelAttribute="task">
			
			<form:hidden path="id"/>
			
			<c:if test="${bindingError!=null}">
				<p class="error">${bindingError}</p>			
			</c:if>
			<c:if test="${success!=null}">
				<p class="success">${success}</p>			
			</c:if>
			
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label> </td>
						<td><form:input path="name"/></td>
					</tr>
					<tr>
						<td><label>Description:</label> </td>
						<td><form:input path="description"/></td>
					</tr>
					<tr>
						<td><label>Deadline:</label> </td>
						<td><form:input type="date" min="" path="deadline"/></td>
					</tr>
			
					<tr>
					<td></td>
					<td><input type="submit" value="Save"></td>
					</tr>
					
					<tr>
					<td><a href="${pageContext.request.contextPath}/home"></a></td>
					</tr>
						
				</tbody>
			</table>
			</form:form>
		
		</div>
	
		

</body>


</html>