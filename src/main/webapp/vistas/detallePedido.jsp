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
	<div class ="container">
		<table class="table table-striped table-sm mt-5" >
			<tr class="table-info">
				<th>Número de orden</th>
				<th>ID de pedido</th>
				<th>ID producto</th>
				<th>ID de usuario</th>
				<th>Nombre de usuario</th>
				<th>Producto</th>
				<th>Cantidad</th>
				<th>Precio</th>
			</tr>
			<tr>
				<td>${p.numeroOrden }</td>
				<td>${p.pedido.idPedido }</td>
				<td>${p.producto.idProducto }</td>
				<td>${p.pedido.usuario.idUsuario }</td>
				<td>${p.pedido.usuario.nombre }</td>
				<td>${p.producto.nombre }</td>
				<td>${p.cantidad }</td>
				<td>${p.precioTotal }</td>
			</tr>
			
		</table>
		<a href="/pedido" class="btn btn-success btn-sm mt-3">Ver todos los pedidos </a>
	</div>
		
	

</body>
</html>