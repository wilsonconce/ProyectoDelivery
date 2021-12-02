<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente Encontrada</title>
</head>
<body>
	<c:set var="cli" scope="request" value="${cliente}" />
	<h1>Cliente Encontrada</h1>		
		
	<p>Id: ${cli.idCliente}</p>
	<p>Nombre: ${cli.nombre}</p>
	<p>Apellido: ${cli.apellido}</p>
	<p>Cedula: ${cli.cedula}</p>
	<p>Edad: ${cli.edad}</p>
	<p>Telefono: ${cli.telefono}</p>
	<p>Correo: ${cli.correo}</p>
	<p>Dirección: ${cli.direccion}</p>
	<p>Usuario: ${cli.usuario}</p>
	
	<a href="/ProyectoDelivery/index.html">Regresar al index</a>
	
</body>
</html>

