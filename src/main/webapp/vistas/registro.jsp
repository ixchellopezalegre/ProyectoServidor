<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hola</h1>
	<h1>${mensaje }</h1>
	<form action="/registro" method="post">
		<input type="text" name="username" placeholder="Username"> <input
			type="text" name="password" placeholder="Contrase�a"> <input
			type="text" name="nombre" placeholder="Nombre"> <input
			type="text" name="apellidos" placeholder="Apellidos"> <input
			type="text" name="direccion" placeholder="Direccion"> <input
			type="submit" value="Registrar">


	</form>
</body>
</html>