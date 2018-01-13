<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />


    <!-- Off-Canvas Wrapper-->
    <div class="offcanvas-wrapper">
      <!-- Page Title-->
      <div class="page-title">
        <div class="container">
          <div class="column">
            <h1>${article.designation }</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="/store/home">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="/store/client/product-by-category">Shop</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>${article.designation }</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-1">
        <div class="row">
          <!-- Poduct Gallery-->
          <div class="col-md-6">
            <div class="product-gallery"><span class="product-badge text-danger"></span>
              <div class="gallery-wrapper">
                <div class="gallery-item active"><a href="photoArt?idArt=${article.idArticle }" data-hash="one" data-size="1000x667"></a></div>
               </div>
              <div class="product-carousel owl-carousel">
                <div data-hash=""><img src="photoArt?idArt=${article.idArticle }" alt="Product"></div>
                </div>
              <ul class="product-thumbnails">
                <li class="active"><a href="#"><img src="photoArt?idArt=${article.idArticle}" alt="Product"></a></li>
               </ul>
            </div>
          </div>
          <!-- Product Info-->
          <div class="col-md-6">
            <div class="padding-top-2x mt-2 hidden-md-up"></div>
              <div class="rating-stars"><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star filled"></i><i class="icon-star"></i>
              </div><span class="text-muted align-middle">&nbsp;&nbsp;4.2 | 3 customer reviews</span>
            <h2 class="padding-top-1x text-normal">${article.designation }</h2>
            <span class="h2 d-block">${article.prix }TND</span>
            <p>${article.description }</p>
            <div class="row margin-top-1x">
   
              <div class="col-sm-3">
                <div class="form-group">
                  <label for="quantity">Quantity</label>
                  <select class="form-control" id="quantity">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                  </select>
                </div>
              </div>
            </div>
            
            
            <hr class="mb-3">
            <div class="d-flex flex-wrap justify-content-between">
              <div class="entry-share mt-2 mb-2"><span class="text-muted">Share:</span>
                <div class="share-links"><a class="social-button shape-circle sb-facebook" href="#" data-toggle="tooltip" data-placement="top" title="Facebook"><i class="socicon-facebook"></i></a><a class="social-button shape-circle sb-twitter" href="#" data-toggle="tooltip" data-placement="top" title="Twitter"><i class="socicon-twitter"></i></a><a class="social-button shape-circle sb-instagram" href="#" data-toggle="tooltip" data-placement="top" title="Instagram"><i class="socicon-instagram"></i></a><a class="social-button shape-circle sb-google-plus" href="#" data-toggle="tooltip" data-placement="top" title="Google +"><i class="socicon-googleplus"></i></a></div>
              </div>
              <div class="sp-buttons mt-2 mb-2">
                <a class="btn btn-outline-secondary btn-sm btn-wishlist" data-toggle="tooltip" title="Whishlist" href="/store/add-to-wishlist?idArt=${article.idArticle }"><i class="icon-heart"></i></a>
                <a class="btn btn-primary" data-toast data-toast-type="success" data-toast-position="topRight" data-toast-icon="icon-circle-check" data-toast-title="Product" data-toast-message="successfuly added to cart!" href="/store/add-to-cart?idArt=${article.idArticle }"><i class="icon-bag"></i> Add to Cart</a>
              </div>
            </div>
          </div>
        </div>

        
      </div>
      




<jsp:include page="footer.jsp" />