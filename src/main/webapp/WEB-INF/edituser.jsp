<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 14-6-2017
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h>Edit user information</h>

<br><br>
<label>
    <b>ID:</b> ${user.ID}
</label><br>
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

<div id="edit-container">
    <form action="${pageContext.request.contextPath}/edit" method="post"> <br/>
        <label>ID &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</label><input type="hidden" name="id" value="${user.ID}"/> <br/>
        <label>Name &nbsp; &nbsp; &nbsp;</label><input type="text" name="name" value="${user.name}"/> <br/>
        <label>Email &nbsp; &nbsp; &nbsp;</label><input type="email" name="email" value="${user.email}"/> <br/>
        <label>Street &nbsp; &nbsp; &nbsp; &nbsp;</label><input type="text" name="street" value="${user.street}"/> <br/>
        <label>Number &nbsp; &nbsp;</label><input type="text" name="housenumber" value="${user.houseNumber}"/> <br/>
        <label>ZipCode &nbsp;</label><input type="text" name="zipcode" value="${user.zipCode}"/> <br/>
        <label>City &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</label><input type="text" name="city" value="${user.city}"/> <br/>
        <input type="submit" value="Submit">
    </form>
</div>


</body>
</html>
