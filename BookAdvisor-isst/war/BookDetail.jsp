<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Libros - BookAdvisor</title>

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
							<li><a class="button special" href="/nuevolibro">Nuevo libro</a></li>
							<li><a class="button special" href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></li>
						</ul>
					</nav>
				</header>

			<!-- Banner -->
				<section id="banner">
					<div class="content menu-ancho text-center">
						<div class="col-md-6 height offer">
							<h4><c:out value="${books.title}" /></h4>
							<h6><c:out value="${books.autor}" /></h6>
							<img src="${books.portada}" style="width:20%">
							<p title="${books.categoria}"><strong>Categoría: </strong><c:out value="${books.categoria}" /></p>
						</div>
						<div class="col-md-6 height offer">
							<p title="${nota}"><strong>Valoración media: </strong><c:out value="${nota}" /></p>
							<p title="${books.description}"><strong>Descripción: </strong><c:out value="${books.description}" /></p>				
							<p title="${books.isbn}"><strong>ISBN: </strong><c:out value="${books.isbn}" /></p>
						</div>
					<div class="col-md-12 offer text-left">
					<c:if test="${books.promoted}">
					<p><strong>Precio de venta: </strong><c:out value="${books.price}" /></p>
					<p><a href="<c:url value="${books.url}"/>"><strong>Link de compra </strong></a></p>
					<p><strong>Ubicación: </strong><c:out value="${books.ubicacion}" /></p>
					</c:if>
					<c:if test="${books.available}">
					<p><strong>Está disponible para préstamo</strong></p>
					</c:if>
					<c:if test="${book.ubicacion}">
					<p><strong>Ubicación: </strong><c:out value="${books.ubicacion}" /></p>
					</c:if>
					<hr>
					<h3 class="text-center">Valoraciones</h3>
					<c:forEach items="${resenas}" var="resena">
						<div class="col-md-12 height offer">
							<h4><c:out value="${resena.title}" /></h4>
							<p title="${resena.description}"><c:out value="${resena.description}" /></p>
							<p title="${resena.nota}">Nota: <c:out value="${resena.nota}" /></p>
							<hr>
						</div>
						<hr>
					</c:forEach>		
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