<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.*, model.Pessoa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Lista de Pessoas na Base de Dados</title>
</head>
<body>
	<div align="center">
		<h4>Lista de Pessoas da Base de dados</h4>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Nome</th>
			</tr>
			<%
				List<Pessoa> listaDePessoas = (List<Pessoa>)session.getAttribute("listaDePessoas");
			
				session.setAttribute("numPessoas", listaDePessoas.size());
			
				for (Pessoa p : listaDePessoas) {
			%>
				<tr>
					<td>
						<%= p.getCpf() %>
					</td>
					<td>
						<%= p.getNome() %>
					</td>
				
				</tr>
			<%
				}
			
			%>
		</table>
		<br />
		<a href="inserirPessoa.jsp">Add Pessoa</a>
	</div>
</body>
</html>