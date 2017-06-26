<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to the photo webstore!</title>
    <link href="${pageContext.request.contextPath}/css/stylesheet.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="login-container">
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="email" name="email" placeholder="E-mail"/> <br/>
        <input type="password" name="password" placeholder="Password"/> <br/>
        <input type="submit" value="Log in"/>
    </form>
</div>

<div id="register-container">
    <form action="${pageContext.request.contextPath}/register" method="post"> <br/>
        <input type="text" name="name" placeholder="Name"/> <br/>
        <input type="email" name="email" placeholder="Email"/> <br/>
        <input type="password" name="password" placeholder="Password"/> <br/>
        <input type="text" name="city" placeholder="City"/> <br/>
        <input type="text" name="street" placeholder="Street"/> <br/>
        <input type="text" name="zipcode" placeholder="Zipcode"/> <br/>
        <input type="text" name="housenumber" placeholder="House number"/> <br/>
        <input type="submit" value="Submit">
    </form>
</div>

<br/>

<c:choose>
    <c:when test= "${loginStatus == 'FAILED'}">
        <p style="color: red;">The password or email address that you entered is invalid!</p>
    </c:when>
    <c:when test="${loginStatus == 'DUPLICATE_EMAIL'}">
        <p style="color: red;">The email that you entered is already in use!</p>
    </c:when>
    <c:when test="${loginStatus == 'SUCCESS'}">
        <p style="color: lawngreen;">Account creation successful!</p>
    </c:when>
</c:choose>

</body>
</html>
