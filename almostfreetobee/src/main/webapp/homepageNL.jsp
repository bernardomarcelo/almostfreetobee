<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Free to Bee</title>
    <link href="estilos.css">
</head>

<body>

    
    <header>
        <h1> Free to <span class="destaque">Bee</span></h1>
    </header>

    <main>

            <h2 id="titulo-introducao">
                Em busca de estabelecimentos <span class="destaque">amigáveis?</span>
                Descubra, avalie e compartilhe locais que respeitam e acolhem a <span class="destaque">diversidade</span>.
            </h2>
    
            <h2 id="titulo-destaques">Estabelecimentos <span class="destaque">destaques</span></h2>

            
            <div id="lista-destaques" class="cartoes">
                		<c:forEach var="estabelecimento" items="${estabelecimentos}"/>
					<div>
						<p><c:out value="${estabelecimento.foto}"/></p>
						<h1><c:out value="${estabelecimento.nome}"/></h1>			
					</div>
            </div>
        
            <p><a href="">Ver mais estabelecimentos amigáveis...</a></p>
            
   
            
            <h2 id="titulo-comunidade">Depoimentos da <span class="destaque">comunidade</span></h2>
            <div id="lista-depoimentos" class="depoimentos">
            <c:forEach var="depoimento" items="${depoimentos}"/>
					<div>
						<p><c:out value="${depoimento.foto}"/></p>
						<h1><c:out value="${depoimento.nome}"/></h1>			
					</div>
                
            </div>        

            <h2 id="titulo-depoimento">
                Quanto mais gente participa, mais forte é a nossa comunidade.
                Avalie, comente e indique lugares que fazem a diferença.
            </h2>
        
        <section class="chamada">
            <h2>
                Ainda não é uma abelha? Junte-se à <span class="destaque">Colmeia</span> que acolhe e compartilha.
            </h2>
            <button type="button">Cadastre-se</button>
        </section>

    </main>

</body>
</html>