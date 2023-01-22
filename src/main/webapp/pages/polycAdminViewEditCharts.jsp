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

<div class="for_caption" style="margin: 40px"><h1 class="caption">List of doctors</h1></div>

<div class="scrollit" style="margin-bottom: 40px">
  <div class="list-div">
    <table>
      <thead class="thead-list">
      <tr>
        <td>Doctors</td>
        <td style="width: 10px;">Action</td>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${listOfDoctorCharts}" var="doctor">
      <tr>
          <td><div class="user">
          <b>Doctor name</b><br>
          <span class="name"><c:out value="${doctor.getDoctor().getUser().getName()}"/></span><br>
          <b>Specialization:</b>
          <span class="specialization"><c:out value="${doctor.getDoctor().getSpecialization()}"/></span><br>
          <div style="display: none"><b>Id:</b> <span class="id"><c:out value="${doctor.getDoctor().getUser().getId()}"/></span><br></div>
        </div></td>

        <td>
          <form action="" method="post">
            <input hidden name="id" value="<c:out value="${doctor.getDoctor().getUser().getId()}"/>">
            <input class="default-button" type="submit" value="Edit charts" style="width: auto">
          </form>
        </td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<%--<div id="checkchartsform" class="container-form" style="margin-top: 50px;">--%>
<%--  <div class="form-box">--%>
<%--    <h2 style="margin: 0">Doctors charts for week</h2>--%>

<%--    <div id="chartsform" class="edit-form">--%>
<%--      <div class="form-group">--%>
<%--      </div>--%>
<%--      <div class="form-group">--%>
<%--        <div class="scrollit">--%>
<%--          <div class="list-div" style="width: 100%;">--%>
<%--            <table>--%>
<%--              <thead class="thead-list">--%>
<%--              <tr>--%>
<%--                <td>Day of week</td>--%>
<%--                <td style="width: 30px;">From</td>--%>
<%--                <td style="width: 30px;">To</td>--%>
<%--                <td style="width: 10px;">Action</td>--%>
<%--              </tr>--%>
<%--              </thead>--%>
<%--              <tbody>--%>

<%--              <tr>--%>
<%--                <form>--%>
<%--                  <td><div><b>Monday</b><br></div></td>--%>
<%--                  <td hidden><input id="dayid" name="dayid" value=""></td>--%>
<%--                  <td hidden><input id="doctorid" name="doctorid" value=""></td>--%>
<%--                  <td><input id="fromto" name="fromto" class="time" type="time" value="13:00" style="width: auto"></td>--%>
<%--                  <td><input id="timeto" name="timeto" class="time" type="time" value="17:00" style="width: auto"></td>--%>
<%--                  <td><input class="default-button" type="submit" value="Submit" style="width: auto"></td>--%>
<%--                </form>--%>
<%--              </tr>--%>
<%--              </tbody>--%>
<%--            </table>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </div>--%>

<%--    <div>--%>
<%--      <!--      <form>-->--%>

<%--      <!--          <input class="submit" type="submit" value="Submit">-->--%>
<%--      <!--      </form>-->--%>
<%--    </div>--%>

<%--    <input class="closed" type="button" value="Close form" onclick="closeChartsForm()">--%>
<%--  </div>--%>
<%--</div>--%>

<script src="../js/script.js"></script>
<script src="../js/polycAdmin.js"></script>
</body>
</html>