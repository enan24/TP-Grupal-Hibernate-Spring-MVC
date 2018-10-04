<%@page import="org.hibernate.result.Output"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Taller Web 1 - Trabajo Practico</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body style="background-color:black">
<%-- 	<h2>${operacion}</h2> --%>
<%-- 	<h3>${cadena}</h3> --%>
	
	<c:choose>
		
		<c:when test="${operacion == 'pasaramayuscula'}">
			<div class="container mt-4 ">
				<div class="row justify-content-center">
					<div class="col-xs-12 col-md-6">
						<div class="alert alert-dismissible alert-success">
						  <button type="button" class="close" data-dismiss="alert">&times;</button>
						   <p>El resultado de la operacion: <strong>${operacion}</strong>, con la cadena: <strong>${cadena}</strong>, es: <strong>${fn:toUpperCase(cadena)}</strong><p>
						</div>
					</div>
				</div>
			</div>
	    </c:when>
	
	    <c:when test="${operacion == 'pasaraminuscula'}">
	    	<div class="container mt-4">
				<div class="row justify-content-center">
					<div class="col-xs-12 col-md-6">
						<div class="alert alert-dismissible alert-success">
						  <button type="button" class="close" data-dismiss="alert">&times;</button>
						   <p>El resultado de la operacion: <strong>${operacion}</strong>, con la cadena: <strong>${cadena}</strong>, es: <strong>${fn:toLowerCase(cadena)}</strong><p>
						</div>
					</div>
				</div>
			</div>
	    </c:when>
	    
	    <c:when test="${operacion == 'cantidadcaracteres'}">
	    	<div class="container mt-4">
				<div class="row justify-content-center">
					<div class="col-xs-12 col-md-6">
						<div class="alert alert-dismissible alert-success">
						  <button type="button" class="close" data-dismiss="alert">&times;</button>
						   <p>El resultado de la operacion: <strong>${operacion}</strong>, con la cadena: <strong>${cadena}</strong>, es: <strong>${fn:length(cadena)}</strong><p>
						</div>
					</div>
				</div>
			</div>
	    </c:when>
	    
	    <c:when test="${operacion == 'invertirorden'}">
	    	<div class="container mt-4">
				<div class="row justify-content-center">
					<div class="col-xs-12 col-md-6">
						<div class="alert alert-dismissible alert-success">
						  <button type="button" class="close" data-dismiss="alert">&times;</button>
						   <p>El resultado de la operacion: <strong>${operacion}</strong>, con la cadena: <strong>${cadena}</strong>, es: <strong>
							   	<c:forEach var="i" begin="0" end="${fn:length(cadena)}" step="1">
								   <c:out value="${fn:substring(cadena, fn:length(cadena) - i - 1 , fn:length(cadena) - i )}" />     
							  </c:forEach>
						   </strong><p>
						</div>
					</div>
				</div>
			</div>
	    </c:when>
	    	    
	    <c:otherwise>
	        <h3>Error! opcion incorrecta</h3>
	    </c:otherwise>
	</c:choose>
	
</body>
</html>