<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Producto</title>
</head>
<body>
	<h1>Formulario de Alta de Producto</h1>
	<form action="/producto/alta" method="post">


		<p><input type="text" name="nombre">Nombre</p>
		<p><input type="text" name="descripcion" >Descripcion</p>
		<p><input type="number" step="0.01" name="precio" >Precio Unidad</p>
		<p><input type="number" name="stock">Stock</p>
		
		
		<p><input type="submit" value="Enviar"></p>
		
	
	</form>
</body>
</html>