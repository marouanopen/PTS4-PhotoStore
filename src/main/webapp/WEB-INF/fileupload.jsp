<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Peter
  Date: 26-3-2017
  Time: 01:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload an image!</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/uploadfile" enctype="multipart/form-data">
    <input type="file" name="image" accept=".jpg"><br/>
    <input type="submit" value="Upload">
</form>
</body>
</html>
