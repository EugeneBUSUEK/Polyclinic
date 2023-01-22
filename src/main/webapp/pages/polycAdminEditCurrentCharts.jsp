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
<%--                            <c:forEach items="${doctorChart}" var="chart">--%>
                            <tr>
                                    <td><div><b><span class="day">Monday</span><br></b>
                                        <br></div></td>

                                    <form id="actionForm" action="editChart" method="post">

                                    <td><input id="timefrom" name="from_time" class="time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(1)}"/>" style="width: auto"></td>
                                    <td><input id="timeto" name="to_time" class="time" type="time" value="<c:out value="${doctorChart.getChart().getTo(1)}"/>" style="width: auto"></td>

                                    <td>
                                        <input hidden id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">
                                        <input hidden id="day" name="day" value="1">
<%--                                        <input  id="from_time" name="from_time">--%>
<%--                                        <input  id="to_time" name="to_time">--%>
<%--                                        <input class="default-button" type="button" value="check" style="width: auto">--%>
                                        <input class="default-button" type="submit" value="Submit" style="width: auto">
                                        </form>
                                    </td>
                            </tr>

<%--                            <tr>--%>
<%--                                <td><div><b><span class="day">Monday</span><br>--%>
<%--                                </b><br></div></td>--%>

<%--                                <td><input id="timefrom" name="fromto" class="time" type="time" value="<c:out value="${doctorChart.getChart().getFrom(1)}"/>" style="width: auto"></td>--%>
<%--                                <td><input id="timeto" name="timeto" class="time" type="time" value="<c:out value="${doctorChart.getChart().getTo(1)}"/>" style="width: auto"></td>--%>

<%--                                <td>--%>
<%--                                    <form id="actionForm" action="editChart" method="post">--%>
<%--                                        <input  id="id" name="id" value="<c:out value="${doctorChart.getDoctor().getUser().getId()}"/>">--%>
<%--                                        <input  id="day" name="day" value="1">--%>
<%--                                        <input  id="from_time" name="from_time">--%>
<%--                                        <input  id="to_time" name="to_time">--%>
<%--                                        <input class="default-button" type="button" value="check" style="width: auto">--%>
<%--                                        <input class="default-button" type="submit" value="Submit" style="width: auto">--%>
<%--                                    </form>--%>
<%--                                </td>--%>
<%--                            </tr>--%>
<%--                            </c:forEach>--%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

<%--        <input class="closed" type="button" value="Close form" onclick="closeChartsForm()">--%>
    </div>
</div>

<script src="../js/script.js"></script>
<script src="../js/polycAdminEditCurrentCharts.js"></script>
</body>
</html>