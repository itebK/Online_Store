<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<title>${title}</title>
<!-- SEO Meta Tags-->
<meta name="description"
	content="Unishop - Universal E-Commerce Template">
<meta name="keywords"
	content="shop, e-commerce, modern, flat style, responsive, online store, business, mobile, blog, bootstrap 4, html5, css3, jquery, js, gallery, slider, touch, creative, clean">
<meta name="author" content="Rokaux">
<!-- Mobile Specific Meta Tag-->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<!-- Favicon and Apple Icons-->
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/resources/img/favicon/favicon.ico">
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/resources/img/favicon/favicon.png">
<link rel="apple-touch-icon"
	href="${pageContext.request.contextPath}/resources/img/favicon/touch-icon-iphone.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="${pageContext.request.contextPath}/resources/img/favicon/touch-icon-ipad.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="${pageContext.request.contextPath}/resources/img/favicon/touch-icon-iphone-retina.png">
<link rel="apple-touch-icon" sizes="167x167"
	href="${pageContext.request.contextPath}/resources/img/favicon/touch-icon-ipad-retina.png">
<!-- Vendor Styles including: Bootstrap, Font Icons, Plugins, etc.-->
<link rel="stylesheet" media="screen"
	href="${pageContext.request.contextPath}/resources/css/vendor.min.css">
<!-- Main Template Styles-->
<link id="mainStyles" rel="stylesheet" media="screen"
	href="${pageContext.request.contextPath}/resources/css/styles.min.css">
<!-- Customizer Styles-->
<link rel="stylesheet" media="screen"
	href="${pageContext.request.contextPath}/resources/customizer/customizer.min.css">

<!-- Modernizr-->
<script
	src="${pageContext.request.contextPath}/resources/js/modernizr.min.js"></script>
</head>
<!-- Body-->
<body>




	<!-- Off-Canvas Category Menu-->
	<div class="offcanvas-container" id="shop-categories">
		<div class="offcanvas-header">
			<h3 class="offcanvas-title">
				<sec:authorize access="isAuthenticated()">
					<sec:authentication property="principal.username" />
				</sec:authorize>
			</h3>
		</div>
		<nav class="offcanvas-menu">
			<ul class="menu">

				<li class="has-children"><span> <a href="/store/home">Home</a>
				</span></li>
				<sec:authorize access="hasRole('VENDEUR_ROLE')">
					<li class="has-children"><span> <a
							href="/store/vendeur/add-boutique">My Shop</a>
					</span></li>
				</sec:authorize>
				<li class="has-children"><span> <a
						href="/store/client/products">Articles</a>
				</span></li>
				<li class="has-children"><span> <a
						href="/store/client/category-product">Categories</a>
				</span></li>



			</ul>
		</nav>
	</div>
	<!-- Off-Canvas Mobile Menu-->
	<div class="offcanvas-container" id="mobile-menu">
		<a class="account-link" href="/store/profile">
			<div class="user-ava">
				<img
					src="${pageContext.request.contextPath}/resources/img/account/user-ava-md.jpg"
					alt="">
			</div>
			<div class="user-info">
				<h6 class="user-name">Connected user</h6>
				<span class="text-sm text-white opacity-60">Role</span>
			</div>
		</a>
		<nav class="offcanvas-menu">
			<ul class="menu">
				<li class="has-children active"><span> <a
						href="/store/home"> <span>Home</span>
					</a>
				</span></li>



			</ul>
		</nav>
	</div>
	<!-- Topbar-->
	<div class="topbar">
		<div class="topbar-column">
			<a class="hidden-md-down" href="mailto:contact@isamm.com"><i
				class="icon-mail"> </i>&nbsp; contact@isamm.com</a> <a
				class="hidden-md-down" href="tel:0021626018141"> <i
				class="icon-bell"></i>&nbsp; 00 216 26 01 81 41
			</a> <a class="social-button sb-facebook shape-none sb-dark" href="#"
				target="_blank"> <i class="socicon-facebook"></i></a> <a
				class="social-button sb-twitter shape-none sb-dark" href="#"
				target="_blank"> <i class="socicon-twitter"></i></a> <a
				class="social-button sb-instagram shape-none sb-dark" href="#"
				target="_blank"> <i class="socicon-instagram"></i></a> <a
				class="social-button sb-pinterest shape-none sb-dark" href="#"
				target="_blank"> <i class="socicon-pinterest"></i>
			</a>
		</div>
		<div class="topbar-column">
			<a class="hidden-md-down" href="#"><i class="icon-download"></i>&nbsp;
				Soon | Get mobile app </a>

		</div>
	</div>
	<!-- Navbar-->
	<!-- Remove "navbar-sticky" class to make navigation bar scrollable with the page.-->
	<header class="navbar navbar-sticky">
		<!-- Search-->
		<form class="site-search" method="get" action="/store/searchParMc">
			<input type="text" name="site_search" placeholder="Type to search...">
			<div class="search-tools">
				<span class="clear-search">Clear</span><span class="close-search"><i
					class="icon-cross"></i></span>
			</div>
		</form>
		<div class="site-branding">
			<div class="inner">
				<!-- Off-Canvas Toggle (#shop-categories)-->
				<a class="offcanvas-toggle cats-toggle" href="#shop-categories"
					data-toggle="offcanvas"></a>
				<!-- Off-Canvas Toggle (#mobile-menu)-->
				<a class="offcanvas-toggle menu-toggle" href="#mobile-menu"
					data-toggle="offcanvas"></a>
				<!-- Site Logo-->
				<a class="site-logo" href="/store/home"><img
					src="${pageContext.request.contextPath}/resources/img/logo/logo.png"
					alt="Online Store"></a>
			</div>
		</div>
		<!-- Main Navigation-->
		<sec:authorize access="hasRole('VENDEUR_ROLE')">
			<nav class="site-menu">
				<ul>
					<li><a href="/store/vendeur/add-boutique"><span>My
								Shop</span> </a></li>
					<li><a href="/store/vendeur/add-category"><span>Add
								Category</span></a></li>
					<li><a href="/store/vendeur/add-article"><span>Add
								Article</span></a></li>
				</ul>
			</nav>
		</sec:authorize>
		<!-- Toolbar-->
		<div class="toolbar">
			<div class="inner">
				<div class="tools">
					<div class="search">
						<i class="icon-search"></i>
					</div>
					<div class="account">


						<sec:authorize access="isAuthenticated()">
							<a href="/store/profile"></a>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							<a href="/store/login"></a>
						</sec:authorize>
						<i class="icon-head"></i>
						<ul class="toolbar-dropdown">
							<sec:authorize access="hasRole('CLIENT_ROLE')">
								<li class="sub-menu-user">
									
									<div class="user-info">
										<h6 class="user-name">
											<sec:authorize access="isAuthenticated()">
												<sec:authentication property="principal.username" />
											</sec:authorize>
										</h6>
										<span class="text-xs text-muted"> <sec:authorize
												access="hasRole('VENDEUR_ROLE')">
										Vendeur
										</sec:authorize> <sec:authorize access="!hasRole('VENDEUR_ROLE')">
										Client
										</sec:authorize>
										</span>
									</div>
								</li>
								<li><a href="/store/profile">My Profile</a></li>
								
								<li><a href="/store/profile-wishlist">Wishlist</a></li>
								<li class="sub-menu-separator"></li>
								<li><a href="<c:url value='/j_spring_security_logout'/>">
										<i class="icon-unlock"></i>Logout
								</a></li>
							</sec:authorize>
							<sec:authorize access="isAnonymous()">
								<li><a href="<c:url value='/login'/>"> <i
										class="icon-lock"></i>Login/Inscription

								</a></li>
							</sec:authorize>
						</ul>

					</div>
					<div class="cart">
						<a href="/store/profile-cart"></a><i class="icon-bag"></i>
						<div class="toolbar-dropdown">

							<div class="toolbar-dropdown-group">

								<div class="column">
									<a class="btn btn-sm btn-block btn-success"
										href="/store/profile-cart">View Cart</a>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</header>


	<c:if test="${not empty message}">
		<div class="alert alert-info alert-dismissible fade show text-center">
			<span class="alert-close" data-dismiss="alert"></span> <i
				class="icon-layers"></i>&nbsp;&nbsp; <strong>Info alert:</strong>
			${message }
		</div>
	</c:if>