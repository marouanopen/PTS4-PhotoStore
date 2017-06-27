<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Welcome to the photo webstore!</title>
    <link href="${pageContext.request.contextPath}/resources/css/stylesheet.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous"/>
    <c:if test="${sessionScope.get('userData') != null}">
        <c:redirect url="/main"/>
    </c:if>
</head>
<body>

<div id="main">
    <div id="login" class="form-container">
        <h3>Login</h3>
        <form  action="${pageContext.request.contextPath}/login" method="post">
            <input type="email" name="email" placeholder="E-mail"/>
            <input type="password" name="password" placeholder="Password"/> <br/>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>

    <div id="register" class="form-container">
        <h3>Register</h3>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <input type="text" name="name" placeholder="Name"/>
            <input type="email" name="email" placeholder="Email"/>
            <input type="password" name="password" placeholder="Password"/>
            <input type="text" name="city" placeholder="City"/>
            <input type="text" name="street" placeholder="Street"/>
            <input type="text" name="zipcode" placeholder="Zipcode"/>
            <input type="text" name="housenumber" placeholder="House number"/> <br/>
            <button type="submit" class="btn btn-primary">Register</button>
        </form>
    </div>
</div>

<c:choose>
    <c:when test="${loginStatus == 'FAILED'}">
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
