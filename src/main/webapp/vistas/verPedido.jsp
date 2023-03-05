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
	
	<h3>Busqueda de pedidos por Cliente</h3>
	
	<div class ="container mt-3">
		<form action ="/buscarUnPedido" method ="post">
			<label for = "busqueda">Introduce ID de Cliente</label>
			<input type ="text" name ="idUsuario">
			<input type ="submit" value="Buscar">
		</form>
		
		<table class="table table-striped table-sm mt-5" >
			<tr class="table-info">
				<th>ID Pedido</th>
				<th>ID Usuario</th>
				<th>Fecha de pedido</th>
				<th>Calle de entrega</th>
				<th>Localidad</th>
				<th>Codigo postal</th>
				<th>Estado del pedido</th>
				<th>PRODUCTOS</th>
			</tr>
			<tr>
				<td>${pedido.idPedido }</td>
				<td>${pedido.usuario.idUsuario }</td>
				<td>${pedido.fecha }</td>
				<td>${pedido.direccion.calle }</td>
				<td>${pedido.direccion.localidad }</td>
				<td>${pedido.direccion.codigoPostal }</td>
				<td>${pedido.estado }</td>
				<td><a href="/detallePedido/${pedido.idPedido}" class="btn btn-success btn-sm">Ver productos </a></td>
			</tr>
		</table>
		
		<h3>${mensaje }</h3>
		
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>