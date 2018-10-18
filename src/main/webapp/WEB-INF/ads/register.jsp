<%--
  Created by IntelliJ IDEA.
  User: Codeup
  Date: 10/18/18
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name = "title" value="Register"/>
</jsp:include>
</head>
<body>

<div class="container">
    <h1>Register</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="text">
        </div>

        <input type="submit" class="btn btn-block btn-primary" value="Register">
    </form>
</div>

</body>
</html>
