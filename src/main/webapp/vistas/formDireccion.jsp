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

	<jsp:include page="nav.jsp"></jsp:include>

	<h1>Formulario de Alta de Direccion</h1>
	<div class = "container w-25 p-3">
		<h3>${sesion.nombre}, añade una dirección:</h3>
		<form action="/direccion/nueva" method="post">
			<div class="input-group mb-2">
				<span class="input-group-text">Calle</span>
				<input type="text" name="calle">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Numero</span>
				<input type="text" name="numero">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Piso</span>
				<input type="text" name="piso">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Puerta</span>
				<input type="text" name="puerta">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Localidad</span>
				<input type="text" name="localidad">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Codigo postal</span>
				<input type="text" name="codigoPostal">
			</div>

			<p><input type="submit" class="btn btn-primary" value="Enviar"></p>

		</form>
	</div>
</body>
</html>