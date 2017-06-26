<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <title>Adminoverview Photos</title>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="/overview">Photographers</a></li>
    <li role="presentation"><a href="/requests">Photographer Requests</a></li>
    <li role="presentation"><a href="/albumoverviewadmin">Albums</a></li>
    <li role="presentation" class="active"><a href="#">Photos</a></li>
</ul>

<table style="width: 15px;float: left" class="table table-hover">
    <tr>
        <th>Photographer</th>
        <th>Album</th>
        <th>Photo</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${photos}" var="photo">
            <td>${photo.album.user.name}</td>
            <td class="col-md-1">${photo.album.name}</td>
            <td>${photo.name}</td>
        <c:choose>
            <c:when test="${!photo.hidden}">
                <td><a href="<c:url value="${pageContext.request.contextPath}/hide/${photo.id}"/>"><span class="glyphicon glyphicon-eye-open"></span></a></td>
            </c:when>
            <c:otherwise>
                <td><a href="<c:url value="${pageContext.request.contextPath}/show/${photo.id}"/>"><span class="glyphicon glyphicon-eye-close"></span></a></td>
            </c:otherwise>
        </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>
