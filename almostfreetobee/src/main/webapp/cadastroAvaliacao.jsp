<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Avaliacao</title>

</head>
<body>
	<h1>Enviar Avaliação</h1>
   <form method="post" action="cadastrar">
    <input type="hidden" name="estabelecimentoId" value="${estabelecimentoId}" />

    <label for="nota">Nota do Estabelecimento:</label><br />
    <input type="number" id="nota" name="nota" required /><br /><br />

    <label for="descricao">Descrição da Avaliação:</label><br />
    <textarea id="descricao" name="descricao" rows="5" cols="40" required></textarea><br><br>

    <button type="submit">Enviar Avaliação</button>
</form>
</body>
</html>