<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/templete/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h2>Thanks for your business</h2>
                    <p>Your roder will be shipped soon.</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p>
                <a href="<spring:url value="/"/>" class="btn btn-default">OK</a>
            </p>
        </section>
    </div>
</div>

<%@include file="/WEB-INF/views/templete/footer.jsp"%>
