<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ page import="com.edix.proyecto.beans.Producto" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito de la compra</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

	<jsp:include page="nav.jsp"></jsp:include>
	
	<div class="container">
	<h1 class="text-primary">Productos del carrito</h1>
	
    <table class="table table-striped table-sm">
      <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Descripción</th>
        <th>Cantidad</th>
        <th>Modificar Unidades</th>
      </tr>
      <c:if test="${not empty carrito}">
        <c:forEach items="${carrito}" var="entry">
          <tr>
            <td>${entry.key.idProducto}</td>
            <td>${entry.key.nombre}</td>
            <td>${entry.key.descripcion}</td>
            <td>${entry.value}</td>
            <td>
            	<a href="/carrito/añadirUno/${entry.key.idProducto}" class="btn btn-primary btn-sm">Añadir</a>
            	<a href="/carrito/eliminarUno/${entry.key.idProducto}" class="btn btn-danger btn-sm">Restar</a>
            </td>
          </tr>
        </c:forEach>
      </c:if>
      <c:if test="${empty carrito}">
        <tr>
          <td colspan="2">El carrito está vacío</td>
        </tr>
      </c:if>
    </table>
	
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
</body>
</html>