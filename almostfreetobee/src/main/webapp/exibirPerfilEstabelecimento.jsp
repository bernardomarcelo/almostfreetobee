		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page isELIgnored="false" %>
	<!DOCTYPE html>
	<html lang="pt">
	<head>
	    <meta charset="UTF-8">
	    <title>Perfil do Estabelecimento</title>
	</head>
	<body>
	
		<img class ="foto" src="${pageContext.request.contextPath}/foto?tipo=estabelecimento&id=${estabelecimento.id}" alt="Foto do Estabelecimento"/>
	    <h1>${estabelecimento.nome}</h1>
	    
	    <h2><strong>Endereço</strong></h2>
	    <p>
	        ${estabelecimento.endereco.logradouro}, 	
	        ${estabelecimento.endereco.bairro}, 
	        ${estabelecimento.endereco.cidade}, 
	        CEP: ${estabelecimento.endereco.cep}
	    </p>
	    
	    <h2><strong>Contato</strong></h2>
	    <p>Telefone: ${estabelecimento.telefone}</p>
	    <p>E-mail: ${estabelecimento.email}</p>
	    
	    <h2><strong>Tipo de estabelecimento</strong></h2>
	    <p>${estabelecimento.tipoEstabelecimento}</p>
	    
	    <c:if test="${not empty avaliacoes }">
	    <a href="${pageContext.request.contextPath}/avaliacao/novo?estabelecimentoId=${estabelecimento.id}">
	    Adicionar Avaliação
	</a>
	</c:if>
	<h2>Avaliações do Estabelecimento: </h2>
	<c:if test="${not empty avaliacoes}">
	    <ul>
	        <c:forEach var="avaliacao" items="${avaliacoes}">
	            <li>
	                <strong>Nota:</strong> ${avaliacao.nota} <br/>
	                <strong>Descrição:</strong> ${avaliacao.descricao} <br/> <br> <br>
	                
	            </li>
	        </c:forEach>
	    </ul>
	</c:if>
	<c:if test="${empty avaliacoes}">
	    <p>Este estabelecimento ainda não possui avaliações.</p>
	    
	    <a href="${pageContext.request.contextPath}/avaliacao/novo?estabelecimentoId=${estabelecimento.id}">
	    Seja o primeiro a cadastrar uma avaliação neste estabelecimento!
	</a>
	    
	</c:if>
	
	
	
	</body>
	</html>