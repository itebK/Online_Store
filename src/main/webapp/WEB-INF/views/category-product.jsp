<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />

<div class="offcanvas-wrapper">
	<!-- Page Title-->
	<div class="page-title">
		<div class="container">
			<div class="column">
				<h1>Shop Categories</h1>
			</div>
			<div class="column">
				<ul class="breadcrumbs">
					<li><a href="home">Home</a></li>
					<li class="separator">&nbsp;</li>
					<li>Shop Categories</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- Page Content-->
	<div class="container padding-bottom-2x mb-2">
		<div class="row">
			<!-- Categories-->
			<div class="col-xl-9 col-lg-8 order-lg-2">
				<!-- Promo banner-->
				<div
					class="alert alert-image-bg alert-dismissible fade show text-center mb-4"
					style="background-image: url(${pageContext.request.contextPath}/resources/img/banners/alert-bg.jpg);">
					<span class="alert-close text-white" data-dismiss="alert"></span>
					<div
						class="h3 text-medium text-white padding-top-1x padding-bottom-1x">
						<i class="icon-clock" style="font-size: 33px; margin-top: -5px;"></i>&nbsp;&nbsp;Check
						our Limited Offers. Save up to 50%&nbsp;&nbsp;&nbsp;
						<div class="mt-3 hidden-xl-up"></div>
						<a class="btn btn-primary" href="#">View Offers</a>
					</div>
				</div>
				<div class="row">
					<!-- Categories-->
					<div class="col-sm-6">
						<div class="card mb-30">
							<a class="card-img-tiles" href="product-by-category">
								<div class="inner">
									<div class="main-img">
										<img
											src="${pageContext.request.contextPath}/resources/img/shop/categories/16.jpg"
											alt="Category">
									</div>
									<div class="thumblist">
										<img
											src="${pageContext.request.contextPath}/resources/img/shop/categories/17.jpg"
											alt="Category"><img
											src="${pageContext.request.contextPath}/resources/img/shop/categories/18.jpg"
											alt="Category">
									</div>
								</div>
							</a>
							<div class="card-body text-center">
								<h4 class="card-title">Watches</h4>
								<p class="text-muted">Starting from $79.99</p>
								<a class="btn btn-outline-primary btn-sm"
									href="product-by-category">View Products</a>
							</div>
						</div>
					</div>


				</div>
			</div>
			<!-- Sidebar          -->
			<div class="col-xl-3 col-lg-4 order-lg-1">
				<aside class="sidebar">
					<div class="padding-top-2x hidden-lg-up"></div>
					<section class="widget widget-categories">
						<h3 class="widget-title">Stores</h3>
						<ul>
							<li><a href="#">Adidas</a><span>(254)</span></li>
							<li><a href="#">Bilabong</a><span>(39)</span></li>
							<li><a href="#">Brooks</a><span>(205)</span></li>
						</ul>
					</section>
				</aside>
			</div>
		</div>
	</div>




	<jsp:include page="footer.jsp" />