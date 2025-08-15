<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de avaliacoes</title>
</head>
<body>

<h1>Lista de Avaliações</h1>

<ul>
    <c:forEach var="avaliacao" items="${avaliacoes}">
        <li>
            Usuário: ${avaliacao.usuario.id} <br />
            Estabelecimento: ${avaliacao.estabelecimento.id} <br />
            Nota: ${avaliacao.nota} <br />
            Descrição: ${avaliacao.descricao} <br /><br />
        </li>
    </c:forEach>
</ul>

</body>
</html>
