<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PolyAdmin</title>
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <style><jsp:include page="../css/style.css"/></style>
</head>
<body style="height: 100%">

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<div id="reqForm" class="container-form" style="margin-top: 50px; display: flex;">
    <div class="form-box">
        <h2 style="margin: 0">Information about requests n.<c:out value="${requestDetails.getVacationRequestList().get(0).getId()}"/></h2>

        <div id="checkform" class="edit-form">
            <div class="form-group">
            </div>

            <div class="form-group">
                <label>
                    Name
                </label>
                <input
                        type="text"
                        name="name"
                        required
                        disabled
                        value="<c:out value="${requestDetails.getDoctor().getUser().getName()}"/>"
                >
            </div>

            <div class="form-group">
                <label>
                    Specialization
                </label>
                <input
                        type="text"
                        name="specialization"
                        required
                        disabled
                        value="<c:out value="${requestDetails.getDoctor().getSpecialization()}"/>"
                >
            </div>

            <div class="form-group">
                <label>
                    Reason
                </label>
                <input
                        type="text"
                        name="reason"
                        required
                        style="width: 100%"
                        disabled
                        value="<c:out value="${requestDetails.getVacationRequestList().get(0).getRequest()}"/>"
                >
            </div>

            <div id="doctorFormAddForm" style="display: flex">
                <div class="form-group">
                    <label>
                        From
                    </label>
                    <input
                            type="date"
                            name="from"
                            required
                            disabled
                            style="margin-top: 10px; width: auto; font-size: 15px; background: white;"
                            value="<c:out value="${requestDetails.getVacationRequestList().get(0).getDate_from()}"/>"
                    >
                </div>

                <div class="form-group">
                    <label>
                        To
                    </label>
                    <input
                            type="date"
                            name="to"
                            required
                            disabled
                            style="margin-top: 10px; width: auto; font-size: 15px; background: white;"
                            value="<c:out value="${requestDetails.getVacationRequestList().get(0).getDate_to()}"/>"
                    >
                </div>
            </div>

            <div class="form-group">
                <label style="margin-bottom: 10px; margin-top: 40px">
                    Doctors appointments
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
                            <c:forEach items="${doctorAppointments}" var="appointment">
                            <tr>
                                <td><div class="user"><b>Patient name</b><br><c:out value="${appointment.getPatient().getName()}"/></div></td>
                                <td><input  type="datetime-local"  value="<c:out value="${appointment.getFromTime()}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;" disabled>
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

        <div>
            <form action="approveVacation" method="post">
                <input hidden name="id" value="<c:out value="${requestDetails.getVacationRequestList().get(0).getId()}"/>" style="font-size: 15px">
                <input hidden name="request" value="<c:out value="${requestDetails.getVacationRequestList().get(0).getRequest()}"/>" style="font-size: 15px">
                <input hidden name="date_from" value="<c:out value="${requestDetails.getVacationRequestList().get(0).getDate_from()}"/>" style="font-size: 15px">
                <input hidden name="date_to" value="<c:out value="${requestDetails.getVacationRequestList().get(0).getDate_to()}"/>" style="font-size: 15px">
                <input style="width: 40%" class="submit" type="submit" value="Approve">
            </form>
            <form action="rejectVacation" method="post">
                <input hidden name="id" value="<c:out value="${requestDetails.getVacationRequestList().get(0).getId()}"/>" style="font-size: 15px">
                <input style="width: 40%" class="closed" type="submit" value="Reject">
            </form>
        </div>

        <form action="polycAdminVacationRequestApprove"><input class="closed" type="submit" value="Back to requests list" style="width: 50%"></form>
    </div>
</div>
<br>
</body>
</html>