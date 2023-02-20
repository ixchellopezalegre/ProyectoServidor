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
	<h3>Listado de direcciones de ${sesion.nombre}</h3><hr>
		<table class ="table table-striped table-hover">
		<a href="/direccion/nueva">Nueva Direcci�n</a>
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
					<a href="/direccion/editar/${ele.idDireccion}">Editar</a>
					<a href="/direccion/eliminar/${ele.idDireccion}">Eliminar</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>