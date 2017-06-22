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
    <li role="presentation"><a href="#">Photos</a></li>
    <li role="presentation"><a href="/useroverview">Profile</a></li>
</ul>

<p>Welcome ${user.name} !</p>

</body>
</html>
