<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Usuarios</h1>
	<table border = "2px">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellidos</th>
		</tr>
	<c:forEach var="user" items="${ usuario }">
		<tr>
			<td>${ user.idUsuario }</td>
			<td>${ user.nombre }</td>
			<td>${ user.apellidos }</td>
		</tr>
	</c:forEach>
	</table>
	
</body>
</html> 