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
<title>Insert title here</title>
</head>
<body style="background-image:url('https://www.designerd.com.br/wp-content/uploads/2013/06/criar-rede-social.png')">
	<div class="container" style="padding-top: 100px;" >
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-body">
							<h4>Login</h4>
							<form action="<c:url value="/login"/>" method="post">
								<div class="form-group">
									<label for="email">Email</label> 
									<input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Digite seu email">
									<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
								</div>
								<div class="form-group">
									<label for="senha">Senha</label> 
									<input type="password" class="form-control" id="senha" placeholder="Digite sua senha">
								</div>
								<button type="submit" class="btn btn-success btn-block">Entrar</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-body">
							<h4>Nova Conta</h4>
							<c:if test="${mensagem != null}">
								<span class="form-text text-success">${mensagem}</span>
							</c:if>
							<c:if test="${erro != null}">
								<span class="form-text text-danger">${erro}</span>
							</c:if>
							<form action="<c:url value="/usuario/adicionar"/>" method="post">
								<div class="form-group">
									<label for="Nome">Nome</label> 
									<input type="text" class="form-control" id="nome" aria-describedby="emailHelp" placeholder="Digite seu nome" name="usuario.nome" required>
								</div>
								<div class="form-group">
									<label for="email">Email</label> 
									<input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Digite seu email" name="usuario.email" required>
								</div>
								<div class="form-group">
									<label for="senha">Senha</label> 
									<input type="password" class="form-control" id="senha" placeholder="Digite sua senha" name="usuario.senha" required>
								</div>
								<button type="submit" class="btn btn-primary btn-block">Criar Conta</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>