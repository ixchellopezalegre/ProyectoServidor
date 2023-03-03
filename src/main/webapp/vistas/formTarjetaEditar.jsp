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
	
	<div class = "container w-25 p-3">
		<h3 class ="text-primary mb-3">Modificación de la tarjeta de ${tarjeta.titular}</h3>
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

				<p><input type="submit" class="btn btn-primary" value="Actualizar"></p>
			</form>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>