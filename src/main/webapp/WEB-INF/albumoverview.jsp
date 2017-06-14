<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Album overview</title>
    <%@include file="/WEB-INF/loggedOutRedirect.jsp"%>
</head>
<body>
<c:forEach items="${albums}" var="album">
    <div style="width: 100px; height: 100px; border: 1px solid black;">
        <p>${album.name}: ${album.photos.size()}</p>
        <form action="${pageContext.request.contextPath}/photooverview" method="post">
            <input type="hidden" name="id" value="${album.ID}"/>
            <input type="submit" value="Show"/>
        </form>
    </div>
</c:forEach>

<form action="${pageContext.request.contextPath}/createalbum" method="post">
    <input type="text" name="name" placeholder="Album name"/>
    <input type="submit" value="Create">
</form>
</body>
</html>
