<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<jsp:include page="header.jsp" />





    <!-- Off-Canvas Wrapper-->
    <div class="offcanvas-wrapper">
      <!-- Page Content-->
      <div class="container padding-top-3x padding-bottom-3x mb-1">
              <div class="col-md-6">
            <div class="padding-top-3x hidden-md-up"></div>
            <h3 class="margin-bottom-1x">Add Category</h3>
            <f:form modelAttribute="categorie" class="row" method="post" enctype="multipart/form-data" action="saveCat">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-fn">Category Name</label>
                  <f:input class="form-control" type="text" id="reg-fn" path="nomCategorie" required="required"/>
                  <f:errors path="nomCategorie"></f:errors>
                </div>
              </div>
              
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-email">Description</label>
                  <f:input class="form-control" type="text"  path="description" required="required"/>
                  <f:errors path="description"></f:errors>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-phone">Picture</label>
                  <input class="form-control" type="file" name="file"/>
                </div>
              </div>
              <div class="col-12 text-center text-sm-right">
                <button class="btn btn-primary margin-bottom-none" type="submit">Add Category</button>
              </div>
            </f:form>
          </div>
      
      
      </div>
      </div>
      




<jsp:include page="footer.jsp" />
