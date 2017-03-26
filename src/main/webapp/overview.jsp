<%--
  Created by IntelliJ IDEA.
  User: Arjan
  Date: 25-3-2017
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
    <script src="main.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
<table style="float: left">
<tr>
    <th>Fotografen</th>
</tr>
    <c:forEach items="${photographers}" var="Photographers">
        <tr onclick="clickFunction()">
            <td>${Photographers}</td>
        </tr>
    </c:forEach>
</table>

<div style="float: left;" id="userInfo">
    <p>Status: ${photographers[3].blocked}</p>
    <p>Naam: ${photographers[3].name}</p>
    <p>Adres: ${photographers[3].streetAddress} ${photographers[3].houseNumber}</p>
    <p>Postcode: ${photographers[3].zipCode}</p>
    <p>Woonplaats: ${photographers[3].city}</p>
    <p>Emailadres: ${photographers[3].email}</p>
</div>

<div id="userProducts">
    <table>
        <tr>
            <th>Products</th>
        </tr>
        <c:forEach items="${photographers[3].products}" var="Products">
            <td>${Products}</td>
        </c:forEach>
    </table>
</div>

</body>
</html>
