<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Comprar tu pedido</title>
</head>
<body>

<jsp:include page="nav.jsp"></jsp:include>

<div class ="container mt-5 " >
    <h3 class ="text-primary">Factura</h3>
    <hr>
    <table class ="table table-striped table-sm">
        <tr>
            <th>Producto</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Subtotal</th>
        </tr>
            <c:forEach items="${carrito}" var="c">
                <c:set var="subtotal" value="${c.key.precio * c.value}"/>
                <tr>
                    <td>${c.key.descripcion}</td>
                    <td>${c.key.precio}</td>
                    <td>${c.value}</td>
                    <td>${subtotal}</td>
                </tr>
                <c:set var="total" value="${total + subtotal}"/>
            </c:forEach>
            <tr>
                <td colspan ="4" style="text-align: right"><strong>TOTAL: ${total}</strong></td>
            </tr>
    </table>
    <form action="/carrito/pagar" method="post">
        <div class ="container-fluid " style="max-width: 60%">
            <h2 class="text-primary mt-2">¿ A donde te lo mandamos ${user.nombre} ?</h2>
            <h4><label class="form-label mt-2">Dirección</label></h4>
                    <select class="form-select mb-2" aria-label="Default select example">
                        <option selected>Dirección</option>
                        <c:forEach items="${user.direcciones}" var="d">
                            <option value="${d.idDireccion}">${d.calle} ${d.numero} ${d.piso} ${d.puerta} ${d.localidad}</option>
                            <input type="hidden" name="idDireccion" value="${d.idDireccion}">
                        </c:forEach>
                    </select>
            <a href="/direccion/nueva" class ="btn btn-secondary">Añadir dirección nueva</a>
            <h4><label class="form-label mt-2">Método de pago</label></h4>
                    <select class="form-select mb-2" aria-label="Default select example">
                        <option selected>Tarjetas</option>
                        <c:forEach items="${user.tarjetas}" var="t">
                            <option value="${t.idTarjeta}">Número ${t.numeroTarjeta} Titular ${t.titular}</option>
                            <input type="hidden" name="idTarjeta" value="${t.idTarjeta}">
                        </c:forEach>
                    </select>
            <a href="/tarjeta/nueva" class ="btn btn-secondary">Añadir tarjeta nueva</a>
            <br><hr>
            <button type="submit" class ="btn btn-primary">Pagar</button>
        </div>
    </form>
</div>
    <footer class="bg-primary-gradient">
        <jsp:include page="footer.jsp"></jsp:include>
    </footer>
</body>
</html>