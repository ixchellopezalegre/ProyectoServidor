<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
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

    <div class ="container-fluid " style="max-width: 50%">
        <h2 class="text-primary mt-2">¿ A donde te lo mandamos ${user.nombre} ?</h2>
        <h4><label class="form-label mt-2">Dirección</label></h4>
                <select class="form-select mb-2" aria-label="Default select example">
                    <option selected>Selecciona tu calle</option>
                    <c:forEach items="${user.direcciones}" var="d">
                        <option value="0">${d.calle}</option>
                    </c:forEach>
                </select>
                <select class="form-select mb-2" aria-label="Default select example" >
                    <option selected>Selecciona tu número</option>
                    <c:forEach items="${user.direcciones}" var="d">
                        <option value="0">${d.numero}</option>
                    </c:forEach>
                </select>
                <select class="form-select mb-2" aria-label="Default select example" >
                    <option selected>Selecciona localidad</option>
                    <c:forEach items="${user.direcciones}" var="d">
                        <option value="0">${d.localidad}</option>
                    </c:forEach>
                </select>
        <h4><label class="form-label mt-2">Método de pago</label></h4>
                <select class="form-select mb-2" aria-label="Default select example">
                    <option selected>Titular</option>
                    <c:forEach items="${user.tarjetas}" var="t">
                        <option value="0">${t.titular}</option>
                    </c:forEach>
                </select>
                <select class="form-select mb-2" aria-label="Default select example" >
                    <option selected>Numero de tarjeta</option>
                    <c:forEach items="${user.tarjetas}" var="t">
                        <option value="0">${t.numeroTarjeta}</option>
                    </c:forEach>
                </select>
                <select class="form-select mb-2" aria-label="Default select example" >
                    <option selected>CCV</option>
                    <c:forEach items="${user.tarjetas}" var="t">
                        <option value="0">${t.ccv}</option>
                    </c:forEach>
                </select>

                <a href="/carrito/pagar" class ="btn btn-primary">Pagar</a>
    </div>
</div>
</body>
</html>