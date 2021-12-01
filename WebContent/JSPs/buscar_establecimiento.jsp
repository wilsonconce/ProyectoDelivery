<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Establecimiento Encontrada</title>
</head>
<body>
	<c:set var="est" scope="request" value="${estab:lecimiento}" />
	<h1>Establecimiento Encontrada</h1>		
		
	<p>Id: ${est.idEstablecimiento}</p>
	<p>Nombre: ${est.nombre}</p>
	<p>Direccion: ${est.direccion}</p>
	<p>Telefono: ${est.telefono}</p>
	<p>Horario: ${est.horario}</p>
	
	<a href="/AppDelivery/index.html">Regresar al index</a>
	
</body>
</html>

