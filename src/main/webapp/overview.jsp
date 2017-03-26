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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script>
        function clickFunction(){
            var userDiv = document.getElementById('userInfo');
            var productDiv = document.getElementById('productInfo');

            // based on condition you can change visibility
            if(userDiv.style.display == 'block') {
                userDiv.style.display = 'none';
                productDiv.style.display = 'none';
            }
            else {
                userDiv.style.display = 'block';
                productDiv.style.display = 'block';
            }
        }
    </script>
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

<div style="display:block;float: left" id="userInfo">
    <p>Status: ${photographers[2].blocked}</p>
    <p>Naam: ${photographers[2].name}</p>
    <p>Adres: ${photographers[2].streetAddress} ${photographers[2].houseNumber}</p>
    <p>Postcode: ${photographers[2].zipCode}</p>
    <p>Woonplaats: ${photographers[2].city}</p>
    <p>Emailadres: ${photographers[2].email}</p>
</div>

<div id="productInfo">
    <table>
        <tr>
            <th>Products</th>
        </tr>
        <c:forEach items="${photographers[2].products}" var="Products">
            <td>${Products}</td>
        </c:forEach>
    </table>
</div>

</body>
</html>
