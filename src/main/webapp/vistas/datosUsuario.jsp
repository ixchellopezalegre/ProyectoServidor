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

    <div class="card">
        <div class="col">
            <div class="card-header">
                <h4>Datos Personales</h4>
            </div>
            <div class="card-body">
                <p>Nombre: ${sesion.nombre}</p>
                <p>Apellidos: ${sesion.apellidos}</p>
                <p>Correo: ${sesion.email}</p>
            </div>
        </div>
        <div class="col">
            <div class="card-header">
                <h4>Direcciones y tarjetas</h4>
            </div>
            <div class="card-body">
                <a href="/direccion/todas" class="btn btn-primary">Mis direcciones</a>
                <a href="/tarjeta/todas" class="btn btn-primary">Mis tarjetas</a>
            </div>
    </div>

</div>
</div>
<footer class="bg-primary-gradient">
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>