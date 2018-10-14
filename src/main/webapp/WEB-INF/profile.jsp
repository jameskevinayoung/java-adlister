<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome ${username}.</h1>
        <button><a href="/login">Logout</a></button>
    </div>

</body>
</html>
