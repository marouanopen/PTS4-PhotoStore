<%@ page import="fotowebstore.enums.LoginStatus" %><%--
  Created by IntelliJ IDEA.
  User: Peter
  Date: 15-5-17
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to the foto webstore!</title>
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
<c:set var="failedStatus">
    <%=LoginStatus.FAILED%>
</c:set>
<c:set var="duplicateEmailStatus">
    <%=LoginStatus.DUPLICATE_EMAIL%>
</c:set>

<c:choose>
    <c:when test= "${loginStatus == failedStatus}">
        <p style="color: red;">The password or email address that you entered is invalid!</p>
    </c:when>
    <c:when test="${loginStatus == duplicateEmailStatus}">
        <p style="color: red;">The email that you entered is already in use!</p>
    </c:when>
    <c:otherwise><p>test</p></c:otherwise>
</c:choose>

</body>
</html>
