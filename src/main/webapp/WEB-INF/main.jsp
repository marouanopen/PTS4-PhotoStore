<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21-6-2017
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <%@include file="/WEB-INF/loggedOutRedirect.jsp"%>
    <title>Main Page</title>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">Home</a></li>
    <li role="presentation"><a href="/useroverview">Profile</a></li>
    <li role="presentation"><a href="#">Photos</a></li>
</ul>

<p>Welkom ${user.name} !</p>

</body>
</html>
