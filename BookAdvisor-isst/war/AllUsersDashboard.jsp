<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Users - BookAdvisor</title>

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
							<li><a class="button special" href="<c:url value="${url}"/>"><c:out value="${urlLinktext}"/></a></li>
						</ul>
					</nav>
				</header>

			<!-- Banner -->
				<section id="banner">
					<div class="content menu-ancho text-center">
						<c:if test="${fn:length(users) == 0}">No hay usuarios todavía...</c:if>
					<c:forEach items="${users}" var="user">
						<div class="col-md-3 height offer">
							<h4><c:out value="${user.name}" /></h4>
							<h4><c:out value="${user.email}" /></h4>
							<hr>
							<p><c:out value="${user.type}" /></p>
							<p><c:out value="${user.id}" /></p>
							<br><br>
							<span>
								<a class="btn btn-danger btn-round btn-border-w" href="<c:url value="/eliminarusuario?id=${user.id}" />">Eliminar usuario</a>
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