<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de usuario</title>
</head>
<body>
	
	<jsp:include page="nav.jsp"></jsp:include>
	
	<div class = "container w-25 p-3">
	<h3> ¡ Forma parte de Silicon Solutions !</h3>
		<form class ="mt-4">
			<div class="input-group mb-2">
			  <span class="input-group-text">Nombre</span>
			  <input type="text" aria-label="Nombre" class="form-control">
			</div>
			<div class="input-group mb-2">
			  <span class="input-group-text">Primer apellido</span>
			  <input type="text" aria-label="Primer apellido" class="form-control">
			</div>
			<div class="input-group mb-2">
			  <span class="input-group-text">Fecha de nacimiento</span>
			  <input type="date" aria-label="FechaNacimiento" class="form-control">
			</div>
			<div class="mb-1">
		    	<label for="email" class="form-label">Dirección de correo</label>
		    	<input type="email" class="form-control" id="email" aria-describedby="emailHelp">
		   		<div id="emailHelp" class="form-text">Nunca mostraremos tu email a nadie.</div>
		  	</div>
		  	<div class="mb-2">
		    	<label for="password" class="form-label">Contraseña</label>
		    	<input type="password" class="form-control" id="password">
		  </div>
		  <div class="mb-3 form-check">
		  	<input type="checkbox" class="form-check-input" id="terminosCondiciones" checked>
		    <label class="form-check-label" for="exampleCheck1">Acepto términos y condiciones</label>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	
</body>
</html>