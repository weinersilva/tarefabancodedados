<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<html lang="pt">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Lista de Contatos</title>
</head>
<body>
	<br><br><br><br>
	<div align="center"  class="panel panel-default">
		<div class="panel-body">
		<fieldset>
			<legend>Lista de Contatos</legend>
			<div class="table-responsive">
				<table border="1" class="table table-striped">
					<thead>
						<tr>
							<td>Id</td>
							<td>Nome</td>
							<td>Data de Nascimento</td>
							<td>Telefone</td>
							<td>E-mail</td>
							<td>Comandos</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="agenda" items="${listaagenda}">
						<tr>
							<td>${agenda.id}</td>
							<td>${agenda.nome}</td>
							<td>${agenda.datanascimento}</td>
							<td>${agenda.telefone}</td>
							<td>${agenda.email}</td>  
							<td><a href="AgendaServletController?acao=Excluir&id=${agenda.id}">Excluir</a></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<c:if test="${fn:length(listaagenda) > 0}">
   			<div class="alert alert-info" role="alert">Existem ${fn: length(listaagenda)} contatos!</div>
 		</c:if>  <br> 
 		</fieldset>		
	</div>
	<a href="index.jsp">Voltar</a>
 	</div>
</body>
</html>