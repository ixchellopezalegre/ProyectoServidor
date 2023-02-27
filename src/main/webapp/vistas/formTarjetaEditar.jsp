<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Tarjeta</title>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<h1>Formulario para modificar la tarjeta con numero ${tarjeta.numeroTarjeta}</h1>
	<div class = "container w-25 p-3">
		<p>${sesion.nombre}, a�ade una tarjeta:</p>
			<form action="/tarjeta/editar/${tarjeta.idTarjeta}" method="post">
				<div class="input-group mb-2">
					<span class="input-group-text">Titular</span>
					<input type="text" class="form-control" name="titular" value="${tarjeta.titular}">
				</div>
				<div class="input-group mb-2">
					<span class="input-group-text">Numero de la tarjeta</span>
					<input type="text" class="form-control" name="numeroTarjeta" value="${tarjeta.numeroTarjeta}">
				</div>
				<div class="input-group mb-2">
					<span class="input-group-text">Fecha de caducidad</span>
					<input type="date" class="form-control" name="fechaCaducidad" value="${tarjeta.fechaCaducidad}">
				</div>
				<div class="input-group mb-2">
					<span class="input-group-text">CVV</span>
					<input type="text" class="form-control" name="ccv" value="${tarjeta.ccv}">
				</div>

				<p><input type="submit" class="btn btn-primary" value="Enviar"></p>

			</form>
	</div>
</body>
</html>