<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />




    <div class="offcanvas-wrapper">
      <!-- Page Title-->
      <div class="page-title">
        <div class="container">
          <div class="column">
            <h1>Search Results for: Lorem ipsum</h1>
          </div>
          <div class="column">
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-2">
        <div class="row">
          <!-- Results-->
          <div class="col-xl-9 col-lg-8">
            <div class="card mb-4">
              <div class="card-header"><span class="badge badge-pill badge-primary">Product</span></div>
              <div class="card-body">
                <div class="d-flex"><a class="pr-4 hidden-xs-down" href="/store/client/single-product" style="max-width: 225px;"><img src="${pageContext.request.contextPath}/resources/img/shop/products/01.jpg" alt="Product"></a>
                  <div>
                    <h5><a class="navi-link" href="/store/client/single-product">Unionbay Park </a></h5>
                    <h6>
                      <del class="text-muted">$99.99</del> $49.99
                    </h6>
                    <p>Consequatur omnis <span class='text-highlighted'>lorem ipsum</span> reprehenderit suscipit voluptatem blanditiis aliquid rerum animi aliquam, dicta quas nesciunt commodi sequi minima totam architecto.</p>
                  </div>
                </div>
              </div>
            </div>
      

            <div class="card mb-4">
              <div class="card-header"><span class="badge badge-pill badge-primary">Product</span></div>
              <div class="card-body">
                <div class="d-flex"><a class="pr-4 hidden-xs-down" href="/store/client/single-product" style="max-width: 225px;"><img src="${pageContext.request.contextPath}/resources/img/shop/products/03.jpg" alt="Product"></a>
                  <div>
                    <h5><a class="navi-link" href="/store/client/single-product">Oakley Kickback</a></h5>
                    <h6>$155.00</h6>
                    <p>Ut enim ad minim veniam, <span class='text-highlighted'>lorem ipsum</span> reprehenderit suscipit voluptatem blanditiis aliquid rerum animi aliquam, dicta quas nesciunt commodi sequi minima totam architecto.</p>
                  </div>
                </div>
              </div>
            </div>
       

            <!-- Pagination-->
            <nav class="pagination">
              <div class="column">
                <ul class="pages">
                  <li class="active"><a href="#">1</a></li>
                  <li><a href="#">2</a></li>
                  <li><a href="#">3</a></li>
                  <li><a href="#">4</a></li>
                  <li>...</li>
                  <li><a href="#">12</a></li>
                </ul>
              </div>
              <div class="column text-right hidden-xs-down"><a class="btn btn-outline-secondary btn-sm" href="#">Next&nbsp;<i class="icon-arrow-right"></i></a></div>
            </nav>
          </div>
          <!-- Sidebar          -->
          <div class="col-xl-3 col-lg-4">
            <aside class="sidebar">
              <div class="padding-top-2x hidden-lg-up"></div>
              <!-- Shop Categories-->
              <section class="widget widget-categories">
                <h3 class="widget-title">Shop Categories</h3>
                <ul>
                  <li class="has-children expanded"><a href="#">Shoes</a><span>(1138)</span>
                    <ul>
                      <li><a href="#">Women's</a><span>(508)</span>
                        <ul>
                          <li><a href="#">Sneakers</a></li>
                          <li><a href="#">Heels</a></li>
                          <li><a href="#">Loafers</a></li>
                          <li><a href="#">Sandals</a></li>
                        </ul>
                      </li>
                      <li><a href="#">Men's</a><span>(423)</span>
                        <ul>
                          <li><a href="#">Boots</a></li>
                          <li><a href="#">Oxfords</a></li>
                          <li><a href="#">Loafers</a></li>
                          <li><a href="#">Sandals</a></li>
                        </ul>
                      </li>
                      <li><a href="#">Boy's Shoes</a><span>(97)</span></li>
                      <li><a href="#">Girl's Shoes</a><span>(110)</span></li>
                    </ul>
                  </li>
                  <li class="has-children"><a href="#">Clothing</a><span>(2356)</span>
                    <ul>
                      <li><a href="#">Women's</a><span>(1032)</span>
                        <ul>
                          <li><a href="#">Dresses</a></li>
                          <li><a href="#">Shirts &amp; Tops</a></li>
                          <li><a href="#">Swimwear</a></li>
                          <li><a href="#">Shorts</a></li>
                        </ul>
                      </li>
                      <li><a href="#">Men's</a><span>(937)</span>
                        <ul>
                          <li><a href="#">Shirts &amp; Tops</a></li>
                          <li><a href="#">Shorts</a></li>
                          <li><a href="#">Swimwear</a></li>
                          <li><a href="#">Pants</a></li>
                        </ul>
                      </li>
                      <li><a href="#">Kid's Clothing</a><span>(386)</span></li>
                    </ul>
                  </li>
                  <li class="has-children"><a href="#">Bags</a><span>(420)</span>
                    <ul>
                      <li><a href="#">Handbags</a><span>(180)</span></li>
                      <li><a href="#">Backpacks</a><span>(132)</span></li>
                      <li><a href="#">Wallets &amp; Accessories</a><span>(47)</span></li>
                      <li><a href="#">Luggage</a><span>(61)</span></li>
                    </ul>
                  </li>
                  <li class="has-children"><a href="#">Accessories</a><span>(874)</span>
                    <ul>
                      <li><a href="#">Sunglasses</a><span>(211)</span></li>
                      <li><a href="#">Hats</a><span>(195)</span></li>
                      <li><a href="#">Watches</a><span>(159)</span></li>
                      <li><a href="#">Jewelry</a><span>(203)</span></li>
                      <li><a href="#">Belts</a><span>(106)</span></li>
                    </ul>
                  </li>
                </ul>
              </section>
              <!-- Blog Categories-->
              <section class="widget widget-categories margin-bottom-none">
                <h3 class="widget-title">Blog Categories</h3>
                <ul>
                  <li><a href="#">Editor's Choice</a><span>(24)</span></li>
                  <li><a href="#">Fashion</a><span>(12)</span></li>
                  <li><a href="#">Travel</a><span>(5)</span></li>
                  <li><a href="#">Online Shopping</a><span>(7)</span></li>
                  <li><a href="#">Closing Design</a><span>(3)</span></li>
                </ul>
              </section>
            </aside>
          </div>
        </div>
      </div>
     



<jsp:include page="footer.jsp" />