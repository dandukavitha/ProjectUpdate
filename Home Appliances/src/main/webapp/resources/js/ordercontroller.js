/*
 * This controller is used to handle rest calls related to cart page. This controller is mapped with CartManagementController to call related rest service.
 */

var cartApp = angular.module ("addToCartApp", []);

cartApp.controller("addToCartCtrl", function ($scope, $http){
	
	 /*
     * retrieveCart method is used to get all cart items at the starting of the application
     */
    $scope.retrieveCart = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCartItems(cartId);
    };
    
    
    /*
     * removeItemFromCart method is used to remove a item from the cart
     */
    $scope.removeItemFromCart = function (itemId) {
    	
        $http.put('http://localhost:8761/shoeclue/usercart/cart/removeItem/'+itemId).success(function (data) {
            $scope.refreshCartItems();
        });
    };

	 /*
     * addItemToCart method is used to add items into the cart
     */
    $scope.addItemToCart = function (itemId) {
    	 alert("test");
        $http.put('http://localhost:8761/shoeclue/usercart/cart/addItem/'+itemId).success(function () {
            alert("Item added to the cart!")
        });
    };
   
   
    /*
     * GrandTotalOfItems method is called on cart page to calculate grand total for the added items
     */
    $scope.GrandTotalOfItems = function () {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
       }
        return grandTotal;
    };
    /*
	 * refreshCartItems method is called by others methods in same controller to refresh the cart
	 */
    $scope.refreshCartItems = function () {
        $http.get('http://localhost:8761/shoeclue/usercart/cart/refreshCart/'+$scope.cartId).success(function (data) {
           $scope.cart=data;
        });
    };
    
    /*
     * clearCartItems method is used to delete all items from the cart
     */
    $scope.clearCartItems = function () {
    	$http['delete']('http://localhost:8761/shoeclue/usercart/cart/clearCartItems/'+$scope.cartId).success(function (data) {$scope.refreshCartItems()});
    };
});