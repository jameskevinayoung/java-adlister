<%--
  Created by IntelliJ IDEA.
  User: Codeup
  Date: 10/11/18
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<h3>Login Form</h3>

<form method="post" action="/login.jsp">
    Username:<input type="text" name="username"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="Login"/>
</form>

<c:choose>
    <c:when test ="${'admin'}">
        <p>Redirect to profile page</p>
    </c:when>
    <c:otherwise>
        <p>back to login page</p>
    </c:otherwise>
</c:choose>

</body>
</html>
