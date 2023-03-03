<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Todas tus direcciones</title>
</head>
<body>

<jsp:include page="nav.jsp"></jsp:include>
<div class ="container mt-2 text-center">

    <h3>Tu pedido está en camino</h3>
    <h4>Gracias por comprar en Silicon Solutions</h4>

    <img src="/images/compraRealizada.png" alt="Entrega" width="500" height="600">
</div>
<div class ="container mt-1 text-center">
    <h3>¿Quieres seguir comprando?</h3>
    <a href="/producto/todos" class ="btn btn-primary btn-sm mt-5">Ver productos</a>
    <a href="/" class ="btn btn-primary btn-sm mt-5">Volver a pagina principal</a>
</div>
<footer class ="mt-5">
</footer>
</body>
</html>