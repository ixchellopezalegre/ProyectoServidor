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
		<h1 class="text-primary">${pedidosDe}</h1>
		<hr>
		<div>
			<a href="/pedido/todos" class="btn btn-primary">Todos los pedidos</a>
			<a href="/pedido/completados" class="btn btn-primary">Pedidos completados</a>
			<a href="/pedido/pendientes" class="btn btn-primary">Pedidos pendientes</a>
			<a href="/pedido/hoy" class="btn btn-primary">Pedidos de hoy</a>
			<form action="/pedido/buscar" class="d-flex mt-3" role="search">
				<input name="idUsuario" class="form-control me-2" type="search" placeholder="Buscar pedidos de cliente (idCliente)" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Buscar</button>
			</form>
		</div>
		<hr>
		<table class ="table table-striped table-hover" >
			<tr class="table-info">
				<th>ID Pedido</th>
				<th>ID Usuario</th>
				<th>Fecha de pedido</th>
				<th>Calle de entrega</th>
				<th>Localidad</th>
				<th>Codigo postal</th>
				<th>Estado del pedido</th>
			</tr>
			<c:forEach var="pedido" items="${ listaPedidos }" >
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
			<c:if test="${listaPedidos.size() == 0}">
				<tr>
					<td colspan="7">No hay pedidos para mostrar</td>
				</tr>
			</c:if>
		</table>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	</body>
</html>
	
