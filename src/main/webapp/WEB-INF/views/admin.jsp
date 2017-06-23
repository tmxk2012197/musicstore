<%@ include file="/WEB-INF/views/templete/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator</h1>
            <p class="lead">This is the adiministrator page</p>
        </div>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url value="/login?logout"/>">Logout</a> </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory"/>">Product Inventory</a>
        </h3>

        <p>Here you can view, check and modify the product inventory!</p>

<%@include file="/WEB-INF/views/templete/footer.jsp"%>