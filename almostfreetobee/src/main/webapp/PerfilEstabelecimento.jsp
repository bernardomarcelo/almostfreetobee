<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Perfil do Estabelecimento</title>
</head>
<body>
	
	<h1>${estabelecimento.foto.conteudoFoto}</h1>
    <h1>${estabelecimento.nome}</h1>
    
    <h2><strong>Endereço</strong></h2>
    <p>
        Logradouro: ${estabelecimento.endereco.logradouro}, 
        Bairro: ${estabelecimento.endereco.bairro}, 
        Cidade: ${estabelecimento.endereco.cidade}, 
        CEP: ${estabelecimento.endereco.cep}
    </p>
    
    <h2><strong>Contato</strong></h2>
    <p>Telefone: ${estabelecimento.telefone}</p>
    <p>E-mail: ${estabelecimento.email}</p>
    
    <h2><strong>Tipo de estabelecimento</strong></h2>
    <p>${estabelecimento.tipoEstabelecimento}</p>
</body>
</html>