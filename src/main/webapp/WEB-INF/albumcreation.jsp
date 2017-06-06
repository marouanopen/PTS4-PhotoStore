<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create album</title>
</head>
<body>
<p>${album.name}</p>

<c:forEach items="${album.photos}" var="photo">
    <div style="width: 100px; height: 100px; border: 1px solid black;">
            ${photo.name}
    </div>
</c:forEach>

<form method="post" action="${pageContext.request.contextPath}/uploadfile" enctype="multipart/form-data">
    <input type="hidden" name="albumId" value="${album.ID}"/>
    <input type="file" name="image" accept=".jpg"><br/>
    <input type="submit" value="Upload">
</form>
</body>
</html>
