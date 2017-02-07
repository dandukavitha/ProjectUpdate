<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
  <title>Shoe Clue's</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <script>document.write('<base href="' + document.location + '" />');</script>
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./resources/css/style.css" rel="stylesheet" media="screen">
    <script data-require="angular.js@1.0.x" src="http://code.angularjs.org/1.0.7/angular.min.js" data-semver="1.0.7"></script>
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
        <li ><a href="#">Men's Wear</a></li>
        <li><a href="#">Women's Wear</a></li>
		  <li>&nbsp; &nbsp; &nbsp; &nbsp;</li>
		    
		   <li> <button type="button" class="btn btn-primary btn-s" style="background-color:red">Shoe Clue's</button></li>
		    <li>&nbsp; &nbsp; &nbsp; &nbsp;</li>
		
		  
      </ul>
    </div>
  </div>
</nav>
<div>
<center><img src="resources/images/products.jpg" style="width:300px;height: 300px"></center>
</div>
<div>
<div class="container">
  <div>

    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Product Name</th>
    <th>Product Category</th>
    <th>Brand</th>
     <th>Type of Product</th>
     <th>Price</th>
    <th>Product Image</th>
    </tr>
        <tr >
             <td>${product.product_id}</td>
            <td>${ product.product_name}</td>
            <td>${product.product_category}</td>
            <td>${product.brand}</td>
            <td>${ product.typeOfProduct}</td>
            <td>${product.price}</td>
            <td><img src="resources/images/${product.product_id}.jpg" style="width: 200px;height:150px"></td>
            <td><a href="CustomerCheck">Add to Cart</a></td>
        </tr>    
    </table>
</div>
<%@include file="footer.jsp" %>
</body>

</html>
