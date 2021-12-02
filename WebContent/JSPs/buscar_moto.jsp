<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Moto Encontrada</title>
</head>
<body>
	<c:set var="m" scope="request" value="${moto}" />
	<h1>Establecimiento Encontrada</h1>		
		
	<p>Id: ${m.idMoto}</p>
	<p>Placa: ${m.placa}</p>
	<p>Modelo: ${m.modelo}</p>
	<p>Marca: ${m.marca}</p>
	<p>Color: ${m.color}</p>
	
	<a href="/AppDelivery/index.html">Regresar al index</a>
	
</body>
</html>

