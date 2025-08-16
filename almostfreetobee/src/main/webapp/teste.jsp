<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Formulário de Cadastro</title>
</head>
<body>
    <h2><%= "Cadastrar Usuario" %></h2>

    <form action="seuServlet" method="post">
        <label for="nome">Nome:</label><br>
        <input type="text" id="nome" name="nome" placeholder="Digite seu nome" required><br><br>

        <label for="sobrenome">Sobrenome:</label><br>
        <input type="text" id="sobrenome" name="sobrenome" placeholder="Digite seu sobrenome" required><br><br>

        <label for="apelido">Apelido:</label><br>
        <input type="text" id="apelido" name="apelido" placeholder="Digite seu apelido"><br><br>

        <label for="email">E-mail:</label><br>
        <input type="email" id="email" name="email" placeholder="exemplo@dominio.com" required><br><br>

        <label for="senha">Senha:</label><br>
        <input type="password" id="senha" name="senha" placeholder="Digite sua senha" required><br><br>

        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>