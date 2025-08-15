
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Avaliacao</title>

</head>
<body>
	<h1>Enviar Avaliação</h1>
    <form method="post" action="${pageContext.request.contextPath}/avaliacao">
        <label for="estabelecimentoId">ID do Estabelecimento:</label><br />
        <input type="text" id="estabelecimentoId" name="estabelecimentoId" value="2" required /><br /><br />
        
         <label for="usuarioId">ID do Usuario:</label><br />
        <input type="text" id="usuarioId" name="usuarioId" value="2" required /><br /><br />
        
         <label for="nota">Nota do Estabelecimento:</label><br />
        <input type="number" id="nota" name="nota" value="1" required /><br /><br />
        
        <label for="descricao">Descricao da Avaliação:</label><br />
        <textarea id="descricao" name="descricao" rows="5" cols="40" required></textarea><br /><br />
        
        <button type="submit">Enviar Avaliação</button>
    </form>
</body>
</html>