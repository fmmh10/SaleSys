<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.AddProductToSaleModel" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../../resources/app.css"> 
<title>SaleSys: adicionar produto à venda</title>
</head>
<body>
<h2>Adicionar produto à Venda</h2>
<form action="addProductToSale" method="post">
    <div class="mandatory_field">
		<label for="npc">Número de id da venda:</label> 
		<input type="text" name="saleId" value="${model.saleId}"/> <br/>
		<label for="npc">Código do produto:</label> 
		<input type="text" name="prodCode" value="${model.productCode}"/> <br/>
		<label for="npc">Quantidade:</label> 
		<input type="text" name="qty" value="${model.qty}"/> <br/>
		
    </div>
   <div class="button" align="right">
   		<input type="submit" value="Adicionar produto à venda">
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