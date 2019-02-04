<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>

		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
		
		<style type="text/css">
		
		.error{
		color:red;
		}
		.success{
		color:green;
		}
		</style>

</head>
<body>
	
	<div id="wrapper">
	
		<div id="header">
			<h2> Welcome to TODOList App ,${userName}  !!!</h2>
		</div>
	
	</div>
	
	<div id="container">
	
		<div id="content">		
			

			
			<input type="button" value="Add Task" onclick="window.location.href='addTask'; return false;"
			class="add"
			/>	
			
			<table>
			
			<c:url var="orderNameLink" value="/orderByName">
 			</c:url>
 			<c:url var="orderDeadlineLink" value="/orderByDeadline">
 			</c:url>
 			<c:url var="orderStatusLink" value="/orderByStatus">
 			</c:url>	
 			<c:url var="orderCreateDateLink" value="/orderByCreateDate">
 			</c:url>
				<tr>
					<th><a class="link" href="${orderNameLink}">Name</a></th>
					<th>Description</th>
					<th><a class="link" href="${orderDeadlineLink}">Deadline </a></th>
					<th><a class="link" href="${orderStatusLink}">Status </a></th>
					<th><a class="link" href="${orderCreateDateLink}">Create Date </a></th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="task" items="${tasks}">
				
				<c:url var="updateLink" value="/updateTask">
					<c:param name="taskId" value="${task.id}" />
 				</c:url>
 				
 				
				<c:url var="deleteLink" value="/deleteTask">
					<c:param name="taskId" value="${task.id}" />
 				</c:url> 
 				
 				<c:url var="statusLink" value="/changeStatus">
					<c:param name="taskId" value="${task.id}" />
 				</c:url>
				<tr>
					<td> ${task.name} </td>
					<td> ${task.description} </td>
					<td> ${task.deadline} </td>
					<td> ${task.status} 
					|
					<a class="link" href="${statusLink}">Change</a>
					</td>
					<td> ${task.createDate} </td>
					<td> 
						<!-- display the update link -->
						<a class="link" href="${updateLink}">Update</a>
						|
						<a class="link" href="${deleteLink}"
						onclick="return confirm('Are you sure you want to delete this task')">Delete</a>					
					</td>
				</tr>
				</c:forEach>
				
				<c:if test="${success!=null}">
				<p class="success">${success}</p>
				</c:if>
				
			</table>
			
		</div>
	
	</div>	


</body>
</html>