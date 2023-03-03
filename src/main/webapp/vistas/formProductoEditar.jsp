
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
	
	<jsp:include page="nav.jsp"></jsp:include>
	
	<div class ="container">
	<h3 class="text-primary m-3">Actualizacion de ${producto.nombre}</h3>
	
	<form action="/producto/editar" method="post">
		<div class="input-group mt-2">
			<span class="input-group-text">ID Producto</span>
			<input class="form-control" type="text" name="idProducto" value="${producto.idProducto }">
		</div>
			<div class="input-group mt-2">
			<span class="input-group-text">Nombre</span>
			<input class="form-control" type="text" name="nombre" value="${producto.nombre }">
		</div>
		<div class="input-group mt-2">
			<span class="input-group-text">Descripcion</span>
			<input class="form-control" type="text" name="descripcion" value="${producto.descripcion }">
		</div>
		<div class="input-group mt-2">
			<span class="input-group-text">Precio</span>
			<input class="form-control" type="number" name="precio" step="0.01" value="${producto.precio }">
		</div>
		<div class="input-group mt-2">
			<span class="input-group-text">Stock</span>
			<input class="form-control" type="number" name="stock" value="${producto.stock }">
		</div>
		 <button type="submit" class="btn btn-primary mt-3">Actualizar</button>
	
	</form>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>