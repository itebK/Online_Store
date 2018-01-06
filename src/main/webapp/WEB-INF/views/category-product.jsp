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
					<li><a href="/store/home">Home</a></li>
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
			<div class="col-xl-12 col-lg-8 order-lg-2">
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
					<c:forEach items="${categories}" var="cat">
					<div class="col-sm-4">
						<div class="card mb-30">
							<a class="card-img-tiles" href="/store/client/product-by-category?idCat=${cat.idCategorie }">
								<div class="inner">
							<div class="main-img">
							
							 <c:if test="${cat.idCategorie!=null}">
             				<img src="photoCat?idCat=${cat.idCategorie }" alt="Category"/>
           					</c:if>
								
							</div>
							
						</div>
							</a>
							<div class="card-body text-center">
								<h4 class="card-title">${cat.nomCategorie}</h4>
								
								<a class="btn btn-outline-primary btn-sm"
									href="/store/client/product-by-category?idCat=${cat.idCategorie }">View Products</a>
							</div>
						</div>
					</div>
</c:forEach>

				</div>
			</div>
	
	
		</div>
	</div>




	<jsp:include page="footer.jsp" />