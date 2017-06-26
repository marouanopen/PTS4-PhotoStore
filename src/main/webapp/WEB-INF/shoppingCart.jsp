<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous"/>
    <link href="${pageContext.request.contextPath}/resources/css/cart.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="shopping-cart-container">
    <c:set var="totalPrice" value="${0}"/>
    <c:forEach items="${sessionScope.get('shoppingCart')}" var="product">
        <c:set var="totalPrice" value="${totalPrice + product.price}"/>
        <div class="shopping-cart-item-container">
            <c:choose>
                <c:when test="${product['class'].simpleName == 'Album'}">
                    <c:set var="photo" value="${product.photos.iterator().next()}"/>
                    <div class="shopping-cart-item-thumbnail"
                         style="background-image:url(images/${photo.id}_pixelated_${photo.name})"></div>
                </c:when>
                <c:when test="${product['class'].simpleName == 'Photo'}">
                    <div class="shopping-cart-item-thumbnail"
                         style="background-image:url(images/${product.id}_pixelated_${product.name})"></div>
                </c:when>
            </c:choose>
            <div class="shopping-cart-item-details">
                <p>${product.name}</p>
                <p>$${product.price}</p>
            </div>
            <div class="shopping-cart-item-actions">
                <a href="/cart/remove/${product.id}/${product['class'].simpleName}">
                    <span class="glyphicon glyphicon-remove"></span>
                </a>
            </div>
        </div>
    </c:forEach>
    <div class="shopping-cart-final">
        <h3>Total: ${totalPrice}</h3>
        <button type="submit" value="Proceed to payment"></button>
    </div>
</div>
</body>
</html>
