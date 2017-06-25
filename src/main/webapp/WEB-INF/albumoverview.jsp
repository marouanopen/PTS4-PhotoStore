<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <title>Album overview</title>
    <%@include file="/WEB-INF/loggedOutRedirect.jsp" %>
    <link href="${pageContext.request.contextPath}/resources/css/albums.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<ul class="nav nav-tabs">
    <li role="presentation"><a href="/main">Home</a></li>
    <li role="presentation"><a href="/photooverview">Photos</a></li>
    <c:if test="${sessionScope.get('userData').photographer}">
        <li role="presentation" class="active"><a href="/albumoverview">Album overview</a></li>
    </c:if>
    <c:if test="${!sessionScope.get('userData').photographer}">
        <li role="presentation"><a href="/albumoverview">Redeem Voucher</a></li>
    </c:if>
    <li role="presentation"><a href="/useroverview">Profile</a></li>
</ul>

<h2>Your albums</h2>
<div class="albums-container">
    <c:forEach items="${albumMap.ownedAlbums}" var="album">
        <c:set var="photo" value="${album.photos.get(0)}"/>
        <div class="album" style="background-image:url(images/${photo.id}_pixelated_${photo.name})">
            <p>${album.name}: ${album.photos.size()}</p>
            <form action="${pageContext.request.contextPath}/photooverview" method="post">
                <input type="hidden" name="id" value="${album.id}"/>
                <input type="submit" value="Show"/>
            </form>
        </div>
    </c:forEach>
</div>

<h2>Other albums</h2>
<div class="albums-container">
    <c:forEach items="${albumMap.voucherAlbums}" var="album">
        <c:set var="photo" value="${album.photos.get(0)}"/>
        <div class="album" style="background-image:url(images/${photo.id}_pixelated_${photo.name})">
            <p>${album.name}: ${album.photos.size()}</p>
            <form action="${pageContext.request.contextPath}/photooverview" method="post">
                <input type="hidden" name="id" value="${album.id}"/>
                <input type="submit" value="Show"/>
            </form>
            <form action="${pageContext.request.contextPath}/addToShoppingCart" method="post">
                <input type="hidden" name="productId" value="${album.id}"/>
                <input type="hidden" name="type" value="album"/>
                <input type="submit" value="Add to shopping cart"/>
            </form>
        </div>
    </c:forEach>
</div>

<c:if test="${sessionScope.get('userData').photographer}">
    <form action="${pageContext.request.contextPath}/createalbum" method="post">
        <input type="text" name="name" placeholder="Album name"/>
        <input type="submit" value="Create">
    </form>
</c:if>

<form action="${pageContext.request.contextPath}/voucher" method="post">
    <input type="text" name="vouchercode" placeholder="Voucher code"/>
    <input type="submit" value="Use voucher code"/>
</form>
</body>
</html>
