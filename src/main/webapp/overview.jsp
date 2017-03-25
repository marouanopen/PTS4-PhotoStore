<%--
  Created by IntelliJ IDEA.
  User: Arjan
  Date: 25-3-2017
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<table style="border: double">
<tr>
    <th>Naam</th>
</tr>
    <c:forEach items="${photographers}" var="Photographers">
        <tr>
            <td>${Photographers}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
