<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Silicon Solutions</title>
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	
	
	<div class="container">
		<h1 class="text-primary">Estado de pedidos</h1><hr>
		<table class="table table-striped table-sm" >
			<tr class="table-info">
				<th>ID Pedido</th>
				<th>ID Usuario</th>
				<th>Fecha de pedido</th>
				<th>Calle de entrega</th>
				<th>Localidad</th>
				<th>Codigo postal</th>
				<th>Estado del pedido</th>
			</tr>
			<c:forEach var="pedido" items="${ listaPedido }" >
			<tr>
				<td>${pedido.idPedido }</td>
				<td>${pedido.usuario.idUsuario }</td>
				<td>${pedido.fecha }</td>
				<td>${pedido.direccion.calle }</td>
				<td>${pedido.direccion.localidad }</td>
				<td>${pedido.direccion.codigoPostal }</td>
				<td>${pedido.estado }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>
	
