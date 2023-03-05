<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Silicon Solutions</title>
</head>
<body>

<jsp:include page="nav.jsp"></jsp:include>

<div class= "container w-50 p-3">
	<h3> Alta de un nuevo administrador.</h3>

	<form class ="mt-3" action ="/user/gestion" method="post" >
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
			<input type="date" pattern="yyyy-MM-dd" aria-label="FechaNacimiento" class="form-control" name ="fechaNacimiento">
		</div>
		<div class="mb-2">
			<label for="password" class="form-label">Contraseña</label>
			<input type="password" class="form-control" id="password" name ="password">
		</div>
		<div class="info">
			<p>Se generara un email  de administrador de forma automática con el formato <i>"nombre.apellido@edix.com"</i>.</p>
		</div>
		<button type="submit" class="btn btn-primary">Alta administrador</button>
	</form>
</div>

<h1>${mensaje }</h1>
<footer class="bg-primary-gradient">
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>