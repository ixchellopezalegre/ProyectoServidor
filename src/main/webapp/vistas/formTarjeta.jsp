<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Añadir Tarjeta Nueva</title>
	<script src="../Javascript/validacionTarjeta.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class = "container w-50 p-3">
	<h2 class ="text-primary">${sesion.nombre}, añade una tarjeta:</h2>
	<form id="formTarjeta" action="/tarjeta/nueva" method="post" >
		<div class="input-group mb-2">
			<label for="titular" class="input-group-text">Titular</label>
			<input id="titular" type="text" class="form-control" name="titular">
		</div>
		<span id="titularError" class="text-danger"></span>
		<div class="input-group mb-2">
			<label for="numeroTarjeta" class="input-group-text">Numero de la tarjeta</label>
			<input id="numeroTarjeta" type="text" class="form-control" name="numeroTarjeta">
		</div>
		<span id="numeroTarjetaError" class="text-danger"></span>
		<div class="input-group mb-2">
			<label for="fechaCaducidad" class="input-group-text">Fecha de caducidad</label>
			<input id="fechaCaducidad" type="date" class="form-control" pattern="yyyy-MM-dd" name="fechaCaducidad">
		</div>
		<span id="fechaCaducidadError" class="text-danger"></span>

		<div class="input-group mb-2">
			<label for="cvv" class="input-group-text">CVV</label>
			<input id="cvv" type="text" class="form-control" name="ccv">
		</div>
		<span id="cvvError" class="text-danger"></span>
		<button type="submit" class="btn btn-primary"> Añadir tarjeta</button>
	</form>
	<a href="/tarjeta/todas" class="btn btn-secondary">Volver</a>

</div>
<footer class="bg-primary-gradient">
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>