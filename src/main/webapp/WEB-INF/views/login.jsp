<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<jsp:include page="header.jsp" />




    <!-- Off-Canvas Wrapper-->
    <div class="offcanvas-wrapper">
      <!-- Page Title-->
      <div class="page-title">
        <div class="container">
          <div class="column">
            <h1>Login / Register Account</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="home">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="profile">Account</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>Login / Register</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-2">
        <div class="row">
          <div class="col-md-6">
            <form class="login-box" method="post" action="j_spring_security_check">
              <div class="row margin-bottom-1x">
                <div class="col-xl-4 col-md-6 col-sm-4"><a class="btn btn-sm btn-block facebook-btn" href="#"><i class="socicon-facebook"></i>&nbsp;Facebook login</a></div>
                <div class="col-xl-4 col-md-6 col-sm-4"><a class="btn btn-sm btn-block twitter-btn" href="#"><i class="socicon-twitter"></i>&nbsp;Twitter login</a></div>
                <div class="col-xl-4 col-md-6 col-sm-4"><a class="btn btn-sm btn-block google-btn" href="#"><i class="socicon-googleplus"></i>&nbsp;Google+ login</a></div>
              </div>
              <h4 class="margin-bottom-1x">Or using form below</h4>
              <div class="form-group input-group">
                <input class="form-control" type="text" placeholder="Email" name="j_username" required>
                <span class="input-group-addon"><i class="icon-mail"></i></span>
              </div>
              <div class="form-group input-group">
                <input class="form-control" type="password" placeholder="Password"  name="j_password" required><span class="input-group-addon"><i class="icon-lock"></i></span>
              </div>
              <div class="d-flex flex-wrap justify-content-between padding-bottom-1x">
                <label class="custom-control custom-checkbox">
                  <input class="custom-control-input" type="checkbox" checked><span class="custom-control-indicator"></span><span class="custom-control-description">Remember me</span>
                </label><a class="navi-link" href="recovery-password">Forgot password?</a>
              </div>
              <div class="text-center text-sm-right">
                <button class="btn btn-primary margin-bottom-none" type="submit" value="Login">Login</button>
              </div>
            </form>
          </div>
          <div class="col-md-6">
            <div class="padding-top-3x hidden-md-up"></div>
            <h3 class="margin-bottom-1x">No Account? Register</h3>
            <p>Registration takes less than a minute but gives you full control over your orders.</p>
            <f:form modelAttribute="user" class="row" method="post" action="saveUser">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-fn">Username</label>
                  <f:input class="form-control" type="text" id="reg-fn" path="username" required="required"/>
                  <f:errors path="username"></f:errors>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-ln">User Type</label>
                 
                  <f:select path="roles" class="form-control">
				  	<f:option value="VENDEUR_ROLE" label="VENDEUR" />
				  	<f:option value="CLIENT_ROLE" label="CLIENT" />
			    	</f:select>
			    	<f:errors path="roles"></f:errors>
                 
                </div>
              </div>
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
              <div class="col-12 text-center text-sm-right">
                <button class="btn btn-primary margin-bottom-none" type="submit">Register</button>
              </div>
            </f:form>
          </div>
        </div>
      </div>
      </div>




<jsp:include page="footer.jsp" />

