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
    <li role="presentation"><a href="/photooverview">Photos</a></li>
    <c:if test="${sessionScope.get('userData').photographer}">
        <li role="presentation"><a href="/albumoverview">Album overview</a></li>
    </c:if>
    <c:if test="${!sessionScope.get('userData').photographer}">
        <li role="presentation"><a href="/albumoverview">Redeem Voucher</a></li>
    </c:if>
    <li role="presentation"><a href="/useroverview">Profile</a></li>
</ul>

<p>Welcome ${user.name} !</p>

</body>
</html>
