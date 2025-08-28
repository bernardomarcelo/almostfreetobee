	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page isELIgnored="false" %>
	
	
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Estabelecimentos</title>
	
	
	<style>
.foto {
    width: 100px;
    height: 100px;
    object-fit: cover;
    border-radius: 8px;
}
</style>
	
	</head>
	<body>
	
	<h1>Estabelecimentos cadastrados:</h1>
	
	<ul>
	    <c:forEach var="estabelecimento" items="${estabelecimentos}">
	        <li>
	        	<img class ="foto" src="${pageContext.request.contextPath}/foto?tipo=estabelecimento&id=${estabelecimento.id}" alt="Foto do Estabelecimento"/> <br>
	            Tipo de estabelecimento ${estabelecimento.tipoEstabelecimento} <br />
	           	Logradouro: ${estabelecimento.endereco.logradouro} <br /><br />
	        	Bairro: ${estabelecimento.endereco.bairro} <br /><br />
	        	Cidade: ${estabelecimento.endereco.cidade} <br /><br /> 
	        	CEP: ${estabelecimento.endereco.cep} <br /><br />
	        	Telefone: ${estabelecimento.telefone}  <br /><br />
	        	E-mail: ${estabelecimento.email}  <br /><br />
	        </li>
	    </c:forEach>
	</ul>
	
	</body>
	</html>
