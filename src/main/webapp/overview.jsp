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
    <script>
        function clickFunction(userid){
            var userID = document.getElementById(userid);
            var userDiv = document.getElementsByClassName(userDiv);

            if(userID.style.display == 'none'){
                userID.style.display = 'block';
            }

        }
    </script>
</head>
<body>
<table style="float: left">
<tr>
    <th>Fotografen</th>
</tr>
    <c:forEach items="${photographers}" var="photographer">
        <tr onclick="clickFunction(${photographers.indexOf(photographer)})">
            <td>${photographer}</td>
        </tr>
    </c:forEach>
</table>

<c:forEach items="${photographers}" var = "photographer">
    <div style="display:none;float:left" id=${photographers.indexOf(photographer)}>
        <p>Geblokkeerd: ${photographer.blocked}</p>
        <p>Naam: ${photographer.name}</p>
        <p>Adres: ${photographer.streetAddress} ${photographer.houseNumber}</p>
        <p>Postcode: ${photographer.zipCode}</p>
        <p>Woonplaats: ${photographer.city}</p>
        <p>Emailadres: ${photographer.email}</p>
    </div>

    <div id="productInfo" style="display:none">
        <table>
            <tr>
                <th>Products</th>
            </tr>
            <c:forEach items="${photographer.products}" var="Products">
                <td>${Products}</td>
            </c:forEach>
        </table>
    </div>
</c:forEach>

</body>
</html>
