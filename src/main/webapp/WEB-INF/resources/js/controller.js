// shopping cart restful services
var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){
    $scope.refreshCart = function () {
        $http.get('/musicStore/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/musicStore/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/musicStore/rest/cart/add/' + productId).success(function () {
            alert("Product is successfully added to the cart")
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/musicStore/rest/cart/remove/' + productId).then(function () {
            $scope.refreshCart();
        });
    };

    $scope.calculateGrandTotal = function () {
        var grandTotal = 0;
        for (var i = 0; i < $scope.cart.cartItems.length; i++) {
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;
    }
});


