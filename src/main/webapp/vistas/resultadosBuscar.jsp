<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>B?squeda</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	
	<div class="container">
	<h1 class="text-primary">Resultado de la b?squeda</h1>
	<sec:authorize access="hasAnyAuthority('ROL_ADMIN')">
	<a href="/producto/alta" class="btn btn-primary btn-sm mt-2" >Nuevo Producto</a></td>
	</sec:authorize>
	<table class="table table-striped table-sm mt-2" >
	<sec:authorize access="hasAnyAuthority('ROL_ADMIN')">
	<th>Id</th>
	</sec:authorize>
	<th>Nombre</th><th>Descripcion</th><th>Opcion<sec:authorize access="hasAuthority('ROL_ADMIN')">es</sec:authorize></th>
	
	<c:forEach var="ele" items="${resultados }" >
		<tr>
			<sec:authorize access="hasAnyAuthority('ROL_ADMIN')">
			<td>${ele.idProducto }</td>
			</sec:authorize>
			<td>${ele.nombre }</td>
			<td>${ele.descripcion }</td>
			<td><a href="/producto/verUno/${ele.idProducto}" class="btn btn-success btn-sm">Ver detalle</a>
			 <sec:authorize access="hasAnyAuthority('ROL_ADMIN')">
			<a href="/producto/editar/${ele.idProducto}" class="btn btn-success btn-sm">Modificar</a>
			 <a href="/producto/eliminar/${ele.idProducto}" class="btn btn-danger btn-sm">Eliminar</a></td>
			  </sec:authorize>
		</tr>
	</c:forEach>
	</table>
	</div>
	<footer class="bg-primary-gradient">
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</html>