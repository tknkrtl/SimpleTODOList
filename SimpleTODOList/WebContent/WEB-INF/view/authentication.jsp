<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register & Login</title>
	
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/auth.css">
		<style>
		
		.error{color:red;}
		.success{color:green;}
		</style>
	
</head>


<body>

	<div id="wrapper">
	
		<div id="header">
			<h2> Welcome..!! </h2>
		</div>
	
	</div>
	
		<div id="container">
			
			<form:form action="verify" modelAttribute="tempLogin" method="POST">

		
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
			<td><input class="but" type="submit" value="Login">
			<input class="but" type="button" value="Register" onclick="window.location.href='registration'; return false;"></td>
			</tr>
			
			</table>
			
			
			<c:if test="${successRegister!=null}">
		   	<p class="success">${successRegister}</p>
		    </c:if>
		    <c:if test="${loginErr!=null}">
		   	<p class="error">${loginErr}</p>
		    </c:if>
		     <c:if test="${bindingError!=null}">
		   	<p class="error">${bindingError}</p>
		    </c:if>
			
			</form:form>
			
		</div>
	
	
	

</body>

</html>