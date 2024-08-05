<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.Pessoa" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>Exibir Tarefas</title>
	</head>
	<body>
		<h3>Lista de Tarefas</h3>
		
		<%
			 ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>) request.getAttribute("pessoasBanco");
			
		%>
		
		<table border="1">
			<tr>
				<th>Nome</th>
				<th>Sexo</th>
				<th>Idade</th>
				<th>RG</th>
				<th>CPF</th>
				<th>Salário</th>
				<th>Contribuição</th>
				<th>Area</th>
			</tr>
			
			<%
				try{
					for(Pessoa pessoa: listaPessoa){
				
					out.println("<tr>");
					out.println("<td>" + pessoa.getNome() + "</td>");
					out.println("<td>" + pessoa.getSexo() + "</td>");
					out.println("<td>" + pessoa.getIdade() + "</td>");
					out.println("<td>" + pessoa.getRg() + "</td>");
					out.println("<td>" + pessoa.getCpf() + "</td>");
					out.println("<td>" + pessoa.getSalario() + "</td>");
					out.println("<td>" + pessoa.getTempoContribuicao() + " Anos</td>");
					out.println("<td>" + pessoa.getAreaTrabalho() + "</td>");
					out.println("<td><a href=\"ServletController?operacao=Remover&cpf=" + pessoa.getCpf() + "\"><img src=\"trash.png\" height=\"20px\"></td>");
					out.println("<td><a href=\"ServletController?operacao=Buscar&cpf=" + pessoa.getCpf() + "\"><img src=\"edit.png\" height=\"20px\"></td>");
					out.println("</tr>");
				}			
				}
				catch(NullPointerException e){
					
				}
				try{
				if(listaPessoa.isEmpty()){
					out.println("Não há registros de pessoas ainda!");
				}
				}
				catch(NullPointerException e){
					out.println("Não há registros de pessoas ainda!");
				}
			%>
		</table>
		
		<p><a href="index.html">Inicio</a></p>
</body>
</html>