<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Motorizado Encontrada</title>
</head>
<body>
	<c:set var="mot" scope="request" value="${motorizado}" />
	<h1>Motorizado Encontrada</h1>		
		
	<p>Id: ${mot.idMotorizado}</p>
	<p>Nombre: ${mot.nombre}</p>
	<p>Apellido: ${mot.apellido}</p>
	<p>Edad: ${mot.edad}</p>
	<p>Horario: ${mot.telefono}</p>
	<p>Correo: ${mot.correo}</p>
	<p>Uusario: ${mot.usuario.idUsuario}</p>
	<p>Moto: ${mot.moto.idMoto}</p>
	
	<a href="/ProyectoDelivery/index.html">Regresar al index</a>
	
</body>
</html>

