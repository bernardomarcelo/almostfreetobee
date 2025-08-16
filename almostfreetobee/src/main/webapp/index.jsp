<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sessão</title>
</head>
<body>
        <form action='${pageContext.request.contextPath}' method='post'>
            <label for='email'>E-mail*</label>
            <input type='text' name='email' required placeholder='Insira seu endereço de e-mail' size='25'>
            <br><br>
            <label for='senha'>Senha*</label>
            <input type='password' name='senha' required placeholder='Insira sua senha' size='25'>
            <br><br>
          <button type="submit" class="btn-primary">Iniciar Sessão</button>
            <button type='reset'>Limpar</button>
        </form> 	
        <br>
        <p>Não possui uma conta? <a href='/almostfreetobee/cadastrar'>Cadastre-se</a></p>
</body>
</html>