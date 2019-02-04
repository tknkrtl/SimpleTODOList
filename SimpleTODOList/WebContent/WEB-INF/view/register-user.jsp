<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/auth.css">
	<style>
		
		.error{color:red;}
			
	</style>

</head>


<body>

<body>

	<div id="wrapper">
	
		<div id="header">
			<h2> Welcome..!! </h2>
		</div>
	
	</div>
	
	<div id="content">
	
		<div id="container">
			
			<form:form action="registerUser" modelAttribute="tempLogin" method="POST">
			
			<table>
			<tr>
			<td><label>Username:</label> </td>
			<td><form:input path="username"/><td>
			</tr>
			
			<tr>
			<td><label>Password:</label> </td>
			<td><form:password path="password"/><td>
			</tr>
			
			<tr>
			<td></td>
			<td><input type="submit" value="Register and Login">
			</tr>
			
			<tr> 
			<c:if test="${successRegister!=null}">
				<p class="error">${successRegister}</p>
			</c:if>
			</tr>
			</table>
			
			<br><br>
			<a href="${pageContext.request.contextPath}/authentication">Back to the Login!</a>
			<br><br>
			
			 <c:if test="${bindingError!=null}">
		   	<p class="error">${bindingError}</p>
		    </c:if>
		    
			
			</form:form>
			
		</div>
	
	</div>
	
	
	

</body>




</body>


</html>