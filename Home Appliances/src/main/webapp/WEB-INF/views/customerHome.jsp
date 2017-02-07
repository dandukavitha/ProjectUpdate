<!DOCTYPE html>
<html lang="en">
<head>
  <title>HP</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>document.write('<base href="' + document.location + '" />');</script>
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./resources/css/style.css" rel="stylesheet" media="screen">
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
  <style>
    
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }    
    
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
	.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  </style>
  <script type="text/javascript">
$(document).ready(function(){
     $("#myCarousel").carousel({
         interval : 1000,
         pause: false
     });
});
</script>
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
        
       
        <li><a href="ViewProfile">View Profile</a></li>
         <li><a href="logout">Log Out</a></li>
		  <li>&nbsp; &nbsp; &nbsp; &nbsp;</li>
		    
		  
      </ul>
    </div>
  </div>
</nav>
    </div>
<div>
 <center><h3>Featured Shoes</h3></center>
<hr></hr>
</div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Brand:  <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table>
  <tr>
<div class="row">
    <td><div class="col-md-4 col-lg-4 col-sm-6" class="img-thumbnail" ng-repeat="resource in names | filter:search">
    <a href="productViewDetails?id={{resource.product_id}}" class="thumbnail">
        	<p>$ {{resource.price}} - {{resource.product_name}}        </p>
        <img src="resources/images/{{resource.product_id}}.jpg" alt="Pulpit Rock" style="width:450px;height:250px" border="5">
        <p> {{resource.description}}</p>
      </a>
    </div></td>
</table>
</div>
<%@include file="footer.jsp" %>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${products};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>

</body>


</html>
