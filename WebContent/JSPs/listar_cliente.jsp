<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Establecimiento Encontrada</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<c:set var="lista" scope="request" value="${establecimiento}" />
	<h1>Lista de Establecimiento</h1>

<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td><strong>Id</strong></td> -->
<!-- 			<td><strong>Nombre</strong></td> -->
<!-- 			<td><strong>Direccion</strong></td> -->
<!-- 			<td><strong>Telefono</strong></td> -->
<!-- 			<td><strong>Horario</strong></td> -->
<!-- 		</tr> -->
<%-- 		<c:forEach var="est" items="${lista}"> --%>
<!-- 			<tr> -->
<%-- 			    <td>${est.idEstablecimiento}</td> --%>
<%-- 				<td>${est.nombre}</td> --%>
<%-- 				<td>${est.direccion}</td> --%>
<%-- 				<td>${est.telefono}</td> --%>
<%-- 				<td>${est.horario}</td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->
	
	<table class="table table-responsive table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Direccion</th>
            <th>Telefono</th>
            <th>Horario</th>
        </tr>
        
    </thead>
    <tbody>
        	<c:forEach var="est" items="${lista}">
			<tr>
			    <td>${est.idEstablecimiento}</td>
				<td>${est.nombre}</td>
				<td>${est.direccion}</td>
				<td>${est.telefono}</td>
				<td>${est.horario}</td>
			</tr>
		</c:forEach>
    </tbody>
</table>
	
	<a href="/ProyectoDelivery/index.html">Regresar al index</a>

</body>
</html>

