<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles Producto ${producto.idProducto}</title>
</head>
<body>
<h1>Detalles de ${producto.nombre}</h1>

<p>${producto.idProducto }</p>
<p>${producto.nombre }</p>
<p>${producto.descripcion }</p>
<p>${producto.precio }</p>
<p>${producto.stock }</p>

</body>
</html>