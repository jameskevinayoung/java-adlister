
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//    Put this above the document to make sure the information is processed first

    //conditional clause to redirect the user to the profile page if the username == username/password == password
    if(request.getMethod().equalsIgnoreCase("post")){ //not case sensitive
        String username = request.getParameter("username");//username becomes a variable to hold whatever username
        String password = request.getParameter("password");//password becomes a variable to hold whatever password
        if(username.equals("admin") && password.equals("password")){//needs to be case sensitive for security reasons
            response.sendRedirect("/profile.jsp"); //redirect the user to the profile page
        }
    }
//Don't need to use choose because this part runs first
%>

<html>
<%--don't know why this is doing doesn't mirror the navbar. Maybe its because its located in the head vs body--%>
<%--the header, navbar, and footer are all included from the partials folder with the use of the jsp XML syntax --%>
<head>

    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Welcome, Please Log in!"/>
    </jsp:include>
</head>
<body>
<%--added the navbar--%>
    <jsp:include page="partials/navbar.jsp"/>

<%--create a main to hold the entier form and header; add a container class--%>
    <main class="login-container">

        <h1>Login Form</h1>

        <%--create a section to separate the form from any other portions --%>
        <section>

            <%--this form will post information from the login page to the profile page--%>
            <form method="post" action="/login.jsp">

                <%--create a label for each input; follow the normal html procedures to create a form --%>
                <label for="username">Username:</label>
                <input class="form-input" id="username" type="text" name="username"/><br/><br/>
                <label for="password">Password:</label>
                <input class="form-input" id="password" type="password" name="password"/><br/><br/>

                <%--create the input for the button; it's important to make it an input instead of a button because
                    <input type="submit" automatically submits a form on click --%>
                <input type="submit" value="Login"/>
            </form>
        </section>


    </main>



<%--<c:choose>--%>
    <%--<c:when test ="${'admin'}">--%>
        <%--<p>Redirect to profile page</p>--%>
    <%--</c:when>--%>
    <%--<c:otherwise>--%>
        <%--<p>back to login page</p>--%>
    <%--</c:otherwise>--%>
<%--</c:choose>--%>

<footer>
    <jsp:include page="partials/footer.jsp"/>
</footer>

</body>
</html>
