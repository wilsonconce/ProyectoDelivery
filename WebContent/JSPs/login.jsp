<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div align="center">
		<section class="vh-100 gradient-custom"
			style="background-color: #94bbe9;">
			<h1>Bienvenido</h1>

			<form action="<%=request.getContextPath()%>/LoginServlet"
				method="post">
				<table style="with: 100%">
					<tr>
						<td><h4>Usuario</h4></td>
						<td><input class="form-control m-2" type="text"
							name="username" /></td>
					</tr>
					<tr>
						<td><h4>Contraseña</h4></td>
						<td><input class="form-control m-2" type="password"
							name="password" /></td>
					</tr>

				</table>
				<input class="m-3 btn btn-lg btn-primary" type="submit"
					value="Ingresar" /> <input class="m-3 btn btn-lg btn-primary"
					type="submit" value="Cancelar" />
			</form>
		</section>

	</div>
</body>
</html>