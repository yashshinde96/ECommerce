<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<!-- Basic -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- Mobile Metas -->
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.0-beta2/css/bootstrap.min.css'>
<link rel="stylesheet" href='<spring:url value="/css/index.css"/>'>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- Site Metas -->
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="shortcut icon"
	href='<spring:url value="/images/favicon.png"/>' type="">
<title>Gift Mania</title>
<!-- bootstrap core css -->
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/css/bootstrap.css"/>' />
<!-- font awesome style -->
<link href='<spring:url value="/css/font-awesome.min.css"/>'
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href='<spring:url value="/css/style.css"/>' rel="stylesheet" />
<!-- responsive style -->
<link href='<spring:url value="/css/responsive.css"/>' rel="stylesheet" />
</head>
<body>
	<div class="hero_area">
		<!-- header section strats -->
		<header class="header_section">
			<div class="container">
				<nav class="navbar navbar-expand-lg custom_nav-container ">
					<a class="navbar-brand" href="index.html"><img width="250"
						src='<spring:url value="/images/brandingimage.png"/>' alt="#" /></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class=""> </span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav">
							<li class="nav-item active"><a class="nav-link"
								href='<spring:url value="/"/>'>Home <span class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="true"> <span
									class="nav-label">Pages <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href='<spring:url value="/about"/>'>About</a></li>
									<li><a href='<spring:url value="/testimonial"/>'>Testimonial</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link" href='<spring:url value="/products"/>'>Products</a>
							</li>
							
							
							<%
								if (session.getAttribute("userDetails") != null) {
							%>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="true"> <span
									class="nav-label">${sessionScope.userDetails.name} <span
										class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href='<spring:url value="/Customer/viewCart"/>'>View Cart </a></li>
									<li><a href='<spring:url value="/Customer/myorders"/>'>Orders</a></li>
									<li><a href='<spring:url value="/logout"/>'>Sign Out</a></li>
								</ul></li>
							<%
								} else {
							%>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="true"> <span
									class="nav-label">Sign In <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href='<spring:url value="/login"/>'>Sign In </a></li>
									<li><a href='<spring:url value="/register"/>'>Register</a></li>
								</ul></li>
							<%
								}
							%>
						</ul>
					</div>
				</nav>
			</div>
		</header>