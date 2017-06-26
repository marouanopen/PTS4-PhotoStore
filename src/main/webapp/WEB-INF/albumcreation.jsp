<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create album</title>
    <%@include file="/WEB-INF/loggedOutRedirect.jsp"%>
</head>
<body>
<p>${album.name}</p>

<c:forEach items="${album.photos}" var="photo">
    <div style="width: 192px; height: 108px; background-size: cover; background-image: url(images/${photo.id}_${photo.name});"></div>
</c:forEach>

<form method="post" action="${pageContext.request.contextPath}/uploadfile" enctype="multipart/form-data">
    <input type="hidden" name="albumId" value="${album.id}"/>
    <input type="file" name="image" accept=".jpg"><br/>
    <label>
        Price: <input type="number" name="price" step="0.01" value="0.00"/>
    </label><br/>
    <input type="submit" value="Upload">
</form>
</body>
</html>
