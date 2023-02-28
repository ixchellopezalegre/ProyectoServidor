<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Tarjeta Nueva</title>
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	
	<div class = "container w-25 p-3">
		<h2 class ="text-primary">${sesion.nombre}, añade una tarjeta:</h2>
			<form action="/tarjeta/nueva" method="post">
				<div class="input-group mb-2">
					<span class="input-group-text">Titular</span>
					<input type="text" class="form-control" name="titular">
				</div>
				<div class="input-group mb-2">
					<span class="input-group-text">Numero de la tarjeta</span>
					<input type="text" class="form-control" name="numeroTarjeta">
				</div>
				<div class="input-group mb-2">
					<span class="input-group-text">Fecha de caducidad</span>
					<input type="date" class="form-control" pattern="yyyy-MM-dd" name="fechaCaducidad">
				</div>
				<div class="input-group mb-2">
					<span class="input-group-text">CVV</span>
					<input type="text" class="form-control" name="ccv">
				</div>
				<p><input type="submit" class="btn btn-primary" value="Dar alta"></p>
			</form>
	</div>
</body>
</html>