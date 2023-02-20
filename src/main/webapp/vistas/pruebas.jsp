<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Direcciones</h1>
	<h1>Direcciones de ${usuario.nombre }</h1>
	<c:forEach items="${direcciones}" var="direccion">
		<p>Calle: ${direccion.calle }</p>
		<p>Numero: ${direccion.numero }</p>
		<p>Piso: ${direccion.piso }</p>
		<p>Puerta: ${direccion.puerta }</p>
		<p>Localidad:${direccion.localidad }</p>
		<p>Código Postal: ${direccion.codigoPostal }</p>
	</c:forEach>
</body>
</html>
