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
            <form action="doctorCheckAppointments" method="post"><button class="button" role="button">Check appointments</button></form>
            <form action="doctorCheckVacationRequests" method="post"><button class="button" role="button">Check & Create vacation request</button></form>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.MODERATOR.getRole())}">
            <form action="moderator"><button class="button" role="button">Edit users blocked status</button></form>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.POLYCLINIC_ADMINISTRATOR.getRole())}">
            <form action="editOutpatientCards" method="post"><button class="button" role="button">Edit & Add patient card</button></form>
            <form action="polycAdminEditCharts" method="post"><button class="button" role="button">Edit charts for doctors</button></form>
            <form action="polycAdminVacationRequestApprove" method="post"><button class="button" role="button">Vacation request approve</button></form>
            <form action="polycAdminRecordPatient" method="post"><button class="button" role="button">Create Record a patient to doctors</button></form>
        </c:when>
        <c:when test="${user.getRole().equals(RoleType.SYSTEM_ADMINISTRATOR.getRole())}">
            <form action="sysAdmin"><button class="button" role="button">Edit & Add users</button></form>
        </c:when>
    </c:choose>
</div>

</body>
</html>
