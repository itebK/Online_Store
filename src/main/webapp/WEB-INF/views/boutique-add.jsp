<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<jsp:include page="header.jsp" />


<!-- Off-Canvas Wrapper-->
<div class="offcanvas-wrapper">
	<!-- Page Content-->
	<div class="container padding-top-3x padding-bottom-3x mb-1">
		<c:choose>
			<c:when test="${empty boutiques}">
				<div class="col-md-6">
					<div class="padding-top-3x hidden-md-up"></div>
					<h3 class="margin-bottom-1x">Add Shop</h3>
					<f:form modelAttribute="boutique" class="row" method="post"
						action="saveBout">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="reg-fn">Shop Name</label>
								<f:input class="form-control" type="text" id="reg-fn"
									path="nomBoutique" required="required" />
								<f:errors path="nomBoutique"></f:errors>
							</div>
						</div>

						<div class="col-12 text-center text-sm-right">

							<button class="btn btn-primary margin-bottom-none" type="submit">Add
								Shop</button>

						</div>
					</f:form>
				</div>

			</c:when>




			<c:otherwise>
				<c:choose>
					<c:when test="${empty articleParBoutique}"> 
       
      You don't have articles yet
      </c:when>
					<c:otherwise>

						<h3 class="margin-bottom-1x">My Shop Name :
							${boutiques.nomBoutique }</h3>

						<div class="container padding-bottom-3x mb-1">
							<div class="row">

								<!-- Products-->
								<div class="col-xl-9 col-lg-8 order-lg-2">
									<!-- Products Grid-->
									<div class="isotope-grid cols-3 mb-2">
										<div class="gutter-sizer"></div>
										<div class="grid-sizer"></div>


										<c:forEach items="${articleParBoutique}" var="a">
											<!-- Product-->
											<div class="grid-item">
												<div class="product-card">
													<div class="rating-stars">
														<i class="icon-star filled"></i><i
															class="icon-star filled"></i><i class="icon-star filled"></i><i
															class="icon-star filled"></i><i class="icon-star"></i>
													</div>
													<a class="product-thumb"
														href="/store/client/single-product"> <c:if
															test="${a.idArticle!=null}">
															<img src="photoArt?idArt=${a.idArticle }" alt="Product" />
														</c:if></a>
													<h3 class="product-title">
														<a href="/store/client/single-product">${a.designation }</a>
													</h3>
													<h4 class="product-price">${a.prix }TND</h4>
													<div class="product-buttons">
														<a href='suppArt?idArt=${a.idArticle}'
															class="btn btn-outline-secondary btn-sm btn-wishlist"
															data-toggle="tooltip" title="Remove"> <i
															class="icon-trash"></i>
														</a> <a href="edit-article?idArt=${a.idArticle}" 
														class="btn btn-outline-primary btn-sm">Edit</a>
													</div>
												</div>
											</div>
											<!-- Product-->

										</c:forEach>


									</div>
								</div>

							</div>
						</div>


					</c:otherwise>
				</c:choose>



			</c:otherwise>
		</c:choose>
	</div>
</div>





<jsp:include page="footer.jsp" />
