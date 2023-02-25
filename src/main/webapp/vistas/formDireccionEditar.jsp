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
	<h1>Formulario para modificar la direccion localizada en ${direccion.calle}</h1>
	<p>${sesion.nombre}, añade una dirección:</p>
	<form action="/direccion/editar/${direccion.idDireccion}" method="post">
		<p>Calle: <input type="text" name="calle" value="${direccion.calle}"></p>
		<p>Numero: <input type="text" name="numero" value="${direccion.numero}"></p>
		<p>Piso: <input type="text" name="piso" value="${direccion.piso}"></p>
		<p>Puerta: <input type="text" name="puerta" value="${direccion.puerta}"></p>
		<p>Localidad: <input type="text" name="localidad" value="${direccion.localidad}"></p>
		<p>Codigo Postal: <input type="text" name="codigoPostal" value="${direccion.codigoPostal}"></p>
		<p><input type="submit" value="Enviar"></p>

	</form>
</body>
</html>