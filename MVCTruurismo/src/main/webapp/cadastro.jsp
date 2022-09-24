<%@page import="model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- PERMITE O USO DA TAG LIB DO FORM DE EXIBIÇÃO DA LISTA -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>CADASTRE-SE</title>
</head>
<body>

	<div class="container-fluid">


		<!--INÍCIO MENU -->
		<div class="row">
			<nav class="navbar navbar-expand-sm navbar-light bg-danger">
				<div class="container">
					<a class="navbar-brand" href="index.html">TRUURISMO</a>
					<button class="navbar-toggler d-lg-none" type="button"
						data-bs-toggle="collapse" data-bs-target="#collapsibleNavId"
						aria-controls="collapsibleNavId" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="collapsibleNavId">
						<ul class="navbar-nav">
							<li class="nav-item active"><a class="nav-link text-light"
								href="index.html">HOME</a></li>
							<li class="nav-item active"><a class="nav-link text-light"
								href="destinos.html" target="_blank">DESTINOS</a></li>
							<li class="nav-item"><a class="nav-link text-light"
								href="promocoes.html" target="_blank">PROMOÇÕES</a></li>
							<li class="nav-item"><a class="nav-link text-light" href="#">CONTATO</a>
							</li>
							<li class="nav-item"><a class="nav-link text-light" href="#"
								target="_blank">LOGIN</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>

		<!-- FIM MENU -->

	</div>


	<div class="container-fluid mt-3 mb-3">


		<div class="row">

			<div class="col-12">
				<form action="Cadastrar" method="post">

					<input type="text" name="nome" placeholder="Digite seu nome"
						required /> <input type="email" name="email"
						placeholder="Digite seu e-mail" required /> <input
						type="password" name="senha" maxlength="4"
						placeholder="Digite sua senha" required /> <input type="submit"
						value="Cadastrar" />

				</form>
			</div>
		</div>


		<div class="row">

			<div class="col-12">
				<a href="Listar">Usuários cadastrados</a>
				<table class="table mt-3">
					<thead>
						<tr>
							<!-- <th>Id</th>  -->
							<th>Nome</th>
							<th>Email</th>
							<th>Senha</th>
						</tr>
					</thead>
					<tbody>
					
						<jstl:forEach items="${listaUsuarios}" var="cadastro">
							<tr>
							<!-- <td>${usuario.id}</td>  -->
								<td>${usuario.nome}</td>
								<td>${usuario.email}</td>
								<td>${usuario.senha}</td>

								<td>
								
								</td>
							</tr>
						</jstl:forEach>

					</tbody>
				</table>



			</div>

		</div>

	</div>


</body>
</html>