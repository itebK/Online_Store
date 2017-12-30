<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<jsp:include page="header.jsp" />


    <!-- Off-Canvas Wrapper-->
    <div class="offcanvas-wrapper">
      <!-- Page Content-->
      <div class="container padding-top-3x padding-bottom-3x mb-1">
              <div class="col-md-6">
            <div class="padding-top-3x hidden-md-up"></div>
            <h3 class="margin-bottom-1x">Add Shop</h3>
            <f:form modelAttribute="boutique" class="row" method="post" action="saveBout">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-fn">Shop Name</label>
                  <f:input class="form-control" type="text" id="reg-fn" path="nomBoutique" required="required"/>
                  <f:errors path="nomBoutique"></f:errors>
                </div>
              </div>
              
              <div class="col-12 text-center text-sm-right">
              <c:choose>
    <c:when test="${empty boutiques}">
       <button class="btn btn-primary margin-bottom-none" type="submit">Add Shop</button>
    </c:when>
    <c:otherwise>
       <button class="btn btn-primary margin-bottom-none" type="submit" disabled>You already have a Shop</button>
    </c:otherwise>
</c:choose>
                
              </div>
            </f:form>
          </div>
      
      
      </div>
      </div>
      




<jsp:include page="footer.jsp" />
