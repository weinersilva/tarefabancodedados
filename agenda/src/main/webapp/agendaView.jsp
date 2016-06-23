<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html lang="pt">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<title>Cadastro de Contato</title>
</head>
<body>
<br><br><br><br>
	<div align="center" class="panel panel-default">
		<div class="panel-body">
		<form class="form-horizontal" method="post" action="AgendaServletController">
			<fieldset>
			<legend>Cadastro de Contatos</legend>
				<div class="form-group" >
					<label class="col-md-4 control-label">Id: </label>
					<div class="col-md-5">
					<input name="id" required value="${agenda.id}" placeholder="1" class="form-control input-md"/>
					</div>
				</div> 
				
				<div class="form-group">	
					<label class="col-md-4 control-label">Nome:</label>
					<div class="col-md-5">
					<input name="nome" autofocus="autofocus" placeholder="Nome"  value="${agenda.nome}" class="form-control input-md"/>
					</div>
				</div>
				<div class="form-group">	
				 	<label class="col-md-4 control-label">Data de Nascimento:</label>
				 	<div class="col-md-5">
				 	<input type="date" name="datanascimento" value="${agenda.datanascimento}" placeholder="10/10/1980" class="form-control input-md"/>
				 	</div>
				</div> 
				<div class="form-group">	
				 	<label class="col-md-4 control-label">Telefone:</label>
				 	<div class="col-md-5">
				 	<input type="tel" name="telefone" placeholder="99 99999-9999" value="${agenda.telefone}" class="form-control input-md" />
				 	</div>
				</div>
				<div class="form-group">	
				 <label class="col-md-4 control-label">E-mail:</label>
				 <div class="col-md-5">
				 <input	type="email" name="email" placeholder="fulano@fulano.com.br"  value="${agenda.email}" class="form-control input-md"/>
				 </div>
				</div>
				<div class="form-group">		
					<label class="col-md-4 control-label">Ação</label> 
					 <div class="col-md-5" >
						<select	name="acao" required class="form-control">
							<option selected value="Incluir" class="form-control">Incluir</option>
							<option value="Alterar">Alterar</option>
							<option value="Excluir">Excluir</option>
							<option value="Consultar">Consultar</option>
						</select>
					</div>
				</div>
				<div class="form-group" >
					<div class="col-md-5" align="right">
						<input type="submit" value="Enviar" class="btn btn-success"> 
						<input type="reset" value="Limpar" class="btn btn-info"> 
					</div>
				</div>
			</fieldset>
		</form>
		<a href="index.jsp">Voltar</a>
	</div>
	</div>
</body>
</html>