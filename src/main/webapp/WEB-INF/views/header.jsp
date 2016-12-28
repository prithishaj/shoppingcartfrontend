<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>

 .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }

    /* Remove the navbar's default rounded borders and increase the bottom margin */
    .navbar {
      margin-bottom: 20;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 15px;
    }
  </style>
</head>
<body>



<div class="">
  <div class="container text-center">
    <h1>Mobile Store</h1>
    <p>just buy it</p>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">

    <div class="">
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#">Home</a></li>
        <li><a href="#">Admin</a></li>
        <li><a href="#">About us</a></li>
        <li><a href="#">Contact us</a></li>
        <li><a href="#">Products</a></li>
       </ul>
  <ul class="nav navbar-nav navbar-center">      
        <form class="navbar-form" role="search">
        <div class="input-group">
        <input type="text" size="70%" class="form-control" placeholder="Search for a Products,Categories and more...">
        </div>
        </form>
        </ul>
      <ul class="nav navbar-nav navbar-right">
      
        <c:if test="${empty loggedInUser}">
        <li><a href="loginHere"><span class="glyphicon glyphicon-user"></span> Login</a></li>
        </c:if>
        
        <c:if test="${! empty loggedInUser}">
        <span class="glyphicon glyphicon-shopping-cart"></span> 
        
        <c:if test="${empty isAdmin}">
        <a href="myCart">My Cart </a>
        </c:if>
        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </c:if>
      
        <c:if test="${empty loggedInUser}">
        <li><a href="registerHere"><span class="glyphicon glyphicon-user"></span>Sign-Up</a></li>      
        </c:if>  

  </div>
</nav>

  </div>
</div>


<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="22.jpg" alt="22" width="460" height="345">
      </div>

      <div class="item">
        <img src="1920.jpg" alt="1920" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="2016.jpg" alt="2016" width="460" height="345">
      </div>

    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> Deal of the day </div>
        <img src="22.jpg" class="img-responsive" alt="22"width="304" height="236">
        <div class="panel-footer"> 2 smart phones and get a gift voucher </div>
      </div>
    </div>

    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading"> Deal of the day </div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 1 smart phone and get screenguard</div>
      </div>
    </div>	
    <div class="col-sm-4">
      <div class="panel panel-success">
        <div class="panel-heading"> Deal of the day </div>
        <div class="panel-body"> <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"> </div>
        <div class="panel-footer"> Buy 1 smart phone and earn points </div>
      </div>
    </div>
  </div>
</div><br><br>


<footer class="container-fluid text-left">
  <p>Mobile Store Copyright</p>
<ul class="nav navbar-nav navbar-right">
<form class="form-inline">Get deals via <br><br>
    <input type="email" class="form-control" size="25" placeholder="Gmail">
    <button type="button" class="btn btn-danger">Sign Up</button>
<br>
<input type="email" class="form-control" size="25" placeholder="Facbook">
    <button type="button" class="btn btn-danger">Sign Up</button>
<br>
<input type="email" class="form-control" size="25" placeholder="Twitter">
    <button type="button" class="btn btn-danger">Sign Up</button>
  </form>
</ul>
</footer>

</body>
</html>