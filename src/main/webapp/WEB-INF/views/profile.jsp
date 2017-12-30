<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

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
              <li><a href="home">Home</a>
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
							title="You currently have 290 Reward Points to spend">
							<i class="icon-medal"></i>290 points
						</div>
					</div>
					<div class="user-info">
                <div class="user-avatar"><a class="edit-avatar" href="#"></a><img src="${pageContext.request.contextPath}/resources/img/account/user-ava.jpg" alt="User"></div>
                <div class="user-data">
                  <h4>Daniel Adams</h4><span>Joined February 06, 2017</span>
                </div>
              </div>
            </aside>
            
            <nav class="list-group">
            <a class="list-group-item with-badge" href="profile-orders"><i class="icon-bag"></i>
            Orders<span class="badge badge-primary badge-pill">6</span></a>
            <a class="list-group-item active" href="profile"><i class="icon-head"></i>
            Profile</a><a class="list-group-item" href="profile-address"><i class="icon-map"></i>
            Addresses</a><a class="list-group-item with-badge" href="profile-wishlist"><i class="icon-heart"></i>
            Wishlist<span class="badge badge-primary badge-pill">3</span></a>
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
            
            
            
            
           <!--   <form class="row">
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-fn">First Name</label>
                  <input class="form-control" type="text" id="account-fn" value="Daniel" required>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-ln">Last Name</label>
                  <input class="form-control" type="text" id="account-ln" value="Adams" required>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-email">E-mail Address</label>
                  <input class="form-control" type="email" id="account-email" value="daniel.adams@mail.com" disabled>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-phone">Phone Number</label>
                  <input class="form-control" type="text" id="account-phone" value="+7(805) 348 95 72" required>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-pass">New Password</label>
                  <input class="form-control" type="password" id="account-pass">
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label for="account-confirm-pass">Confirm Password</label>
                  <input class="form-control" type="password" id="account-confirm-pass">
                </div>
              </div>
              <div class="col-12">
                <hr class="mt-2 mb-3">
                <div class="d-flex flex-wrap justify-content-between align-items-center">
                  <label class="custom-control custom-checkbox d-block">
                    <input class="custom-control-input" type="checkbox" checked><span class="custom-control-indicator"></span><span class="custom-control-description">Subscribe me to Newsletter</span>
                  </label>
                  <button class="btn btn-primary margin-right-none" type="button" data-toast data-toast-position="topRight" data-toast-type="success" data-toast-icon="icon-circle-check" data-toast-title="Success!" data-toast-message="Your profile updated successfuly.">Update Profile</button>
                </div>
              </div>
            </form>-->
          </div>
        </div>
      </div>
      



<jsp:include page="footer.jsp" />
