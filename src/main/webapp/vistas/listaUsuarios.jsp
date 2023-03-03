<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="nav.jsp"></jsp:include>
	
	<div class ="container mt-5 " >
	<h3 class ="text-primary">Listado de usuarios registrados</h3><hr>
		<table class ="table table-striped table-hover">
			<tr class="table-info">
				<th>ID</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Email</th>
				<th>Provincia</th>
				<th>Calle</th>
				<th>CP</th>
				<th>Opciones</th>
			</tr>
		<c:forEach var="user" items="${ usuario }">
			<tr>
				<td>${ user.idUsuario }</td>
				<td>${ user.nombre }</td>
				<td>${ user.apellidos }</td>
				<td>${ user.email }</td>
				<td>${ user.direcciones[0].getLocalidad() }</td>
				<td>${ user.direcciones[0].getCalle() }</td>
				<td>${ user.direcciones[0].getCodigoPostal() }</td>
				
				
				<td><a href="/pedido/${user.idUsuario}" class="btn btn-info m-1">Pedidos</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>