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
    <title>Overview of users that request a photographer account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>
<h>Photographer requests</h>
<br><br>
<div id="request-container">
    <form action="${pageContext.request.contextPath}/requests" method="post">
<table>
<tr>
    <th>Username</th>
    <th>Request</th>
</tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <!--<td><input type="checkbox" id="check${user.ID}" name="selectedItems" value="${user}"></td>-->
            <td><a href="<c:url value="${pageContext.request.contextPath}/accept/${user.email}"/>"><span class="glyphicon glyphicon-ok-circle"></span></a></td>
            <td><a href="<c:url value="${pageContext.request.contextPath}/deny/${user.email}"/>"><span class="glyphicon glyphicon-ban-circle"></span></a></td>
        </tr>
    </c:forEach>
</table>
    </form>
</div>
</body>
</html>
