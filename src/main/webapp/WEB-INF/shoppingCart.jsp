<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <c:set var="shoppingCart" value="${sessionScope.get('shoppingCart')}"/>

    <c:forEach items="${shoppingCart}" var="product">
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
                    Remove from cart <span class="glyphicon glyphicon-remove"></span>
                </a>
            </div>
        </div>
    </c:forEach>
    <div class="shopping-cart-final">
        <c:if test="${fn:length(shoppingCart) == 0}">
            <p>Your shopping cart is empty!</p>
        </c:if>
        <c:if test="${fn:length(shoppingCart) > 0}">
            <form action="${pageContext.request.contextPath}/pay" method="post">
                <h3>Total: <fmt:formatNumber value="${totalPrice}" type="currency"/></h3>
                <button type="submit" class="btn btn-primary">Proceed to payment</button>
            </form>

        </c:if>
    </div>
</div>
</body>
</html>
