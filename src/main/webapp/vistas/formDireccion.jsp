<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Direccion Nueva</title>
</head>
<body>
	<h1>Formulario de Alta de Direccion</h1>
	<p>${sesion.nombre}, añade una dirección:</p>
	<form action="/direccion/nueva" method="post">
		<p>Calle: <input type="text" name="calle"></p>
		<p>Numero: <input type="text" name="numero"></p>
		<p>Piso: <input type="text" name="piso"></p>
		<p>Puerta: <input type="text" name="puerta"></p>
		<p>Localidad: <input type="text" name="localidad"></p>
		<p>Codigo Postal: <input type="text" name="codigoPostal"></p>
		<p><input type="submit" value="Enviar"></p>

	</form>
</body>
</html>