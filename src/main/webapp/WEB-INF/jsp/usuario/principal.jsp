<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login/Criar Conta</title>
</head>
<body style="background-image:url('https://www.designerd.com.br/wp-content/uploads/2013/06/criar-rede-social.png')">
	<nav class="navbar navbar-default navbar-fixed-top">
  		<div class="container-fluid">
    		<!-- Brand and toggle get grouped for better mobile display -->
    		<div class="navbar-header">
      			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        			<span class="sr-only">Toggle navigation</span>
      			</button>
      			<a class="navbar-brand" href="#">Minha Rede</a>
    		</div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      			<ul class="nav navbar-nav navbar-right">
      				<li><a href="#">${usuariologado.usuario.nome}</a></li>
        			<li><a href="<c:url value="/logout/"/>">Sair</a></li>
      			</ul>
    		</div><!-- /.navbar-collapse -->
  		</div><!-- /.container-fluid -->
	</nav>
	
	<div class="container-fluid" style="margin-top: 60px;">
		<div class="row">
			<div class="col-md-3">
				<div class="input-group">
      				<span class="input-group-btn">
        				<button class="btn btn-default" type="button">Pesquisar</button>
      				</span>
      				<input type="text" class="form-control" placeholder="Pesquisar amigos">
    			</div><!-- /input-group -->
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
  						<h4 class="text-primary">Adicionar Publicação</h4>
  						<form action="<c:url value="/publicacao/adicionar"/>" method="post">
  							<div class="form-group">
								<label for="titulo">Título da Publicação</label> 
								<input type="text" class="form-control" id="titulo" name="publicacao.titulo" required>
							</div>
							<div class="form-group">
  								<label for="publicacao">Publicação</label>
  								<textarea class="form-control" rows="3" name="publicacao.conteudo"></textarea>
							</div>
							<input type="submit" class="btn btn-primary pull-right" value="Publicar">
  						</form>
  					</div>
				</div>
				
				
				
				<c:forEach items="${feed}" var="publicacao" >

					<div class="panel panel-default">
						<div class="panel-body">
							<h4 class="text-primary">${publicacao.titulo}</h4>
							<h5 class="text-muted">Autor: ${publicacao.usuario.nome}</h5>
							<p>${publicacao.conteudo}</p>
						</div>
					</div>

				</c:forEach>
			</div>
			<div class="col-md-3">
				<ul class="list-group">
					<li class="list-group-item">Meus Amigos</li>
				</ul>
				<ul class="list-group">
					<li class="list-group-item">Irvayne Matheus</li>
					<li class="list-group-item">Alexandre Lages</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>