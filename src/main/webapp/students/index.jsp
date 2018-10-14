<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/partials/head.jsp">
        <jsp:param name="title" value="Student Roster"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="/partials/navbar.jsp"/>

    <main class="container">
        <h1>Student Roster</h1>
        <c:forEach var = "student" items="${students}">
            <section>
                <h3>${student.firstName +" "+student.lastName}</h3>
                <p>${"Student Id: "+ student.studentId}</p>`
                <p>${"Gender: "+ student.gender}</p>
                <p>${"Date of Birth: "+ student.dateOfBirth}</p>
            </section>
        </c:forEach>
    </main>

</body>
</html>
