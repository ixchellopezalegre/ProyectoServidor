<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Todos nuestros productos</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
    <body>
    <jsp:include page="nav.jsp"></jsp:include>
        <div class="container">
            <h1 class="text-primary">Detalles de ${producto.nombre}</h1>
            <table class="table table-striped table-sm" >
                <sec:authorize access="hasAnyAuthority('ROL_ADMIN')"><th>ID</th></sec:authorize>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Precio</th>
                <sec:authorize access="hasAnyAuthority('ROL_ADMIN')"><th>Stock</th></sec:authorize>
            <tr>
                <sec:authorize access="hasAnyAuthority('ROL_ADMIN')"><td>${producto.idProducto }</td>
                </sec:authorize>
                <td>${producto.nombre }</td>
                <td>${producto.descripcion }</td>
                <td>${producto.precio }</td>
                <sec:authorize access="hasAnyAuthority('ROL_ADMIN')"><td><td>${producto.stock }</td>
                </sec:authorize>
            </tr>
            </table>
        </div>
    </body>
</html>