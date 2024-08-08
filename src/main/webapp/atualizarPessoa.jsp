<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Pessoa" %>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" href="Form.css">
		<meta charset="ISO-8859-1">
		<title>Atualização de Perfil</title>
	</head>
	<body>
	
		
		<%
			Pessoa pessoa = (Pessoa) request.getAttribute("pessoa");
		%>
		<div class="form-container">
			<h3>Atulização da Tarefa</h3>
		<form action="ServletController" method="POST">
			<label>Nome:</label> <input required class="input-field" value=<%=pessoa.getNome() %> type="text" name="nome">
			<label>Sexo:</label>
			<select required class="input-field"  name="sexo" id="sexo">		
			<% if(pessoa.getSexo()=='M'){
					out.println("<option selected value='m'>Masculino</option>");
					out.println("<option value='f'>Feminino</option>");
				}
				else{
					out.println("<option value='m'>Masculino</option>");
					out.println("<option selected value='f'>Feminino</option>");
				}
					%>
				<option value="M">Masculino</option>
				<option value="F">Feminino</option>
			</select>
			<label>Data de Nascimento:</label> <input required class="input-field" value=<%=pessoa.getDataNasc() %> type="date" name="dataNasc">
			<input required type="hidden" value=<%=pessoa.getRg() %> maxlength="10" minlength="7" name="rg">
			<input required type="hidden" value=<%=pessoa.getCpf() %> maxlength="11" minlength="11" name="cpf">
			<label>Salário:</label> <input required class="input-field" value=<%=pessoa.getSalario() %> type="number" step="0.01" name="salario">
			<label>Tempo de Contribuição:</label> <input required class="input-field" value=<%= pessoa.getTempoContribuicao() %>  type="number" step ="1" name="tempoContribuicao">
			<label>Area de Trabalho:</label>
			<select required class="input-field" name="areaTrabalho" id="areaTrabalho">
				<% if(pessoa.getAreaTrabalho().equals("Rural")){
					out.println("<option selected value='Rural'>Rural</option>");
					out.println("<option value='Urbano'>Urbano</option>");
				}
				else{
					out.println("<option value='Rural'>Rural</option>");
					out.println("<option selected value='Urbano'>Urbano</option>");
				}
					%>
				
			</select>
			<input type="submit" value="Atualizar" name="operacao">
		</form>
		</div>
	</body>
</html>