<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<jsp:include page="header.jsp" />





    <!-- Off-Canvas Wrapper-->
    <div class="offcanvas-wrapper">
      <!-- Page Content-->
      <div class="container padding-top-3x padding-bottom-3x mb-1">
              <div class="col-md-6">
            <div class="padding-top-3x hidden-md-up"></div>
            <h3 class="margin-bottom-1x">Edit Product</h3>
            <f:form modelAttribute="article" class="row" method="post" enctype="multipart/form-data" action="saveArt">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-fn">Product Description</label>
                  <f:input class="form-control" type="text" id="reg-fn" path="description" required="required"/>
                  <f:errors path="description"></f:errors>
                </div>
              </div>
              
              
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-email">Category</label>
                 	<f:select class="form-control" path="categorie.idCategorie" items="${categories}" itemValue="idCategorie" itemLabel="nomCategorie"></f:select>
                </div>
              </div>
              
              
              
              
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-email">Designation</label>
                  <f:input class="form-control" type="text"  path="designation" required="required"/>
                  <f:errors path="designation"></f:errors>
                </div>
              </div>
           
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-email">Price</label>
                  <f:input class="form-control" type="text"  path="prix" required="required"/>
                  <f:errors path="prix"></f:errors>
                </div>
              </div>
              
                 <div class="col-sm-6">
                <div class="form-group">
                  <label for="reg-email">Quantity</label>
                  <f:input class="form-control" type="text"  path="quantite" required="required"/>
                  <f:errors path="quantite"></f:errors>
                </div>
              </div>   
              
              
              <div class="col-sm-6">
              <label for="reg-phone">Picture</label>
                <div class="custom-file">
                  <input class="custom-file-input" type="file" name="file"/><span class="custom-file-control"></span>
                </div>
              </div>
             <f:input class="form-control" type="text"  path="idArticle" hidden="hidden"/>
             <f:input class="form-control" type="text"  path="boutique.idBoutique" hidden="hidden"/>
              <div class="col-12 text-center text-sm-right">
                <button class="btn btn-primary margin-bottom-none" type="submit">Save Product</button>
              </div>
            </f:form>
          </div>
      
      
      </div>
      </div>
      




<jsp:include page="footer.jsp" />
