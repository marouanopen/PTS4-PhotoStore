<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <title>Adminoverview albums</title>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="/overview">Photographers</a></li>
    <li role="presentation"><a href="/requests">Photographer Requests</a></li>
    <li role="presentation" class="active"><a href="#">Albums</a></li>
    <li role="presentation"><a href="/photooverviewadmin">Photos</a></li>
    <li role="presentation"><a href="/logout">Logout</a></li>
</ul>

<table style="width: 15px;float: left" class="table table-hover">
    <tr>
        <th>Photographer</th>
        <th>Album</th>
    </tr>
    <c:forEach items="${albums}" var="album">
        <td>${album.user.name}</td>
        <td>${album.name}</td>
        <c:choose>
            <c:when test="${!album.hidden}">
                <td><a href="<c:url value="${pageContext.request.contextPath}/hidealbum/${album.id}"/>"><span class="glyphicon glyphicon-eye-open"></span></a></td>
            </c:when>
            <c:otherwise>
                <td><a href="<c:url value="${pageContext.request.contextPath}/showalbum/${album.id}"/>"><span class="glyphicon glyphicon-eye-close"></span></a></td>
            </c:otherwise>
        </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>
