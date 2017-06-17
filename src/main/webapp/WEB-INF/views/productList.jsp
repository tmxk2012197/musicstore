<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/templete/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>
            <p class="lead">Check out all the products now!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Status</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="" alt="image"/></td>
                    <td>${product.name}</td>
                    <td>${product.category}</td>
                    <td>${product.condition}</td>
                    <td>${product.status}</td>
                    <td>${product.price} USD</td>
                    <td><a href="<spring:url value="/productList/viewProduct/${product.productId}"/>"><span class="glyphicon glyphicon-info-sign"></span></td>
                </tr>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/templete/footer.jsp"%>