<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<c:if test="${sessionScope.get('userData') == null}">
    <c:redirect url="${pageContext.request.contextPath}/"/>
</c:if>
</body>
</html>
