<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Silicon Solutions</title>
</head>
<body>

<jsp:include page="nav.jsp"></jsp:include>


<div class="container">
    <h1 class="text-primary">${sesion.nombre}, aquí están tus pedidos</h1>
    <hr>
    <table class ="table table-striped table-hover" >
        <tr class="table-info">
            <th>Fecha de pedido</th>
            <th>Calle de entrega</th>
            <th>Localidad</th>
            <th>Codigo postal</th>
            <th>Estado del pedido</th>
        </tr>
        <c:forEach var="pedido" items="${ listaPedidos }" >
            <tr>
                <td>${pedido.fecha }</td>
                <td>${pedido.direccion.calle }</td>
                <td>${pedido.direccion.localidad }</td>
                <td>${pedido.direccion.codigoPostal }</td>
                <td>${pedido.estado }</td>
            </tr>
            <tr>
                <td>
                    <c:forEach var="p" items="${pedido.productosEnPedidos}">
                        <p>${p.producto.nombre}</p>
                    </c:forEach>
                </td>

                </td>
            </tr>
        </c:forEach>
        <c:if test="${listaPedidos.size() == 0}">
            <tr>
                <td colspan="7">No hay pedidos para mostrar</td>
            </tr>
        </c:if>
    </table>
</div>
<footer class="bg-primary-gradient">
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>

