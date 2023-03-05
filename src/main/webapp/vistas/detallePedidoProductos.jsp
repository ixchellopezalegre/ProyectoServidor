<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form action="/carrito/pagar" method="POST">
        <div class ="container-fluid " style="max-width: 50%">
            <h2 class="text-primary mt-2">� A donde te lo mandamos ${user.nombre} ?</h2>
            <h4><label class="form-label mt-2">Direcci�n</label></h4>
                <select class="form-select mb-2" aria-label="Default select example" name="idDireccion">
                    <option selected>Selecciona tu calle</option>
                    <c:forEach items="${user.direcciones}" var="d">
                        <option value=${d.idDireccion}  >${d.calle}</option>
                    </c:forEach>
                </select>
                <select class="form-select mb-2" aria-label="Default select example" >
                    <option selected>Selecciona tu n�mero</option>
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
            <h4><label class="form-label mt-2">M�todo de pago</label></h4>
                <select class="form-select mb-2" aria-label="Default select example" name="idTarjeta">
                    <option selected>Titular</option>
                    <c:forEach items="${user.tarjetas}" var="t">
                        <option value=${t.idTarjeta}>${t.titular}</option>
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
                <input type ="submit" class ="btn btn-primary" value ="Pagar">
        </div>
    </form>
    <h2>${error}</h2>
</div>
<footer class="bg-primary-gradient">
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>