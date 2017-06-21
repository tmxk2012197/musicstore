<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/templete/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>
            <p class="lead">Detail information of the product</p>
        </div>

        <div class="cotainers">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width: 100%; height: 400px"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p><strong>Category</strong>: ${product.category}</p>
                    <P><strong>Condition</strong>: ${product.condition}</P>
                    <p><strong>Manufacturer</strong>: ${product.manufacturer}</p>
                    <p><strong>Unit in Stock</strong>: ${product.unitInStock}</p>
                    <h4>${product.price} USD</h4>
                </div>
            </div>
        </div>

<%@include file="/WEB-INF/views/templete/footer.jsp"%>