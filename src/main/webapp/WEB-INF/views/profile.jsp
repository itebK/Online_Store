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
            <h1>My Profile</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="/store/home">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>My Profile</li>
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
  
            <a class="list-group-item active" href="/store/profile"><i class="icon-head"></i>
            Profile</a>
<a class="list-group-item with-badge" href="/store/profile-wishlist"><i class="icon-heart"></i>
            Wishlist<span class="badge badge-primary badge-pill">${favoris.size() }</span></a>
   			</nav>
   			
          </div>
          <div class="col-lg-8">
            <div class="padding-top-2x mt-2 hidden-lg-up"></div>
            
            
                        <f:form modelAttribute="user" class="row" method="post" action="saveUser">
              
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-fn">Username</label>
                  <f:input class="form-control" type="text" id="reg-fn" path="username" disabled= "${true}"/>
                  <f:errors path="username"></f:errors>
                </div>
              </div>
             <!--   <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-ln">User Type</label>
                  <f:select class="form-control" path="roles" items="${user.roles}" itemValue="nomRole" itemLabel="nomRole" >
                  </f:select>
                </div>
              </div>-->
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-email">E-mail Address</label>
                  <f:input class="form-control" type="email" id="reg-email" path="email" required="required"/>
                  <f:errors path="email"></f:errors>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-phone">Phone Number</label>
                  <f:input class="form-control" type="text" id="reg-phone" path="tel" required="required"/>
                  <f:errors path="tel"></f:errors>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-pass">Password</label>
                  <f:input class="form-control" type="password" id="reg-pass" path="password" required="required"/>
                  <f:errors path="password"></f:errors>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-pass-confirm">Confirm Password</label>
                  <input class="form-control" type="password" id="reg-pass-confirm" required="required">
                  
                </div>
              </div>
                         <div class="col-sm-6">
                <div class="form-group">
                 
                  <f:input class="form-control" type="text" id="reg-fn" path="idUser" hidden="hidden"/>
                  
                </div>
              </div>
              <div class="col-12 text-center text-sm-right">
                <button class="btn btn-primary margin-bottom-none" type="submit">Update Profile</button>
              </div>
            </f:form>
            
            
      
          </div>
        </div>
      </div>
      



<jsp:include page="footer.jsp" />
