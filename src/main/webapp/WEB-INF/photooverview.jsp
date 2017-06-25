<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Photos in ${album.name}</title>
    <link href="${pageContext.request.contextPath}/resources/css/photos.css" rel="stylesheet" type="text/css"/>
    <%@include file="/WEB-INF/loggedOutRedirect.jsp" %>
</head>
<body>

<form action="${pageContext.request.contextPath}/email/voucher" method="post">
    <input type="email" name="email" placeholder="E-mail"/>
    <input type="hidden" name="voucherCode" value="${album.voucherCode}"/>
    <input type="submit" value="Send Email"/>
</form>

<c:forEach items="${album.photos}" var="photo">
    <div class="image" style="background-image:url(images/${photo.id}_pixelated_${photo.name})"></div>
    <c:if test="${sessionScope.get('userData').ID != album.user.ID}">
        <form action="${pageContext.request.contextPath}/addToShoppingCart" method="post">
            <input type="hidden" name="productId" value="${photo.id}"/>
            <input type="hidden" name="type" value="photo"/>
            <input type="submit" value="Add to shopping cart"/>
        </form>
    </c:if>
    <c:if test="${sessionScope.get('userData').ID == album.user.ID}">
        <form action="${pageContext.request.contextPath}/changeprice" method="post">
            <input type="hidden" name="id" value="${photo.id}"/>
            <input type="text" name="price" placeholder="Price"/>
            <input type="submit" value="Submit"/>
        </form>
    </c:if>
</c:forEach>
</body>
</html>
