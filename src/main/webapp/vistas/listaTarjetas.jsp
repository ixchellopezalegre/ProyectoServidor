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
	<h3>Listado de tarjetas de ${sesion.nombre}</h3><hr>
		<table class ="table table-striped table-hover">
		<a href="/tarjeta/nueva">Nueva Tarjeta</a>
			<tr class="table-info">
				<th>Titular</th>
				<th>Numero de la tarjeta</th>
				<th>Fecha de Caducidad</th>
				<th>CCV</th>
				<th>Opciones</th>
			</tr>
		<c:forEach var="ele" items="${ tarjetas }">
			<tr>
				<td>${ ele.titular }</td>
				<td>${ ele.numeroTarjeta }</td>
				<td>${ ele.fechaCaducidad }</td>
				<td>${ ele.ccv }</td>
				<td>
					<a href="/tarjeta/editar/${ele.idTarjeta}">Editar</a>
					<a href="/tarjeta/eliminar/${ele.idTarjeta}">Eliminar</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>