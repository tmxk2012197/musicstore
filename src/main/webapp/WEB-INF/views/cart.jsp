<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/templete/header.jsp"%>

    <div class="container-wrapper">
        <div class="container">
            <section>
                <div class="jumbotron">
                    <div class="container">
                        <h1>Cart</h1>
                        <p>All the selected products in your shopping cart</p>
                    </div>
                </div>
            </section>

            <section class="container" ng-app="cartApp">
                <div ng-controller="cartCtrl" ng-init="initCart('${cartId}')">
                    <div>
                        <a href="#" class="btn btn-danger pull-left" ng-click="clearCart()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
                    </div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Product</th>
                            <th>Unit Price</th>
                            <th>Quantity</th>
                            <th>Total Price</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tr ng-repeat="item in cart.cartItems">
                            <td>{{item.product.name}}</td>
                            <td>{{item.product.price}}</td>
                            <td>{{item.quantity}}</td>
                            <td>{{item.totalPrice}}</td>
                            <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)"><span class="glyphcion glyphicon-remove"></span>Remove</a> </td>
                        </tr>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>Grand Total</th>
                            <th>{{cart.grandTotal}}</th>
                            <th></th>
                        </tr>
                    </table>
                    <a href="<spring:url value="/productList"/>" class="btn btn-default">Continue Shopping</a>
                </div>
            </section>
        </div>
    </div>

<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/templete/footer.jsp"%>
