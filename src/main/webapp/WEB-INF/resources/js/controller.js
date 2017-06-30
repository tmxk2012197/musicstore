// shopping cart restful services
var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){
    $scope.refreshCart = function () {
        $http.get('/musicStore/rest/cart/' + $scope.cartId).success(function (data) {
            $scope.cart = data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/musicStore/rest/cart/' + $scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/musicStore/rest/cart/add/' + productId).success(function () {
            $scope.refreshCart($http.get('/musicStore/rest/cart/cartId'));
            alert("Product is successfully added to the cart")
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/musicStore/rest/cart/remove/' + productId).then(function (data) {
            $scope.refreshCart($http.get('/musicStore/rest/cart/get/cartId'));
        });
    };
});


