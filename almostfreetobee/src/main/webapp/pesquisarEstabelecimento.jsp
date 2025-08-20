<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Pesquisa Estabelecimentos</title>
	</head>
	<body>
		<div>
			<form action='realizar-pesquisa' method="post">
			<input type='search' name='recuperarEstabelecimento' id='recuperarEstabelecimento' placeholder='Procure por estabelecimentos...'>
			<input type='submit' value="Pesquisar">
			</form>
		</div>

			<div>
				<c:forEach var="estabelecimento" items="${estabelecimentos}">
					<div>
						<h1><c:out value="${estabelecimento.nome}"/></h1>			
						<h4><c:out value="${estabelecimento.email}"/></h4>
						<h4><c:out value="${estabelecimento.telefone}"/></h4>
					</div>
				</c:forEach>
			</div>
			<br>
	</body>
</html>