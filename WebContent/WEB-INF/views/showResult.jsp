<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<br/>
<br/>
<div class="row mx-5"><h1>Logged in Admin</h1></div>
<br/><br/>
<div class="container">
<table class="table table-hover table-bordered">
 <thead class="thead-dark">
<tr>
<th> Message </th>
<th> Sender Name </th>
<th> Sender Email </th>
</tr>
</thead>
<tbody>
<c:forEach items="${complaints}" var="com">
<tr>
<td><c:out value="${com.message}"></c:out></td>
<td><c:out value="${com.senderName}"></c:out></td>
<td><c:out value="${com.sender_email}"></c:out></td>
</tr>
</c:forEach>
</tbody>


</table>
</div>
<div class="row mx-5"><a href="<c:url value='/logout' />">Logout</a></div>
</body>
</html>