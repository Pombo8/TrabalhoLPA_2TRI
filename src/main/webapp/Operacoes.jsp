<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Form.css">
<meta charset="ISO-8859-1">
<title>Operações</title>
</head>
<body>
	<div class="form-container">
		<form action="ServletController" method="get">
			<h2>Operações</h2>
			<input type="hidden" name="cpf2" value="<%=request.getParameter("cpf")%>">
			<input type="radio" id="1" value="1" name="metodo"><label
				class="radio-label" for="1"> Salario Anual</label> <input
				type="radio" id="2" value="2" name="metodo"><label
				class="radio-label" for="2"> Salario pós Imposto</label> <input
				type="radio" id="3" value="3" name="metodo"><label
				class="radio-label" for="3"> Ver Aposentadoria</label> <input
				type="radio" id="4" value="4" name="metodo"><label
				class="radio-label" for="4"> Ver Salario de Aposentado</label> 
				<input type="Submit" value="Finalizar" name="operacao" class="submit-button">
		</form>
		<a href="./index.html">Página Inicial</a>
	</div>
</body>
</html>