<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Avaliacao</title>

<style>
body {
	text-align: center;
}
</style>


</head>
<body>

	<h1>AVALIAÇÃO</h1>

	<h2>


		<strong>Nota:</strong> ${avaliacao.nota } <br> <br> 
		<strong>Descrição:</strong>
		${avaliacao.descricao } <br /> <br />


	</h2>

</body>
</html>