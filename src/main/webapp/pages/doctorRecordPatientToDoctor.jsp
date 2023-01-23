<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PolyAdmin</title>
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<div class="for_caption" style="margin: 40px"><h1 class="caption">List of Doctors</h1></div>

<div class="scrollit" id="doctorList" style="display: none">
    <div class="list-div">
        <table>
            <thead class="thead-list">
            <tr>
                <td>Doctor</td>
                <td style="width: 10px;">Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${doctorList}" var="doctor">
                <tr>
                    <td><div class="user">
                        <b>Name </b><span class="doctor_name"><c:out value="${doctor.getUser().getName()}"/></span><br>
                        <b>Specialization </b><span class="doctor_spec"><c:out value="${doctor.getSpecialization()}"/></span>
                        <span class="doctor_id" hidden><c:out value="${doctor.getUser().getId()}"/></span>
                    </div>
                    </td>

                    <td>
                        <input class="default-button" type="button" value="Appointments" style="width: auto">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<br>

<div id="checkForm" class="container-form" style="display: none">
    <div class="form-box">
        <h2 style="margin: 0">Information about appointment</h2>

        <div class="edit-form" id="edit-form">
            <div class="form-group">
            </div>

            <form>
                <div class="form-group">
                    <label>
                        Patient Name
                    </label>
                    <input
                            type="text"
                            name="name"
                            required
                            id="paietntName"
                            disabled
                    >
                </div>

                <div class="form-group">
                    <label>
                        Patient phone number
                    </label>
                    <input
                            type="text"
                            name="birth"
                            required
                            id="patientPhone"
                            disabled
                    >
                </div>

                <div class="form-group">
                    <label>
                        Doctor name
                    </label>
                    <input
                            type="text"
                            name="phone"
                            required
                            id="doctorName"
                            disabled
                    >
                </div>

                <div class="form-group">
                    <label>
                        Doctor specialization
                    </label>
                    <input
                            type="text"
                            name="address"
                            required
                            id="doctorSpec"
                            disabled
                    >
                </div>

                <input id="required" type="submit" class="submit" value="Submit" style="display: none">
            </form>

            <form id="actionForm" action="setAppointment" method="post">
                <input name="patient_name"  required/>
                <input name="phone"  required/>
                <input name="patient_id"  required/>
                <input name="doctor_name"  required/>
                <input name="spec"  required/>
                <input name="doctor_id"  required/>

                <input class="submit" type="submit" value="Create Appointment">
            </form>
        </div>
    </div>
</div>

<br>
<script src="../js/polycAdminCreateRecord.js"></script>
</body>
</html>