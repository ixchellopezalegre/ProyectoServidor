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

<div class ="container mt-5 " >

    <p>${mensaje}</p>
    <h3>Datos de ${sesion.nombre}</h3><hr>
    <h4><a href="/direccion/todas">Mis direcciones</a></h4>
</div>
</body>
</html>