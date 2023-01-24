<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PolyAdmin</title>
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body style="height: 100%">

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<!--<div class="for_caption" style="margin: 40px"><h1 style="width: auto; font-size: 20px" class="caption">Appointments for Billy Haskellton</h1></div>-->

<div id="createForm" class="container-form" style="margin-top: 50px; display: flex;">
    <div class="form-box">
        <h2 style="margin: 0">Create appointments for <c:out value="${patient.getName()}"/></h2>

        <div id="checkform" class="edit-form">
            <div class="form-group">
            </div>
            <form>
                <div class="form-group">
                    <label>
                        Choose day
                    </label>
                    <input
                            type="date"
                            id="date"
                            required
                            style="margin-top: 10px; width: 20%; font-size: 15px; background: white;"
                    >
                </div>

                <div class="form-group">
                    <label>
                        From
                    </label>
                    <input
                            type="time"
                            id="time_from"
                            required
                            style="margin-top: 10px; width: 20%; font-size: 15px; background: white;"
                    >
                </div>

                <div class="form-group">
                    <label>
                        To
                    </label>
                    <input
                            type="time"
                            id="time_to"
                            required
                            style="margin-top: 10px; width: 20%; font-size: 15px; background: white;"
                    >
                </div>

                <div class="form-group" hidden>
                    <label>
                        patient_id
                    </label>
                    <input
                            type="text"
                            id="patient_id"
                            required
                            class="time"
                            style="margin-top: 10px; width: 20%"
                            value="<c:out value="${patient.getId()}"/>"
                    >
                </div>

                <div class="form-group" hidden>
                    <label>
                        doctor_id
                    </label>
                    <input
                            type="text"
                            id="doctor_id"
                            required
                            class="time"
                            style="margin-top: 10px; width: 20%"
                            value="<c:out value="${doctor.getUser().getId()}"/>"
                    >
                </div>
                <input id="required" style="width: 40%; display: none" class="submit" type="submit" value="Submit" >
            </form>

            <form id="actionForm" action="addAppointment" method="post">
                <input hidden name="date" style="font-size: 15px" required>
                <input hidden name="time_from" style="font-size: 15px" required>
                <input hidden name="time_to" style="font-size: 15px" required>
                <input hidden name="patient_id" style="font-size: 15px" required>
                <input hidden name="doctor_id" style="font-size: 15px" required>
                <input style="width: 40%" class="submit" type="submit" value="Submit" onclick="dataToAction()">
            </form>
            <br>
            <div class="form-group">
                <label style="margin-bottom: 10px; margin-top: 40px">
                    Appointments for <c:out value="${doctor.getUser().getName()}"/>
                </label>
                <div class="scrollit">
                    <div class="list-div" style="width: 100%;">
                        <table>
                            <thead class="thead-list">
                            <tr>
                                <td>Patient</td>
                                <td style="width: 30px;">From</td>
                                <td style="width: 30px;">To</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${appointmentList}" var="appointment">
                            <tr>
                                <td><div class="user"><b>Patient name</b><br><c:out value="${appointment.getPatient().getName()}"/></div></td>
                                <td><input type="datetime-local" value="<c:out value="${appointment.getFromTime()}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;" disabled>
                                </td>
                                <td><input type="datetime-local" value="<c:out value="${appointment.getToTime()}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;" disabled>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <form action="polycAdminRecordPatient" method="post"><input class="closed" type="submit" value="Back to record"></form>

    </div>
</div>
<br>
<script src="../js/setAppo.js"></script>
</body>
</html>