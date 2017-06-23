<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/resources/css/cart.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="shopping-cart-container">
    <c:forEach items="${sessionScope.get('shoppingCart')}" var="product">
        <div class="shopping-cart-item-container">
            <c:choose>
                <c:when test="${product['class'].simpleName == 'Album'}">
                    <c:set var="photo" value="${product.photos.get(0)}"/>
                    <div class="shopping-cart-item-thumbnail"
                         style="background-image:url(images/${photo.id}_pixelated_${photo.name})"></div>
                </c:when>
                <c:when test="${product['class'].simpleName == 'Photo'}">
                    <div class="shopping-cart-item-thumbnail"
                         style="background-image:url(images/${product.id}_pixelated_${product.name})"></div>
                </c:when>
            </c:choose>
            <div class="shopping-cart-item-name">${product.name}</div>
        </div>
    </c:forEach>
</div>
</body>
</html>
