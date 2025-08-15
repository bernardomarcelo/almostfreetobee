<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Avaliacao</title>

<style >

	body {
	
	text-align: center;
	
	
	}
	



</style>


</head>
<body>
	
	<h1>AVALIAÇÃO</h1>
	
	<h2>
	
		<strong>Usuario:</strong> ${avaliacao.usuario.id } <br/>
		<strong>Estabelecimento:</strong> ${avaliacao.estabelecimento.id } <br/> <br>
		<strong>Nota:</strong> ${avaliacao.nota } <br> <br>
		<strong>Descrição:</strong>	${avaliacao.descricao } <br /><br/>
	
	
	</h2>

</body>
</html>