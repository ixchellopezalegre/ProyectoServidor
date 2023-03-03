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
	<jsp:include page="nav.jsp"></jsp:include>
	
	<div class ="container">
		<h3 class ="text-primary">Formulario de Alta de Producto</h3>
		
			<form action="/producto/alta" method="post">
				<div class="input-group mt-2">
					<span class="input-group-text">Nombre</span>
					<input class="form-control" type="text" name="nombre">
				</div>
				<div class="input-group mt-2">
					<span class="input-group-text">Descripción</span>
					<input class="form-control" type="text" name="descripcion">
				</div>
				<div class="input-group mt-2">
					<span class="input-group-text">Precio Unidad</span>
					<input class="form-control" type="number" step="0.01" name="precio">
				</div>
				<div class="input-group mt-2">
					<span class="input-group-text">Stock</span>
					<input class="form-control" type="number" name="stock">
				</div>
				<button type="submit" class="btn btn-primary mt-2">Alta</button>
			</form>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>