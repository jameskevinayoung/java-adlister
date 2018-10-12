<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<jsp:include page="/partials/head.jsp">
    <jsp:param name="title" value="Ads Listing"/>
</jsp:include>
</head>
<body>
<jsp:include page="/partials/navbar.jsp"/>

    <div class="container">
        <h1>Ads</h1>
<%--forEach loop in this container; loop each ad from ads and display each ad title and description--%>
        <c:forEach var = "ad" items="${ads}">
            <section>
                <h3>${ad.title}</h3>
                <p>${ad.description}</p>
            </section>
        </c:forEach>

    </div>
</body>
</html>