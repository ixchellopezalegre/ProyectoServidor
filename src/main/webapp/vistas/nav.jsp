<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg mb-3" style="background-color: #e3f2fd;">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="/"><img src="${pageContext.request.contextPath}/images/Siliconsolutions.png" alt="logo" height="80"/></a>
  			 <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    		  <span class="navbar-toggler-icon"></span>
    		</button>
   			 <div class="collapse navbar-collapse" id="navbarSupportedContent">
     			 <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       				 <li class="nav-item">
         				 <a class="nav-link active" aria-current="page" href="/">Inicio</a>
       				 </li>
      				 <li class="nav-item">
      				    <a class="nav-link" href="/producto/todos">Productos</a>
        			</li>
        			
        			<!-- Solo mostramos estas secciones si tienes rol de Administrador -->
        			<sec:authorize access="hasAuthority('ROL_ADMIN')">
        			<li class="nav-item">
      				    <a class="nav-link" href="/user/todos">Usuarios</a>
        			</li>
					<li class="nav-item">
						<a class="nav-link" href="/pedido/todos">Pedidos</a>
					</li>
        			<li class=>
      				    <a class="nav-link" href="/user/gestion">Gestión</a>
        			</li>
        			</sec:authorize>
        			
        			<!-- Si ha iniciado sesión, mostraremos los datos personales del usuario, sus pedidos, carrito y la posibilidad de cerrar sesión -->
        			<sec:authorize access ="isAuthenticated()">
      			  	<li class="nav-item dropdown">
         				<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Mi perfil</a>
          				
          				<ul class="dropdown-menu">
          			
          					<li><a class="dropdown-item" href="/user/datos">Mis datos</a></li>
            				<sec:authorize access="hasAuthority('ROL_CLIENTE')">
            				<li><a class="dropdown-item" href="#">Mis pedidos</a></li>
            				
            				</sec:authorize>
            				<li><hr class="dropdown-divider"></li>
            				<li><a class="dropdown-item" href="/user/logout">Cerrar sesión</a></li>
          				</ul>
        			</li>
        			<li class="nav-item">
      				    <a class="nav-link" href="/carrito"><img src="${pageContext.request.contextPath}/images/carritoCompra.png" alt="img_carrito" height="30"/></a>
        			</li>
        			</sec:authorize>
      			</ul>
      	<form action="/producto/buscar" class="d-flex" role="search">
        	<input name="busqueda" class="form-control me-2" type="search" placeholder="Buscar producto" aria-label="Search">
        	<button class="btn btn-outline-success" type="submit">Buscar</button>
      	</form>
      	<div>
	      	<ul class="navbar-nav me-right mb-2 mb-lg-0">
	      	
	      	<!-- Si no ha iniciado sesión todavía, mostramos la opcion de registro de usuario -->
	      	<sec:authorize access ="!isAuthenticated()">
	      		<li class="nav-item">
	      			<a class="btn btn-primary m-2" href="/registro" role="button">Registrate</a>
	        	</li>
	        	<li class="nav-item">
	      			<a class="btn btn-info m-2" href="/login" role="button">Iniciar sesión</a>
	        	</li>
	        </sec:authorize>
	    	</ul>
    	</div>
    	</div>
  		</div>
	</nav>
	<sec:authorize access="!isAuthenticated()">
		<h4>Bienvenido a Silicon Solutions. No está registrado</h4>
	</sec:authorize>
	
	<!-- Nos dice quien ha entrado a la página -->
	<sec:authorize access="isAuthenticated()">
		<h4>Usuario ${sesion.nombre}. Rol: <sec:authorize access="hasAuthority('ROL_ADMIN')">Administrador</sec:authorize>
	<sec:authorize access="hasAuthority('ROL_CLIENTE')">CLIENTE</sec:authorize>
</h4>
</sec:authorize>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html> 