<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Setup - BookAdvisor</title>

		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/main.css" />
		
		
</head>
<body class="landing">
		<div id="page-wrapper">

			<!-- Header -->
				<header id="header">
					<h1 id="logo"><a href="/">BookAdvisor</a></h1>
					<nav id="nav">
						<ul>
							<li><c:if test="${user != null}"><c:out value="${user.nickname}"/></c:if></li>
							<li><a class="button special" href="/nuevolibro">Subir nuevo libro</a></li>
							<li><a class="button special" href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></li>
						</ul>
					</nav>
				</header>

			<!-- Banner -->
				<section id="banner">
					<div class="content menu-ancho text-center">
					<form method="post" action="/nuevousuario">
									<div class="row uniform 50%">
										<div class="12u$">
											<input type="text" name="mail" id="mail" value="<c:out value="${mail}"/>" placeholder="Añade un mail">
										</div>
										 
										<div class="6u 12u$(xsmall)">
											<input type="text" name="nickname" id="nickname" value="<c:out value="${nickname}"/>" placeholder="Añade un nick">
										</div>
										<div class="6u 12u$(xsmall)">
											<input type="text" name="userId" id="userId" value="<c:out value="${userId}"/>" placeholder="Añade un userId">
										</div>
										<div class="12u$">
										<select name="type" id="type" required>
													<option value="">- Selecione tipo de usuario -</option>
													<option value="1">Usuario Normal</option>
													<option value="2">Biblioteca</option>
													<option value="3">Librería</option>
													<option value="4">Editorial</option>
										</select>
										</div>
										<div class="12u$">
											<ul class="actions">
												<li><input type="submit" value="Registrarse" class="special"></li>
											</ul>
										</div>
									</div>
								</form>		
					</div>
					
				</section>

		</div>

		<!-- Scripts -->
			<script src="js/jquery.min.js"></script>
			<script src="js/jquery.scrolly.min.js"></script>
			<script src="js/jquery.dropotron.min.js"></script>
			<script src="js/jquery.scrollex.min.js"></script>
			<script src="js/skel.min.js"></script>
			<script src="js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="js/main.js"></script>
			<script src="js/bootstrap.min.js"></script>

	</body>
</html>