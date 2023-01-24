<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PolyAdmin</title>
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <style><jsp:include page="../css/style.css"/></style>
</head>
<body style="height: 100vH;">

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<div id="checkchartsform" class="container-form" style="margin-top: 50px; display: flex">
    <div class="form-box">
        <h2 style="margin: 0">Doctors charts for week <c:out value="${doctorChart.getDoctor().getUser().getName()}"/></h2>

        <div id="chartsform" class="edit-form">
            <div class="form-group">
            </div>
            <div class="form-group">
                <div class="scrollit">
                    <div class="list-div" style="width: 100%;">
                        <table>
                            <thead class="thead-list">
                            <tr>
                                <td>Day of week</td>
                                <td style="width: 30px;">From</td>
                                <td style="width: 30px;">To</td>
                                <td style="width: 10px;">Action</td>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                    <td><div><b><span class="day">Monday</span></b></div></td>

                                    <form id="actionForm" action="editChart" method="post">

                                    <td><input id="timefrom" name="from_time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(1)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;" ></td>
                                    <td><input id="timeto" name="to_time" type="time" value="<c:out value="${doctorChart.getChart().getTo(1)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>

                                    <td>
                                        <input hidden id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">
                                        <input hidden id="day" name="day" value="1">
                                        <input class="default-button" type="submit" value="Submit" style="width: auto">
                                        </form>
                                    </td>
                            </tr>

                            <tr>
                                <td><div><b><span class="day">Tuesday</span></b></div></td>

                                <form id="actionForm" action="editChart" method="post">

                                    <td><input id="timefrom" name="from_time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(2)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>
                                    <td><input id="timeto" name="to_time" type="time" value="<c:out value="${doctorChart.getChart().getTo(2)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>

                                    <td>
                                        <input hidden id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">
                                        <input hidden id="day" name="day" value="2">
                                        <input class="default-button" type="submit" value="Submit" style="width: auto">
                                </form>
                                </td>
                            </tr>

                            <tr>
                                <td><div><b><span class="day">Wednesday</span></b></div></td>

                                <form id="actionForm" action="editChart" method="post">

                                    <td><input id="timefrom" name="from_time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(3)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>
                                    <td><input id="timeto" name="to_time" type="time" value="<c:out value="${doctorChart.getChart().getTo(3)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>

                                    <td>
                                        <input hidden id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">
                                        <input hidden id="day" name="day" value="3">
                                        <input class="default-button" type="submit" value="Submit" style="width: auto">
                                </form>
                                </td>
                            </tr>

                            <tr>
                                <td><div><b><span class="day">Thursday</span></b></div></td>

                                <form id="actionForm" action="editChart" method="post">

                                    <td><input id="timefrom" name="from_time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(4)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>
                                    <td><input id="timeto" name="to_time" type="time" value="<c:out value="${doctorChart.getChart().getTo(4)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>

                                    <td>
                                        <input hidden id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">
                                        <input hidden id="day" name="day" value="4">
                                        <input class="default-button" type="submit" value="Submit" style="width: auto">
                                </form>
                                </td>
                            </tr>

                            <tr>
                                <td><div><b><span class="day">Friday</span></b></div></td>

                                <form id="actionForm" action="editChart" method="post">

                                    <td><input id="timefrom" name="from_time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(5)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>
                                    <td><input id="timeto" name="to_time" type="time" value="<c:out value="${doctorChart.getChart().getTo(5)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>

                                    <td>
                                        <input hidden id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">
                                        <input hidden id="day" name="day" value="5">
                                        <input class="default-button" type="submit" value="Submit" style="width: auto">
                                </form>
                                </td>
                            </tr>

                            <tr>
                                <td><div><b><span class="day">Saturday</span></b></div></td>

                                <form id="actionForm" action="editChart" method="post">

                                    <td><input id="timefrom" name="from_time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(6)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>
                                    <td><input id="timeto" name="to_time" type="time" value="<c:out value="${doctorChart.getChart().getTo(6)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>

                                    <td>
                                        <input hidden id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">
                                        <input hidden id="day" name="day" value="6">
                                        <input class="default-button" type="submit" value="Submit" style="width: auto">
                                </form>
                                </td>
                            </tr>

                            <tr>
                                <td><div><b><span class="day">Sunday</span></b></div></td>

                                <form id="actionForm" action="editChart" method="post">

                                    <td><input id="timefrom" name="from_time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(0)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>
                                    <td><input id="timeto" name="to_time" type="time" value="<c:out value="${doctorChart.getChart().getTo(0)}"/>" style="margin-top: 10px; width: auto; font-size: 15px; background: white;"></td>

                                    <td>
                                        <input hidden id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">
                                        <input hidden id="day" name="day" value="0">
                                        <input class="default-button" type="submit" value="Submit" style="width: auto">
                                </form>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../js/script.js"></script>
<script src="../js/polycAdminEditCurrentCharts.js"></script>
</body>
</html>