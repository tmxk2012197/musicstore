<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/templete/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>
            <p class="lead">Fill the following information to register:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="customer">
        <h3>Basic Information</h3>
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="customerName" id="name" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="customerEmail" id="email" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="customerPhone" id="phone" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="username">Username</label>
            <form:input path="username" id="username" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <form:password path="password" id="password" class="form-Control"/>
        </div>

        <h3>Billing Address</h3>
        <div class="form-group">
            <label for="billingStreet">Street</label>
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingApartment">Apartment NO.</label>
            <form:input path="billingAddress.apartmentNumber" id="billingApartment" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingCity">City</label>
            <form:input path="billingAddress.city" id="billingCity" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" id="billingState" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="billingZipcode">Zipcode</label>
            <form:input path="billingAddress.zipcode" id="billingZipcode" class="form-Control"/>
        </div>

        <h3>Shipping Address</h3>
        <div class="form-group">
            <label for="shippingStreet">Street</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="shippingApartment">Apartment NO.</label>
            <form:input path="shippingAddress.apartmentNumber" id="shippingApartment" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="shippingAddress.state" id="shippingState" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="shippingAddress.country" id="shippingCountry" class="form-Control"/>
        </div>
        <div class="form-group">
            <label for="shippingZipcode">Zipcode</label>
            <form:input path="shippingAddress.zipcode" id="shippingZipcode" class="form-Control"/>
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="/WEB-INF/views/templete/footer.jsp"%>