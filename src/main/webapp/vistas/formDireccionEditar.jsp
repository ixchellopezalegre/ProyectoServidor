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

	<h1>Formulario para modificar la direccion localizada en ${direccion.calle}</h1>
	<div class = "container w-25 p-3">
		<h3>${sesion.nombre}, añade una dirección:</h3>

		<form action="/direccion/editar/${direccion.idDireccion}" method="post">
			<div class="input-group mb-2">
				<span class="input-group-text">Calle</span>
				<input type="text" name="calle" value="${direccion.calle}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Numero</span>
				<input type="text" name="numero" value="${direccion.numero}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Piso</span>
				<input type="text" name="piso" value="${direccion.piso}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Puerta</span>
				<input type="text" name="puerta" value="${direccion.puerta}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Localidad</span>
				<input type="text" name="localidad" value="${direccion.localidad}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">Codigo postal</span>
				<input type="text" name="codigoPostal" value="${direccion.codigoPostal}">
			</div>

			<p><input type="submit" class="btn btn-primary" value="Enviar"></p>

		</form>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>