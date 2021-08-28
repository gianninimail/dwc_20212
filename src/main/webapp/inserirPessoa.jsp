<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir nova Pessoa na Base de Dados</title>
</head>
<body>
	<div align="center">
		<p>Novo cadastro de Pessoa</p>
		<form action="InserirPessoaServlet">
			<label>Nome:</label>
			<input type="text" name="nome" value="digite seu nome!">
			<br /> 
			<input type="submit" value="Inserir">
		</form>
	
	</div>

</body>
</html>