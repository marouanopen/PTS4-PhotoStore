<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Album overview</title>
    <%@include file="/WEB-INF/loggedOutRedirect.jsp" %>
    <link href="${pageContext.request.contextPath}/resources/css/albums.css" rel="stylesheet" type="text/css"/>
</head>
<body>

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
<form action="${pageContext.request.contextPath}/createalbum" method="post">
    <input type="text" name="name" placeholder="Album name"/>
    <input type="submit" value="Create">
</form>
<form action="${pageContext.request.contextPath}/voucher" method="post">
    <input type="text" name="vouchercode" placeholder="Voucher code"/>
    <input type="submit" value="Use voucher code"/>
</form>
</body>
</html>
