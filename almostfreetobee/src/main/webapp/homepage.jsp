<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Free to Bee</title>
</head>

<body>
<c:choose>
	<c:when test="${not empty sessionScope.usuarioLogado}">
	
	<h1>Homepage</h1>

<p>Dê uma olhada em seu perfil!<a href='/almostfreetobee/perfil'>Seu perfil!!</a></p> <br> <br>

<p>Cadastre um estabelecimento!<a href='/almostfreetobee/estabelecimento/novo'>Novo estabelecimento!!</a></p> <br> <br>

<p>Pesquise um estabelecimento!<a href='/almostfreetobee/estabelecimento/pesquisar-estabelecimento'>Veja Estabelecimentos!!</a></p> <br> <br>

<p>Veja suas avaliações!<a href='/almostfreetobee/exibir-avaliacoes'>Suas avaliações!!</a></p> <br> <br>

<p>Veja seus estabelecimentos!<a href='/almostfreetobee/exibir-estabelecimentos'>Seus estabelecimentos!!</a></p>

	</c:when>

	<c:otherwise>
	  
    <header>
        <h1> Free to <span class="destaque">Bee</span></h1>
    </header>

    <main>

            <h2 id="titulo-introducao">
                Em busca de estabelecimentos <span class="destaque">amigáveis?</span>
                Descubra, avalie e compartilhe locais que respeitam e acolhem a <span class="destaque">diversidade</span>.
            </h2>
    
            <h2 id="titulo-destaques">Estabelecimentos <span class="destaque">destaques</span></h2>

            
         <c:forEach var="estabelecimento" items="${estabelecimentos}">
  		  	<div>
       		 	<p><c:out value="${estabelecimento.foto}"/></p>
        		<h1><c:out value="${estabelecimento.nome}"/></h1>			
    		</div>
		</c:forEach>
        
            <p><a href="/almostfreetobee/estabelecimento/pesquisar-estabelecimento">Ver mais estabelecimentos amigáveis...</a></p>
            
   
            
            <h2 id="titulo-comunidade">Depoimentos da <span class="destaque">comunidade</span></h2>
            <div id="lista-depoimentos" class="depoimentos">
            <c:forEach var="depoimento" items="${depoimentos}">
					<div>
						<p><c:out value="${depoimento.foto}"/></p>
						<h1><c:out value="${depoimento.nome}"/></h1>			
					</div>
            </c:forEach>
            </div>        

            <h2 id="titulo-depoimento">
                Quanto mais gente participa, mais forte é a nossa comunidade.
                Avalie, comente e indique lugares que fazem a diferença.
            </h2>
        
        <section class="chamada">
            <h2>
                Ainda não é uma abelha? Junte-se à <span class="destaque">Colmeia</span> que acolhe e compartilha.
            </h2>
           <a href='/almostfreetobee/novo'>Cadastre-se</a>
        </section>

    </main>
	
	</c:otherwise>
</c:choose>

</body>
</html>