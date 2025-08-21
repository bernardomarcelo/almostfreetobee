<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Avaliações</title>
</head>
<body>
		<h1>SUAS AVALIAÇÕES</h1>
		
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
    <p>Você ainda não possui nenhuma avaliação!</p>
    
    <a href="${pageContext.request.contextPath}/estabelecimento/pesquisar-estabelecimento">
    Veja estabelecimentos para cadastrar alguma!
</a>
    
</c:if>
		
		
</body>
</html>