<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Pessoa" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Atualização de tarefa</title>
	</head>
	<body>
		<h3>Atulização da Tarefa</h3>
		
		<%
			Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
		%>
		
		<form action="ServletController" method="POST">
			<label>Nome:</label> <input required class="input-field" value=<%=pessoa.getNome() %> type="text" name="nome">
			<label>Sexo:</label>
			<select required class="input-field" value=<%=pessoa.getSexo() %>  name="sexo" id="sexo">
				<option value="M">Masculino</option>
				<option value="F">Feminino</option>
			</select>
			<label>Data de Nascimento:</label> <input required class="input-field" value=<%=pessoa.getDataNasc() %> type="date" name="dataNasc">
			<input required type="hidden" value=<%=pessoa.getRg() %> maxlength="10" minlength="7" name="rg">
			<input required type="hidden" value=<%=pessoa.getCpf() %> maxlength="11" minlength="11" name="cpf">
			<label>Salário:</label> <input required class="input-field" value=<%=pessoa.getSalario() %> type="number" step="0.01" name="salario">
			<label>Tempo de Contribuição:</label> <input required class="input-field" value=<%= pessoa.getTempoContribuicao() %>  type="number" step ="1" name="tempoContribuicao">
			<label>Area de Trabalho:</label>
			<select required class="input-field" value=<%= pessoa.getAreaTrabalho() %>  name="areaTrabalho" id="areaTrabalho">
				<option value="Rural">Rural</option>
				<option value="Urbano">Urbano</option>
			</select>
			<input type="submit" value="Atualizar" name="operacao">
		</form>
	</body>
</html>