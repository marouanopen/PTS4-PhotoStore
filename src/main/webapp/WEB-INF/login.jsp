
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="stylesheets/login.css">
</head>
<body>
    <div id="login" class="animate form">
        <form:form action="/login" method="post" modelAttribute="user">
            <h1>Log in</h1>
                <table>
                    <tr>
                        <td><form:label path="email"> Your email or username </form:label></td>
                        <td><form:input path="email"/></td>
                    </tr>

                    <tr>
                        <td><form:label path="password"> Your password </form:label></td>
                        <td><form:input path="password"/></td>
                    </tr>



                    <tr>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                </table>
            <p class="change_link">
                Not a member yet ?
                <a href="/WEB-INF/register.jspster.jsp" class="to_register">Join us</a>
            </p>
        </form:form>
    </div>
</body>
</html>
