<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html>

<head>
  <title>Perfil Usuario</title>
</head>

<body>
  <h1>
    <div style="text-align: center;">
      Perfil
    </div>
  </h1>
  <h2>
    <div style="text-align: center;">
      Dados Usuários
    </div>
  </h2>

  <div style="text-align: center;">
    <div style="display: flex; flex-direction: column; align-items: center;">

      <p><strong>Nome:</strong> ${usuario.nome}</p>
      <p><strong>Sobrenome:</strong> ${usuario.sobrenome}</p>
      <p><strong>Pronome:</strong> ${usuario.pronome}</p>
      <p><strong>Apelido:</strong> ${usuario.apelido}</p>
      <p><strong>Email:</strong> ${usuario.email}</p>

    </div>
  </div>

</body>
</html>