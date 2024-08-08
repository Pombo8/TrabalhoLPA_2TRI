<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "Model.Pessoa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carteira Digital - Pessoal</title>
<link rel="stylesheet" href="CarteiraDigital.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

</head>
<body>
<%
	String result = (String)request.getAttribute("metodo");
	Pessoa p = (Pessoa)request.getAttribute("pessoa");
	
	String sexo;
	if(p.getSexo()=='M') sexo = "Masculino";
	else sexo ="Feminino";
%>

<div class="profile-container">
  <div class="profile-header">
    <h2>Perfil - Carteira Digital</h2>
  </div>
  <div class="profile-field field-profile-picture">
    <img src="images/profile-pic.jpg" alt="Profile Picture">
  </div>
  <div class="profile-field field-name">
    <label>Nome: <%= p.getNome() %></label>
  </div>
  <div class="profile-field">
    <label>Sexo: <%= sexo %></label>
  </div>
  <div class="profile-field">
    <label>Data de Nascimento: <%= p.getDataNasc() %></label>
  </div>
  <div class="profile-field">
    <label>RG: <%= p.getRg() %></label>
  </div>
  <div class="profile-field">
    <label>CPF: <%= p.getCpf() %></label>
  </div>
  <div class="profile-field">
    <label>Salário: <%= p.getSalario() %></label>
  </div>
  <div class="profile-field">
    <label>Tempo de Contribuição: <%=p.getTempoContribuicao() %></label>
  </div>
  <div class="profile-field">
    <label>Área de Trabalho: <%=p.getAreaTrabalho() %></label>
  </div>
  <div class="profile-field">
    <label><%= (String)request.getAttribute("resposta") %>: <%= result %></label>
  </div>
  
</div>
</body>
</html>