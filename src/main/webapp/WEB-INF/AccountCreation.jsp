<%--
  Created by IntelliJ IDEA.
  User: Peter
  Date: 08-5-17
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="topbar.jsp"%>
</head>
<body>
<form action="${pageContext.request.contextPath}/account" method="POST">
    <input type="text" name="accountNr"> <br/>
    <input type="submit">
</form>
</body>
</html>
