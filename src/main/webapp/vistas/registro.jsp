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
<sec:csrfInput/>
<div class = "container w-50 p-3">
	<h3 class ="mb-5"> ¡ Forma parte de Silicon Solutions !</h3>
	<form action ="/registro" method="post" >
		<input type=hidden name="${csrf.parameterName}? value="${csrf.token}"/>
		<div class="input-group mb-2">
			<span class="input-group-text">Nombre</span>
			<input type="text" aria-label="Nombre" class="form-control" name="nombre">
		</div>
		<div class="input-group mb-2">
			<span class="input-group-text">Primer apellido</span>
			<input type="text" aria-label="Primer apellido" class="form-control" name ="apellidos">
		</div>
		<div class="input-group mb-2">
			<span class="input-group-text">Fecha de nacimiento</span>
			<input type="date" class="form-control" pattern="yyyy-MM-dd" name="fechaNacimiento">
		</div>
		<div class="mb-1">
			<label for="email" class="form-label">Dirección de correo</label>
			<input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email">
			<div id="emailHelp" class="form-text">Nunca mostraremos tu email a nadie.</div>
		</div>
		<div class="mb-2">
			<label for="password" class="form-label">Contraseña</label>
			<input type="password" class="form-control" id="password" name ="password">
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" id="terminosCondiciones" checked>
			<label class="form-check-label" for="terminosCondiciones">Acepto términos y condiciones</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<h1>${mensaje }</h1>
<footer class="bg-primary-gradient">
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>