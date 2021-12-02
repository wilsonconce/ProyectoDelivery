<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto Encontrada</title>
</head>
<body>
	<c:set var="pro" scope="request" value="${producto}" />
	<h1>Producto Encontrada</h1>		
		
	<p>Id: ${pro.id}</p>
	<p>Nombre: ${pro.nombre}</p>
	<p>Costo: ${pro.costo}</p>
	<p>Descripción: ${pro.descripcion}</p>
	<p>Establecimiento: ${pro.establecimiento.idEstablecimiento}</p>
	
	<a href="/ProyectoDelivery/index.html">Regresar al index</a>
	
</body>
</html>

