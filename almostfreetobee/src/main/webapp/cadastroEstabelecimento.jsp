<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Estabelecimento</title>
</head>
<body>

<h2>Free to Bee</h2>

<form action ="cadastrar" method="post">

        <h3>Informações gerais</h3>
	    <label>Nome do estabelecimento*</label>
		<input type="text" id="nome" name="nome" placeholder="" required>
		<br>
		<label>Tipo de estabelecimento*</label>
		<select name="tipo">
        <option value="MERCADO">Mercado</option>
        <option value="LOJA">Loja</option>
        <option value="FARMACIA">Farmácia</option>
        <option value="RESTAURANTE">Restaurante</option>
        <option value="BAR">Bar</option>
        <option value="CASA_NOTURNA">Casa Noturna</option>
        <option value="TEATRO">Teatro</option>
        <option value="SHOPPING">Shopping</option>
        <option value="MUSEU">Museu</option>
        <option value="HOTEL">Hotel</option>
        <option value="LIVRARIA">Livraria</option>
        <option value="ACADEMIA">Academia</option>
        <option value="CLINICA">Clínica</option>
    	</select>
    	<br>
    	<label>CNPJ*</label>
    	<input type="text" id="cnpj" name="cnpj" placeholder="" required>
    	<br>
		<label>Horario de funcionamento</label>
    	<input type="number" id="abertura" name="abertura" placeholder="" required>
    	<input type="number" id="fechamento" name="fechamento" placeholder="" required>
    	<br>
    	<h3>Endereco</h3>
    	<br>
    	<label>Estado</label>
    	<input type="text" id="estado" name="estado" placeholder="" required>
    	<br>
		<label>Cidade</label>
    	<input type="text" id="cidade" name="cidade" placeholder="" required>
    	<br>
    	<label>Bairro</label>
    	<input type="text" id="bairro" name="bairro" placeholder="" required>
    	<br>
    	<label>Cidade</label>
    	<input type="text" id="cidade" name="cidade" placeholder="" required>
    	<br>
    	<label>CEP</label>
    	<input type="number" id="cep" name="cep" placeholder="" required>
    	<br>
    	<label>Logradouro</label>
    	<input type="text" id="logradouro" name="logradouro" placeholder="" required>
    	<br>
    	<h3>Contato do estabelecimento</h3>
    	<br>
    	<label>Telefone</label>
    	<input type="text" id="telefone" name="telefone" placeholder="" required>
    	<br>
		<label>E-mail</label>
    	<input type="text" id="email" name="email" placeholder="" required>
    	<br>
		<button type="submit">Salvar</button>
		<button type="reset">Limpar Formulário</button>
		
		
	</form>

</body>
</html>