<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />


    <div class="offcanvas-wrapper">
      <!-- Page Title-->
      <div class="page-title">
        <div class="container">
          <div class="column">
            <h1>My Orders</h1>
          </div>
          <div class="column">
            <ul class="breadcrumbs">
              <li><a href="home">Home</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li><a href="profile">Account</a>
              </li>
              <li class="separator">&nbsp;</li>
              <li>My Orders</li>
            </ul>
          </div>
        </div>
      </div>
      <!-- Page Content-->
      <div class="container padding-bottom-3x mb-2">
        <div class="row">
          <div class="col-lg-4">
            <aside class="user-info-wrapper">
              <div class="user-cover" style="background-image: url(${pageContext.request.contextPath}/resources/img/account/user-cover-img.jpg);">
                <div class="info-label" data-toggle="tooltip" title="You currently have 290 Reward Points to spend"><i class="icon-medal"></i>290 points</div>
              </div>
              <div class="user-info">
                <div class="user-avatar"><a class="edit-avatar" href="#"></a><img src="${pageContext.request.contextPath}/resources/img/account/user-ava.jpg" alt="User"></div>
                <div class="user-data">
                  <h4>Daniel Adams</h4><span>Joined February 06, 2017</span>
                </div>
              </div>
            </aside>
           
          <nav class="list-group">
            <a class="list-group-item with-badge active" href="profile-orders"><i class="icon-bag"></i>
            Orders<span class="badge badge-primary badge-pill">6</span></a>
            <a class="list-group-item" href="profile"><i class="icon-head"></i>
            Profile</a><a class="list-group-item" href="profile-address"><i class="icon-map"></i>
            Addresses</a><a class="list-group-item with-badge" href="profile-wishlist"><i class="icon-heart"></i>
            Wishlist<span class="badge badge-primary badge-pill">3</span></a>
   			</nav>

          </div>
          <div class="col-lg-8">
            <div class="padding-top-2x mt-2 hidden-lg-up"></div>
            <div class="table-responsive">
              <table class="table table-hover margin-bottom-none">
                <thead>
                  <tr>
                    <th>Order #</th>
                    <th>Date Purchased</th>
                    <th>Status</th>
                    <th>Total</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><a class="text-medium navi-link" href="#" data-toggle="modal" data-target="#orderDetails">78A643CD409</a></td>
                    <td>August 08, 2017</td>
                    <td><span class="text-danger">Canceled</span></td>
                    <td><span class="text-medium">$760.50</span></td>
                  </tr>
                  <tr>
                    <td><a class="text-medium navi-link" href="#" data-toggle="modal" data-target="#orderDetails">34VB5540K83</a></td>
                    <td>July 21, 2017</td>
                    <td><span class="text-info">In Progress</span></td>
                    <td><span class="text-medium">$315.20</span></td>
                  </tr>
                  <tr>
                    <td><a class="text-medium navi-link" href="#" data-toggle="modal" data-target="#orderDetails">112P45A90V2</a></td>
                    <td>June 15, 2017</td>
                    <td><span class="text-warning">Delayed</span></td>
                    <td><span class="text-medium">$1,264.00</span></td>
                  </tr>
                  <tr>
                    <td><a class="text-medium navi-link" href="#" data-toggle="modal" data-target="#orderDetails">28BA67U0981</a></td>
                    <td>May 19, 2017</td>
                    <td><span class="text-success">Delivered</span></td>
                    <td><span class="text-medium">$198.35</span></td>
                  </tr>
                  <tr>
                    <td><a class="text-medium navi-link" href="#" data-toggle="modal" data-target="#orderDetails">502TR872W2</a></td>
                    <td>April 04, 2017</td>
                    <td><span class="text-success">Delivered</span></td>
                    <td><span class="text-medium">$2,133.90</span></td>
                  </tr>
                  <tr>
                    <td><a class="text-medium navi-link" href="#" data-toggle="modal" data-target="#orderDetails">47H76G09F33</a></td>
                    <td>March 30, 2017</td>
                    <td><span class="text-success">Delivered</span></td>
                    <td><span class="text-medium">$86.40</span></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <hr>
            <div class="text-right"><a class="btn btn-link-primary margin-bottom-none" href="#"><i class="icon-download"></i>&nbsp;Order Details</a></div>
          </div>
        </div>
      </div>
      




<jsp:include page="footer.jsp" />