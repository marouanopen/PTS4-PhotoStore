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
    <%@include file="/WEB-INF/loggedOutRedirect.jsp"%>
    <title>Overview of users that request a photographer account</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="/overview">Photographers</a></li>
    <li role="presentation" class="active"><a href="/#">Photographer Requests</a></li>
    <li role="presentation"><a href="/albumoverviewadmin">Albums</a></li>
    <li role="presentation"><a href="/photooverviewadmin">Photos</a></li>
    <li role="presentation"><a href="/logout">Logout</a></li>
</ul>
<div id="request-container">
    <form>
<table style="width: 15px;float: left" class="table table-hover">
<tr>
    <th>Username</th>
    <th>Request</th>
</tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.name}</td>
            <td><a href="<c:url value="${pageContext.request.contextPath}/accept/${user.ID}"/>"><span class="glyphicon glyphicon-ok-circle"></span></a></td>
            <td><a href="<c:url value="${pageContext.request.contextPath}/deny/${user.ID}"/>"><span class="glyphicon glyphicon-ban-circle"></span></a></td>
        </tr>
    </c:forEach>
</table>
    </form>
</div>
</body>
</html>
