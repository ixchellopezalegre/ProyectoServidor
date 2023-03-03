<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todas tus direcciones</title>
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>

	<div class ="container mt-5 " >

	<p>${mensaje}</p>
	
	<h3 class="text-primary">Listado de direcciones de ${sesion.nombre}</h3><hr>
		<table class ="table table-striped table-hover">
		<a href="/direccion/nueva" class ="btn btn-success btn-sm mb-2">Nueva Dirección</a>
			<tr class="table-info">
				<th>Calle</th>
				<th>Numero</th>
				<th>Piso</th>
				<th>Puerta</th>
				<th>CP</th>
				<th>Localidad</th>
				<th>Opciones</th>
			</tr>
		<c:forEach var="ele" items="${ direcciones }">
			<tr>
				<td>${ ele.calle }</td>
				<td>${ ele.numero }</td>
				<td>${ ele.piso }</td>
				<td>${ ele.puerta }</td>
				<td>${ ele.codigoPostal }</td>
				<td>${ ele.localidad }</td>
				<td>
					<a href="/direccion/editar/${ele.idDireccion}" class ="btn btn-info btn-sm mb-2">Editar</a>
					<a href="/direccion/eliminar/${ele.idDireccion}" class ="btn btn-danger btn-sm mb-2">Eliminar</a></td>
			</tr>
		</c:forEach>
		</table>

		<a href="/user/datos" class="btn btn-secondary">Volver</a>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>