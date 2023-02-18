<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar producto ${producto.idProducto}</title>
</head>
<body>
	<h1>Formulario para modificar el producto ${producto.idProducto}</h1>
	<form action="/producto/editar" method="post">
		<p><input type="text" name="idProducto" value="${producto.idProducto }"> ID Producto</p>
		<p><input type="text" name="nombre" value="${producto.nombre }"> Nombre</p>
		<p><input type="text" name="descripcion" value="${producto.descripcion }"> Descripcion</p>
		<p><input type="number" name="precio" step="0.01" value="${producto.precio }"> Precio Unidad</p>
		<p><input type="number" name="stock" value="${producto.stock }"> Stock</p>

		<p><input type="submit" value="Guardar"></p>
	
	</form>
</body>
</html>