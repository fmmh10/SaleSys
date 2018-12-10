<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.UpdateEmployeeComissionModel" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../resources/app.css"> 
<title>SaleSys: Atualizar total de comissão do vendedor</title>
</head>
<body>
<h2>Atualizar total de comissão do vendedor</h2>
<form action="updateEmployeeComission" method="post">
    <div class="mandatory_field">
		<label for="npc">VatNumber do vendedor:</label> 
		<input type="text" name="vatNumber" value="${model.vatNumber}"/> <br/>
		<label for="npc">Valor da comissão:</label> 
		<input type="text" name="comission" value="${model.comission}"/> <br/>		
    </div>
   <div class="button" align="right">
   		<input type="submit" value="Atualizar total de comissão do vendedor ">
   </div>
</form>
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