<%--
  Created by IntelliJ IDEA.
  User: Peter
  Date: 20-3-17
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="item" items="${jemoeder}">
    <p>${item}</p>
</c:forEach>
</body>
</html>
