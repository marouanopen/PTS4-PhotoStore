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
    <%@include file="/WEB-INF/loggedOutRedirect.jsp"%>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"></script>
    <title>Admin overview</title>
    <script>
        function clickFunction(userid){

            var userID = document.getElementById(userid);
                userID.style.display = 'block';
        }

        function hideDivs(){
            for(var i = 0; len = ${photographers.size()}; i < len){
                var usersID = document.getElementById(i.toString());
                if(usersID.style.display == 'block')
                usersID.style.display = 'none';
                i++;
            }
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">Photographers</a></li>
    <li role="presentation"><a href="/useroverview">Albums</a></li>
</ul>
<table style="width: 15px;float: left" class="table table-hover">
<tr>
    <th>Photographers</th>
</tr>
    <c:forEach items="${photographers}" var="photographer">
        <tr onclick="clickFunction(${photographers.indexOf(photographer)})">
            <td class="col-md-1">${photographer}</td>
            <td><a href="<c:url value="${pageContext.request.contextPath}/edit/${photographer.ID}"/>"><span class="glyphicon glyphicon-edit"></span></a></td>
            <td><a href="<c:url value="${pageContext.request.contextPath}/remove/${photographer.ID}"/>"><span class="glyphicon glyphicon-remove-circle"></span></a></td>
        </tr>
    </c:forEach>
</table>

<c:forEach items="${photographers}" var = "photographer">
    <div class="form-horizontal" style="display:none;float:left" id=${photographers.indexOf(photographer)}>
        <p><b>Geblokkeerd:</b> ${photographer.blocked}</p>
        <p><b>Naam:</b> ${photographer.name}</p>
        <p><b>Adres:</b> ${photographer.street} ${photographer.houseNumber}</p>
        <p><b>Postcode:</b> ${photographer.zipCode}</p>
        <p><b>Woonplaats:</b> ${photographer.city}</p>
        <p><b>Emailadres:</b> ${photographer.email}</p>
    </div>


    <c:set var="userSession" value="${pageContext.session.getAttribute('user')}"/>
    <c:if test="${userSession != null}">
        <p>${userSession.name}</p>
    </c:if>

 <%---   <div id="productInfo" style="display:none">
        <table>
            <tr>
                <th>Products</th>
            </tr>
            <c:forEach items="${photographer.products}" var="Products">
                <td>${Products}</td>
            </c:forEach>
        </table>
    </div>
--%>
</c:forEach>
</body>
</html>
