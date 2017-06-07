<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Photos in ${album.name}</title>
</head>
<body>

<c:forEach items="${album.photos}" var="photo">
    <div style="width: 100px; height: 100px; border: 1px solid black; background-image:url(../resources/images/${photo.id}_pixelated_${photo.name});"></div>
</c:forEach>
</body>
</html>
