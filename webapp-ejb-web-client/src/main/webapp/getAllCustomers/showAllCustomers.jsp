<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.AllCustomersModel" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../resources/app.css"> 
<title>SaleSys: mostrar todos os clientes</title>
</head>
<body>
<h2>Mostrar Clientes</h2>

Número de Clientes: <c:out value = "${model.customers.size()}"></c:out>

<br><br><br>
<table id="clients" class="clientList">
    <tr>
		<th>Nome Cliente</th>
		<th>Telefone</th>
		<th>NIF</th>
	</tr>
	<c:forEach var="customer" items="${model.customers}">
		<tr>
			<td               >${customer.designation}</td>
			<td align="center">${customer.phoneNumber}</td>
			<td align="center">${customer.VATNumber  }</td>
		</tr>
		
	</c:forEach>
</table>


<c:if test="${model.hasMessages}">
	<p>Mensagens</p>
	<ul>
	<c:forEach var="mensagem" items="${model.messages}">
		<li>${mensagem} 
	</c:forEach>
	</ul>
</c:if>
</body>
</html>