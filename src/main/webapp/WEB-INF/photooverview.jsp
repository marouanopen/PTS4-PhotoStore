<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Photos in ${album.name}</title>
    <style>
        .image {
            margin: 5% 0 0 5%;
            width: 90%;
            height: 90%;
            background-size: cover;
        }
    </style>
    <%@include file="/WEB-INF/loggedOutRedirect.jsp"%>
</head>
<body>

<form action="${pageContext.request.contextPath}/email/voucher" method="post">
    <input type="email" name="email" placeholder="E-mail"/>
    <input type="hidden" name="voucherCode" value="${album.voucherCode}"/>
    <input type="submit" value="Send Email"/>
</form>

<c:forEach items="${album.photos}" var="photo">
    <div class="image" style="background-image:url(images/${photo.id}_pixelated_${photo.name});"></div>
</c:forEach>
</body>
</html>
