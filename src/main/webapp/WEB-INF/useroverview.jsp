<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 7-6-2017
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <%@include file="/WEB-INF/loggedOutRedirect.jsp"%>
    <title>User details</title>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation"><a href="/main">Home</a></li>
    <li role="presentation" class="active"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Photos</a></li>
</ul>

<h>User details</h>
<br><br>
<label>
    <b>Email address:</b> ${user.email}
</label><br>
<label>
    <b>Name:</b> ${user.name}
</label><br>
<label>
    <b>Street:</b> ${user.street}
</label><br>
<label>
    <b>Number:</b> ${user.houseNumber}
</label><br>
<label>
    <b>Zip Code:</b> ${user.zipCode}
</label><br>
<label>
    <b>City:</b> ${user.city}
</label><br>

<c:if test="${!user.photographer && !user.requesting}">
<form method="post" action="${pageContext.request.contextPath}/useroverview">
    <input type="submit" value="Request photographer">
</c:if>
</form>
</body>
</html>
