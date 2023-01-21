<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.rsreu.polyclinic.data.User" %>
<%@ page import="ru.rsreu.polyclinic.enums.RoleType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buttons</title>
</head>
<body>

<div class="container-button">
    <c:choose>
        <c:when test="${user.getRole().equals(RoleType.DOCTOR.getRole())}">
            <button class="button" role="button">Outpatient cards</button>
            <button class="button" role="button">Appointments</button>
            <button class="button" role="button">Request a vacation/time off</button>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.MODER.getRole())}">
            <form action="moderator" method="post"><button class="button" role="button">Edit users blocked status</button></form>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.POLYC_ADMIN.getRole())}">
            <form action="editOutpatientCards" method="post"><button class="button" role="button">Edit & Add patient card</button></form>
            <button class="button" role="button">2</button>
            <button class="button" role="button">3</button>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.SYS_ADMIN.getRole())}">
            <form action="sysAdmin" method="post"><button class="button" role="button">Edit & Add users</button></form>
        </c:when>
    </c:choose>
</div>

</body>
</html>
