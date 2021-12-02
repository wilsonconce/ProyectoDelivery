<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categoria Encontrada</title>
</head>
<body>
	<c:set var="cat" scope="request" value="${categoria}" />
	<h1>Categoria Encontrada</h1>		
		
	<p>Id: ${cat.idCategoria}</p>
	<p>Nombre: ${cat.nombre}</p>
	<p>Descripción: ${cat.descripcion}</p>
	
	<a href="/AppDelivery/index.html">Regresar al index</a>
	
</body>
</html>

