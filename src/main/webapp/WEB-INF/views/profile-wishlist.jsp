<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<jsp:include page="header.jsp" />


    <!-- Off-Canvas Wrapper-->
    <div class="offcanvas-wrapper">
      <!-- Page Title-->
      <div class="page-title">
        <div class="container">
          <div class="column">
            <h1>My Wishlist</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="/store/home">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="/store/profile">Account</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>My Wishlist</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-2">
        <div class="row">
          <div class="col-lg-4">
               <aside class="user-info-wrapper">
					<div class="user-cover"
						style="background-image: url(${pageContext.request.contextPath}/resources/img/account/user-cover-img.jpg);">
						<div class="info-label" data-toggle="tooltip"
							title="">
							<i class="icon-medal"></i>
							
							nbr cmd
							
							
						</div>
					</div>
					<div class="user-info">
                <div class="user-avatar">
               <f:form modelAttribute="user" method="post" id="form_file" enctype="multipart/form-data" action="saveImgProfile">
                <input  onchange="document.getElementById('form_file').submit()" type="file" class="edit-avatar" name="file"/>
                
                </f:form>
                <img src="photoProfile?idUser=${user.idUser}" width="auto" alt="User"></div>
                <div class="user-data">
                  <h4>${user.getUsername() }</h4>
                  <span>
                  	<sec:authorize access="hasRole('VENDEUR_ROLE')">
						Vendeur
					</sec:authorize>
					<sec:authorize access="!hasRole('VENDEUR_ROLE')">
						Client
					</sec:authorize>
                  </span>
                </div>
              </div>
            </aside>
        
                      <nav class="list-group">
            <a class="list-group-item with-badge" href="/store/profile-orders"><i class="icon-bag"></i>
            Orders<span class="badge badge-primary badge-pill">6</span></a>
            <a class="list-group-item" href="/store/profile"><i class="icon-head"></i>
            Profile</a>
<a class="list-group-item with-badge active" href="/store/profile-wishlist"><i class="icon-heart"></i>
            Wishlist<span class="badge badge-primary badge-pill">3</span></a>
   			</nav>
          </div>
          <div class="col-lg-8">
            <div class="padding-top-2x mt-2 hidden-lg-up"></div>
            <!-- Wishlist Table-->
            <div class="table-responsive wishlist-table margin-bottom-none">
              <table class="table">
                <thead>
                  <tr>
                    <th>Product Name</th>
                    <th class="text-center"><a class="btn btn-sm btn-outline-danger" href="#">Clear Wishlist</a></th>
                  </tr>
                </thead>
                <tbody>
                 
                 
                 <c:forEach items="${favoris}" var="f">
                  <tr>
                    <td>
                      <div class="product-item"><a class="product-thumb" href="/store/client/single-product"><img src="photoArt?idArt=${f.idArticle }" alt="Product"></a>
                        <div class="product-info">
                          <h4 class="product-title"><a href="/store/client/single-product">${f.designation }</a></h4>
                          <div class="text-lg text-medium text-muted">${f.prix } TND</div>
                          
                        </div>
                      </div>
                    </td>
                    <td class="text-center"><a class="remove-from-cart" href="#" data-toggle="tooltip" title="Remove item"><i class="icon-cross"></i></a></td>
                  </tr>
                  </c:forEach>
                  
                  
                  
                </tbody>
              </table>
            </div>
            <hr class="mb-4">
            <label class="custom-control custom-checkbox d-block">
              <input class="custom-control-input" type="checkbox" checked><span class="custom-control-indicator"></span><span class="custom-control-description">Inform me when item from my wishlist is available</span>
            </label>
          </div>
        </div>
      </div>
     




<jsp:include page="footer.jsp" />