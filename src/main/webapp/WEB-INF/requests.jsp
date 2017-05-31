<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 31-5-2017
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Photographer requests</title>
</head>
<body>
<h>Photographer requests</h>
<br><br>
<table>
<tr>
    <th>Users</th>
</tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
