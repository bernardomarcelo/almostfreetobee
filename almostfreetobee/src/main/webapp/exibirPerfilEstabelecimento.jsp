	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Perfil do Estabelecimento</title>
</head>
<body>
    <h1>${estabelecimento.nome}</h1>
    
    <h2><strong>Endereço</strong></h2>
    <p>
        ${estabelecimento.endereco.logradouro}, 
        ${estabelecimento.endereco.bairro}, 
        ${estabelecimento.endereco.cidade}, 
        CEP: ${estabelecimento.endereco.cep}
    </p>
    
    <h2><strong>Contato</strong></h2>
    <p>Telefone: ${estabelecimento.telefone}</p>
    <p>E-mail: ${estabelecimento.email}</p>
    <p>E-mail: ${estabelecimento.id}</p>
    <h2><strong>Tipo de estabelecimento</strong></h2>
    <p>${estabelecimento.tipoEstabelecimento}</p>
    
    <a href="${pageContext.request.contextPath}/avaliacao/novo?estabelecimentoId=${estabelecimento.id}">
    Adicionar Avaliação
</a>
</body>
</html>