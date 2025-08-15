<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de depoimentos</title>
</head>
<body>

<h1>Lista de Depoimentos</h1>

<ul>
    <c:forEach var="depoimento" items="${depoimentos}">
        <li>
            Usuário: ${depoimento.usuario.id} <br />
            Avaliação: ${depoimento.avaliacao.id} <br />
            Conteúdo: ${depoimento.conteudoDepoimento} <br />
            Data: ${depoimento.dataDepoimento} <br /><br />
        </li>
    </c:forEach>
</ul>

</body>
</html>
