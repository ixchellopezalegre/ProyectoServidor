<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle del pedido</title>
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	
	
	<div class ="container">
	<h1 class="text-primary">Detalle del pedido ${pedido.idPedido}</h1>
	
	<br>
	
		<!--  Tabla de Productos del Pedido -->
		<table class ="table table-striped table-hover" >
			<tr class="table-info">
				<th>ID Pedido</th>
				<th>ID Usuario</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Fecha de pedido</th>
				<th>Calle de entrega</th>
				<th>Localidad</th>
				<th>Codigo postal</th>
			</tr>
			<tr>
				<td>${pedido.idPedido }</td>
				<td>${pedido.usuario.idUsuario }</td>
				<td>${pedido.usuario.nombre }</td>
				<td>${pedido.usuario.apellidos }</td>
				<td>${pedido.fecha }</td>
				<td>${pedido.direccion.calle }</td>
				<td>${pedido.direccion.localidad }</td>
				<td>${pedido.direccion.codigoPostal }</td>
			</tr>
		</table>
		
		<!--  Tabla de Productos del Pedido -->
		<h2>Productos</h2>
		<table class ="table table-striped table-sm">
	        <tr>
	        	<th>id Producto</th>
	            <th>Producto</th>
	            <th>Precio</th>
	            <th>Cantidad</th>
	            <th>Subtotal</th>
	        </tr>
	            <c:forEach items="${listaProductos}" var="p">
	                <c:set var="subtotal" value="${p.precioTotal}"/>
	                <tr>
	                	<td>${p.producto.idProducto}</td>
	                    <td>${p.producto.descripcion}</td>
	                    <td>${p.producto.precio}</td>
	                    <td>${p.cantidad}</td>
	                    <td>${p.precioTotal}</td>
	                </tr>
	                <c:set var="total" value="${total + subtotal}"/>
	            </c:forEach>
	            <tr>
	                <td colspan ="5" style="text-align: right"><strong>TOTAL: ${total}</strong></td>
	            </tr>
	    </table>
	</div>


	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>