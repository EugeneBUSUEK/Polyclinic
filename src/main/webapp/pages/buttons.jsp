<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.rsreu.polyclinic.data.User" %>
<%@ page import="ru.rsreu.polyclinic.enums.RoleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buttons</title>
</head>
<body>

<%
    User user = (User) session.getAttribute("user");

%>

<div class="container-button">
    <c:choose>
        <c:when test="${user.getRole().equals(RoleType.DOCTOR.getRole())}">
            <button class="button" role="button">Outpatient cards</button>
            <button class="button" role="button">Appointments</button>
            <button class="button" role="button">Request a vacation/time off</button>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.MODER.getRole())}">
            <form action="moderator"><button class="button" role="button">Edit users blocked status</button></form>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.POLYC_ADMIN.getRole())}">
            <button class="button" role="button">1</button>
            <button class="button" role="button">2</button>
            <button class="button" role="button">3</button>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.SYS_ADMIN.getRole())}">
            <button class="button" role="button">4</button>
            <button class="button" role="button">5</button>
            <button class="button" role="button">6</button>
        </c:when>
    </c:choose>
</div>

</body>
</html>
