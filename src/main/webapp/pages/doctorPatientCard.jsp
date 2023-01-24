<%@ page import="ru.rsreu.polyclinic.enums.Gender" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Doctor</title>
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body style="height: 100%">

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<div id="checkForm" class="container-form" style="margin-top: 50px; display: flex;">
    <div class="form-box">
        <h2 style="margin: 0">Information about patient</h2>

        <div id="checkform" class="edit-form">
            <div class="form-group">
            </div>
            <div class="form-group">
                <label>
                    Name
                </label>
                <input
                        type="text"
                        id="reason"
                        required
                        disabled
                        value="<c:out value="${patientObj.getName()}"/>"
                >
            </div>

            <div class="form-group">
                <label>
                    Gender
                </label>
                <div style="margin-top: 10px">
                    <c:if test="${patientObj.getGender().equals(Gender.MALE.getGender())}">
                    <label style="margin: 10px" class="radio-inline" onclick="maleRbOnClick()">
                        <input id="addMaleRB" type="radio" name="optradio" checked>Male
                    </label>
                    <label style="margin: 10px" class="radio-inline" onclick="femaleRbOnClick()">
                        <input id="addFemaleRB" type="radio" name="optradio" disabled>Female
                    </label>
                    </c:if>
                    <c:if test="${patientObj.getGender().equals(Gender.FEMALE.getGender())}">
                        <label style="margin: 10px" class="radio-inline" onclick="maleRbOnClick()">
                            <input id="addMaleRB" type="radio" name="optradio" disabled>Male
                        </label>
                        <label style="margin: 10px" class="radio-inline" onclick="femaleRbOnClick()">
                            <input id="addFemaleRB" type="radio" name="optradio" checked>Female
                        </label>
                    </c:if>
                </div>
            </div>

            <div class="form-group">
                <label>
                    Birth Date
                </label>
                <input
                        type="date"
                        id="time_from"
                        required
                        style="margin-top: 10px; width: 25%; font-size: 20px; background: white;"
                        value="<c:out value="${patientObj.getBirthDay()}"/>"
                        disabled
                >
            </div>

            <div class="form-group">
                <label>
                    Phone number
                </label>
                <input
                        type="text"
                        id="reason"
                        required
                        disabled
                        value="<c:out value="${patientObj.getPhoneNumber()}"/>"
                >
            </div>

            <div class="form-group">
                <label>
                    Address
                </label>
                <input
                        type="text"
                        id="reason"
                        required
                        disabled
                        value="<c:out value="${patientObj.getAddress()}"/>"
                >
            </div>

        </div>
    </div>
</div>

<div class="for_caption" style="margin: 40px"><h1 class="caption">Previous recordings</h1></div>


<div class="scrollit">
    <div class="list-div">
        <table style="width: 100%">
            <thead class="thead-list">
            <tr>
                <td>Record</td>
                <!--        <td>Status</td>-->
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${patientRecords}" var="record">
                <tr>
                    <td><div class="user">
                        <b>Doctor name: </b> <span class="name"><c:out value="${record.getDoctor().getUser().getName()}"/></span> <br>
                        <b>Specialization: </b> <span class="name"><c:out value="${record.getDoctor().getSpecialization()}"/></span> <br>
                        <b>Appointments time: </b><input type="datetime-local" value="<c:out value="${record.getTime()}"/>" style="margin-top: 10px; width: 20%; font-size: 15px; background: white;" disabled>  <br>
                        <b>Diagnosis: </b> <span class="name"><c:out value="${record.getDiagnosis()}"/></span> <br>
                        <b>Course: </b> <span class="name"><c:out value="${record.getTreatmentCourse()}"/></span> <br>
                    </div></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<br>

<div class ="container-button" style="height: 80px">
    <button id="formButton" class="button" role="button" style="width: 30%" onclick="displayForm()">Create record</button>
</div>

<div id="createForm" class="container-form" style="margin-top: 50px; display: none;">
    <div class="form-box">
        <h2 style="margin: 0">Create new record</h2>
        <div id="checkform" class="edit-form">
            <div class="form-group">
            </div>
            <form>
            <div class="form-group">
                <label>
                    Diagnosis
                </label>
                <input
                        type="text"
                        id="diagnosis"
                        required
                >
            </div>

            <div class="form-group">
                <label>
                    Course
                </label>
                <input
                        type="text"
                        id="treatmentCourse"
                        required
                >
            </div>
                <input id="required" style="width: 40%; display: none" class="submit" type="submit" value="Submit">
            </form>
            <div><form id="actionForm" action="addRecord" method="post">
                <input hidden name="id" style="font-size: 15px" value="<c:out value="${patientObj.getId()}"/>" required>
                <input hidden name="diagnosis" style="font-size: 15px" required>
                <input hidden name="treatmentCourse" style="font-size: 15px" required>
                <input style="width: 40%" class="submit" type="submit" value="Submit" onclick="dataToAction()">
            </div></form>
        </div>

        <input class="closed" type="button" value="Close form" onclick="closeForm()">
    </div>
</div>

<br>
<script src="../js/doctorCheckCard.js"></script>
</body>
</html>