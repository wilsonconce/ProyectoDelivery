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
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

<link href="../resources/css/signin.css" rel="stylesheet">
</head>

<body class="text-center">
	
	<main class="form-signin">
		<form action="<%=request.getContextPath()%>/LoginServlet"
			method="post">

			<img class="mb-2" src="../resources/img/people.svg" alt=""
				width="122" height="107">
			<h1 class="h3 mb-3 fw-normal">Iniciar Sesion</h1>

			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput"
					name="username" placeholder="name@example.com"> <label
					for="floatingInput">Usuario</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					name="password" placeholder="Password"> <label
					for="floatingPassword">Contraseña</label>
			</div>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Recordar
				</label>
			</div>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Sign
				in</button>
	</main>
	</form>
</body>
</html>