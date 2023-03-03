<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Añadir Dirección Nueva</title>
	<script src="../Javascript/validacionDireccion.js"></script>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class = "container w-50 p-3">
		<h2 class ="text-primary">${sesion.nombre}, añade una dirección:</h2>
		<form id="formDireccion" action="/direccion/nueva" method="post">
			<div class="input-group mb-2">
				<label for="calle" class="input-group-text">Calle</label>
				<input id="calle" type="text" class="form-control" name="calle">
			</div>
			<span id="calleError" class="text-danger"></span>
			<div class="input-group mb-2">
				<label for="numero" class="input-group-text">Numero</label>
				<input id="numero" type="text" class="form-control" name="numero">
			</div>
			<span id="numeroError" class="text-danger"></span>
			<div class="input-group mb-2">
				<label for="piso" class="input-group-text">Piso</label>
				<input id="piso" type="text" class="form-control" name="piso">
			</div>
			<div class="input-group mb-2">
				<label for="puerta" class="input-group-text">Puerta</label>
				<input id="puerta" type="text" class="form-control" name="puerta">
			</div>
			<div class="input-group mb-2">
				<label for="localidad" class="input-group-text">Localidad</label>
				<input id="localidad" type="text" class="form-control" name="localidad">
			</div>
			<span id="localidadError" class="text-danger"></span>
			<div class="input-group mb-2">
				<label for="codigoPostal" class="input-group-text">Codigo postal</label>
				<input id="codigoPostal" type="text" class="form-control" name="codigoPostal">
			</div>
			<span id="codigoPostalError" class="text-danger"></span>

			<p><button type="submit" class="btn btn-primary">Añadir Dirección</button></p>

		</form>
		<a href="/direccion/todas" class="btn btn-secondary">Volver</a>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>