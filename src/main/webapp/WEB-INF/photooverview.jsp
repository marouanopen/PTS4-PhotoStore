<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Photos in ${album.name}</title>
    <link href="${pageContext.request.contextPath}/resources/css/photos.css" rel="stylesheet" type="text/css"/>
    <%@include file="/WEB-INF/loggedOutRedirect.jsp" %>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="/albumoverview">Album overview</a></li>
    <li role="presentation"><a href="/useroverview">Profile</a></li>
    <li class="glyphicon glyphicon-shopping-cart"><a href="/cart"></a></li>
    <li role="presentation"><a href="/logout">Logout</a></li>
</ul>

<form action="${pageContext.request.contextPath}/email/voucher" method="post">
    <input type="email" name="email" placeholder="E-mail"/>
    <input type="hidden" name="voucherCode" value="${album.voucherCode}"/>
    <input type="submit" value="Send Email"/>
</form>

<c:forEach items="${album.photos}" var="photo">
    <div class="image" style="background-image:url(images/${photo.id}_pixelated_${photo.name})">
        <c:if test="${sessionScope.get('userData').ID != album.user.ID}">
            <form action="${pageContext.request.contextPath}/addToShoppingCart" method="post"
                  style="margin-top: 200px;">
                <input type="hidden" name="productId" value="${photo.id}"/>
                <input type="hidden" name="type" value="photo"/>
                <input type="submit" value="Add to shopping cart"/>
            </form>
        </c:if>
        <c:if test="${sessionScope.get('userData').ID == album.user.ID}">
            <form action="${pageContext.request.contextPath}/changeprice" method="post" style="margin-top: 200px;">
                <input type="hidden" name="id" value="${photo.id}"/>
                <input type="text" name="price" value="${photo.price}" placeholder="Price"/>
                <input type="submit" value="Submit"/>
            </form>
        </c:if>
    </div>
</c:forEach>
</body>
</html>
