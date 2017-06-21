<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/templete/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>
            <p class="lead">Fill the following information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" modelAttribute="product" enctype="multipart/form-data">
            <div class="form-group">
                <label for="productName">Name</label> <form:errors path="name" cssStyle="color: #ac2925;"/>
                <form:input path="name" id="productName" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="productCategory">Category</label>
                <label class="checkbox-inline">
                   <form:radiobutton path="category" id="productCategory" value="instrument"/>Instrument
                </label>
                <label class="checkbox-inline">
                    <form:radiobutton path="category" id="productCategory" value="record"/>Record
                </label>
                <label class="checkbox-inline">
                    <form:radiobutton path="category" id="productCategory" value="accessory"/>Accessory
                </label>
            </div>

            <div class="form-group">
                <label for="productDescription">Description</label>
                <form:textarea path="description" id="productDescription" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="productPrice">Price</label><form:errors path="price" cssStyle="color: #ac2925;"/>
                <form:input path="price" id="productPrice" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="productCondition">Condition</label>
                    <label class="checkbox-inline">
                    <form:radiobutton path="condition" id="productCondition" value="new"/>New
                </label>
                <label class="checkbox-inline">
                    <form:radiobutton path="condition" id="productCondition" value="used"/>Used
                </label>
            </div>

            <div class="form-group">
                <label for="productStatus">Status</label>
                <label class="checkbox-inline">
                    <form:radiobutton path="status" id="productStatus" value="active"/>Active
                </label>
                <label class="checkbox-inline">
                    <form:radiobutton path="status" id="productStatus" value="inactive"/>Inactive
                </label>
            </div>

            <div class="form-group">
                <label for="unitInStock">Unit In Stock</label><form:errors path="unitInStock" cssStyle="color: #ac2925;"/>
                <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
            </div>

            <div class="form-group">
                <label for="productManufacturer">Manufacturer</label>
                <form:input path="manufacturer" id="productManufacturer" class="form-Control"/>
            </div>

            <div class="form-group">
                <label class="control-label" for="productImage">Upload Image</label>
                <form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
            </div>

            <br><br>
            <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>
        </form:form>

<%@include file="/WEB-INF/views/templete/footer.jsp"%>