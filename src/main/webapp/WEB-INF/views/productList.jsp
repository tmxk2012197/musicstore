<%--
  Created by IntelliJ IDEA.
  User: mache
  Date: 6/16/2017
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
            </tr>
        </thead>
        <tr>
            <td>${product.name}</td>
            <td>${product.category}</td>
            <td>${product.condition}</td>
            <td>${product.price}</td>
        </tr>
    </table>
</body>
</html>
