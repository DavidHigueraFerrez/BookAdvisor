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
						<c:if test="${fn:length(books) == 0}">No hay publicado ningun libro todavía...</c:if>
					<c:forEach items="${books}" var="book">
						<div class="col-md-3 height offer">
							<h4><c:out value="${book.title}" /></h4>
							<h4><c:out value="${book.autor}" /></h4>
							<hr>
							<c:if test="${book.promoted}">
							<img src="http://static.wixstatic.com/media/f574f9_cac5c38478c9422d9650e602da86eeea~mv2.png" style="width: 35%; position: absolute; left: 14%;"></c:if>	
							<img src="${book.portada}" style="width:100%">
							<br><br>
							<span>
								<a class="btn btn-default btn-round btn-border-w" href="<c:url value="/detallelibro?id=${book.id}" />">Ver detalle</a>
								<a class="btn btn-danger btn-round btn-border-w" href="<c:url value="/valorarlibro?id=${book.id}" />">Valorar</a>
							</span>
						</div>
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