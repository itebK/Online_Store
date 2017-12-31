<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />



<!-- Off-Canvas Wrapper-->
<div class="offcanvas-wrapper">
	<!-- Page Content-->
	<!-- Main Slider-->
	<section class="hero-slider"
		style="background-image: url(${pageContext.request.contextPath}/resources/img/hero-slider/main-bg.jpg);">
		<div class="owl-carousel large-controls dots-inside"
			data-owl-carousel="{ &quot;nav&quot;: true, &quot;dots&quot;: true, &quot;loop&quot;: true, &quot;autoplay&quot;: true, &quot;autoplayTimeout&quot;: 7000 }">
			<div class="item">
				<div class="container padding-top-3x">
					<div class="row justify-content-center align-items-center">
						<div
							class="col-lg-5 col-md-6 padding-bottom-2x text-md-left text-center">
							<div class="from-bottom">
								<img class="d-inline-block w-150 mb-4"
									src="${pageContext.request.contextPath}/resources/img/hero-slider/logo02.png"
									alt="Puma">
								<div class="h2 text-body text-normal mb-2 pt-1">Puma
									Backpacks Collection</div>
								<div class="h2 text-body text-normal mb-4 pb-1">
									starting at <span class="text-bold">$37.99</span>
								</div>
							</div>
							<a class="btn btn-primary scale-up delay-1"
								href="/store/client/product-by-category">View Offers</a>
						</div>
						<div class="col-md-6 padding-bottom-2x mb-3">
							<img class="d-block mx-auto"
								src="${pageContext.request.contextPath}/resources/img/hero-slider/02.png"
								alt="Puma Backpack">
						</div>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="container padding-top-3x">
					<div class="row justify-content-center align-items-center">
						<div
							class="col-lg-5 col-md-6 padding-bottom-2x text-md-left text-center">
							<div class="from-bottom">
								<img class="d-inline-block w-200 mb-4"
									src="${pageContext.request.contextPath}/resources/img/hero-slider/logo01.png"
									alt="Converse">
								<div class="h2 text-body text-normal mb-2 pt-1">Chuck
									Taylor All Star II</div>
								<div class="h2 text-body text-normal mb-4 pb-1">
									for only <span class="text-bold">$59.99</span>
								</div>
							</div>
							<a class="btn btn-primary scale-up delay-1"
								href="/store/client/single-product">Shop Now</a>
						</div>
						<div class="col-md-6 padding-bottom-2x mb-3">
							<img class="d-block mx-auto"
								src="${pageContext.request.contextPath}/resources/img/hero-slider/01.png"
								alt="Chuck Taylor All Star II">
						</div>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="container padding-top-3x">
					<div class="row justify-content-center align-items-center">
						<div
							class="col-lg-5 col-md-6 padding-bottom-2x text-md-left text-center">
							<div class="from-bottom">
								<img class="d-inline-block mb-4"
									src="${pageContext.request.contextPath}/resources/img/hero-slider/logo03.png"
									style="width: 125px;" alt="Motorola">
								<div class="h2 text-body text-normal mb-2 pt-1">Smart
									Watch Moto 360 2nd</div>
								<div class="h2 text-body text-normal mb-4 pb-1">
									for only <span class="text-bold">$299.99</span>
								</div>
							</div>
							<a class="btn btn-primary scale-up delay-1"
								href="/store/client/single-product">Shop Now</a>
						</div>
						<div class="col-md-6 padding-bottom-2x mb-3">
							<img class="d-block mx-auto"
								src="${pageContext.request.contextPath}/resources/img/hero-slider/03.png"
								alt="Moto 360">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Top Categories-->
	<section class="container padding-top-3x">
		<h3 class="text-center mb-30">Top Categories</h3>
		<div class="row">
		<c:forEach items="${categories}" var="cat">
			<div class="col-md-4 col-sm-6">
			
				<div class="card mb-30">
					<a class="card-img-tiles" href="/store/client/product-by-category">
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
						<p class="text-muted">Starting from $49.99</p>
						<a class="btn btn-outline-primary btn-sm" href="/store/client/product-by-category">View
							Products</a>
					</div>
				</div>
			
			</div>
		</c:forEach>
		</div>
		<div class="text-center">
			<a class="btn btn-outline-secondary margin-top-none"
				href="/store/client/category-product">All Categories</a>
		</div>
	</section>
	
	<!-- Featured Products Carousel-->
	<section class="container padding-top-3x padding-bottom-3x">
		<h3 class="text-center mb-30">Featured Products</h3>
		<div class="owl-carousel"
			data-owl-carousel="{ &quot;nav&quot;: false, &quot;dots&quot;: true, &quot;margin&quot;: 30, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:1},&quot;576&quot;:{&quot;items&quot;:2},&quot;768&quot;:{&quot;items&quot;:3},&quot;991&quot;:{&quot;items&quot;:4},&quot;1200&quot;:{&quot;items&quot;:4}} }">
			<c:forEach items="${articles}" var="a">
			<!-- Product-->
			<div class="grid-item">
				<div class="product-card">
					<div class="product-badge text-danger">${a.quantite} remain in Stock</div>
					<a class="product-thumb" href="/store/client/single-product"><c:if test="${a.idArticle!=null}">
             				<img src="photoArt?idArt=${a.idArticle }" alt="Product"/>
           			</c:if></a>
					<h3 class="product-title">
						<a href="/store/client/single-product">${a.designation }</a>
					</h3>
					<h4 class="product-price">
						
						${a.prix }TND
					</h4>
					<div class="product-buttons">
						<button class="btn btn-outline-secondary btn-sm btn-wishlist"
							data-toggle="tooltip" title="Whishlist">
							<i class="icon-heart"></i>
						</button>
						<button class="btn btn-outline-primary btn-sm" data-toast
							data-toast-type="success" data-toast-position="topRight"
							data-toast-icon="icon-circle-check" data-toast-title="Product"
							data-toast-message="successfuly added to cart!">Add to
							Cart</button>
					</div>
				</div>
			</div>
</c:forEach>    
      


		</div>
	</section>
	
	<!-- Popular Brands-->
	<section class="bg-faded padding-top-3x padding-bottom-3x">
		<div class="container">
			<h3 class="text-center mb-30 pb-2">Popular Brands</h3>
			<div class="owl-carousel"
				data-owl-carousel="{ &quot;nav&quot;: false, &quot;dots&quot;: false, &quot;loop&quot;: true, &quot;autoplay&quot;: true, &quot;autoplayTimeout&quot;: 4000, &quot;responsive&quot;: {&quot;0&quot;:{&quot;items&quot;:2}, &quot;470&quot;:{&quot;items&quot;:3},&quot;630&quot;:{&quot;items&quot;:4},&quot;991&quot;:{&quot;items&quot;:5},&quot;1200&quot;:{&quot;items&quot;:6}} }">
				<img class="d-block w-110 opacity-75 m-auto"
					src="${pageContext.request.contextPath}/resources/img/brands/01.png"
					alt="Adidas"><img class="d-block w-110 opacity-75 m-auto"
					src="${pageContext.request.contextPath}/resources/img/brands/02.png"
					alt="Brooks"><img class="d-block w-110 opacity-75 m-auto"
					src="${pageContext.request.contextPath}/resources/img/brands/03.png"
					alt="Valentino"><img class="d-block w-110 opacity-75 m-auto"
					src="${pageContext.request.contextPath}/resources/img/brands/04.png"
					alt="Nike"><img class="d-block w-110 opacity-75 m-auto"
					src="${pageContext.request.contextPath}/resources/img/brands/05.png"
					alt="Puma"><img class="d-block w-110 opacity-75 m-auto"
					src="${pageContext.request.contextPath}/resources/img/brands/06.png"
					alt="New Balance"><img
					class="d-block w-110 opacity-75 m-auto"
					src="${pageContext.request.contextPath}/resources/img/brands/07.png"
					alt="Dior">
			</div>
		</div>
	</section>
	<!-- Services-->
	<section class="container padding-top-3x padding-bottom-2x">
		<div class="row">
			<div class="col-md-3 col-sm-6 text-center mb-30">
				<img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3"
					src="${pageContext.request.contextPath}/resources/img/services/01.png"
					alt="Shipping">
				<h6>Free Worldwide Shipping</h6>
				<p class="text-muted margin-bottom-none">Free shipping for all
					orders over $100</p>
			</div>
			<div class="col-md-3 col-sm-6 text-center mb-30">
				<img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3"
					src="${pageContext.request.contextPath}/resources/img/services/02.png"
					alt="Money Back">
				<h6>Money Back Guarantee</h6>
				<p class="text-muted margin-bottom-none">We return money within
					30 days</p>
			</div>
			<div class="col-md-3 col-sm-6 text-center mb-30">
				<img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3"
					src="${pageContext.request.contextPath}/resources/img/services/03.png"
					alt="Support">
				<h6>24/7 Customer Support</h6>
				<p class="text-muted margin-bottom-none">Friendly 24/7 customer
					support</p>
			</div>
			<div class="col-md-3 col-sm-6 text-center mb-30">
				<img class="d-block w-90 img-thumbnail rounded-circle mx-auto mb-3"
					src="${pageContext.request.contextPath}/resources/img/services/04.png"
					alt="Payment">
				<h6>Secure Online Payment</h6>
				<p class="text-muted margin-bottom-none">We posess SSL / Secure
					Certificate</p>
			</div>
		</div>
	</section>

</div>



	<jsp:include page="footer.jsp" />