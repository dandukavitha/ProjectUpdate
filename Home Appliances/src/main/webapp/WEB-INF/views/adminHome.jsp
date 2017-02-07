<!DOCTYPE html>
<html lang="en">
<head>
  <title>HP</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
	.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        
        <li><a href="viewProducts">View Products</a></li>
        <li><a href="addProduct">Add Products</a></li>
        <li><a href="logout">Logout</a></li>
		  <li>&nbsp; &nbsp; &nbsp; &nbsp;</li>
		    
		   
		  
      </ul>
    </div>
  </div>
</nav>
    </div>

<div>
<center><img src="resources/images/admin page.jpg" style="width: 400px"; height="200px"></center>
<hr></hr>

  
<div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>

</html>
