<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Estabelecimentos</title>
</head>
<body>
		<h1>SEUS ESTABELECIMENTOS CADASTRADOS:</h1>
		
		<c:if test="${not empty estabelecimentos}">
    <ul>
        <c:forEach var="estabelecimento" items="${estabelecimentos}">
            <li>
                <div>
						<h1>
						 <a href="/almostfreetobee/estabelecimento/exibir-perfil?id=${estabelecimento.id}">
                        <c:out value="${estabelecimento.nome}"/>
                    </a>
						
						</h1>			
						<h4><c:out value="${estabelecimento.email}"/></h4>
						<h4><c:out value="${estabelecimento.telefone}"/></h4>
					</div>
                
            </li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${empty estabelecimentos}">
    <p>Você ainda não possui nenhum estabelecimento cadastrado!</p>
    
    <a href="${pageContext.request.contextPath}/estabelecimento/novo">
    Cadastre algum!
</a>
    
</c:if>
		
		
</body>
</html>