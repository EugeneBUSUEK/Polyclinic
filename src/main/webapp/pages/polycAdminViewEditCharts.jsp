<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>PolyAdmin</title>
  <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
  <style><jsp:include page="../css/style.css"/></style>

</head>
<body style="height: 100vH">

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
          <b>Doctor name </b>
          <span class="name"><c:out value="${doctor.getUser().getName()}"/></span><br>
          <b>Specialization:</b>
          <span class="specialization"><c:out value="${doctor.getSpecialization()}"/></span><br>
          <div style="display: none"><b>Id:</b> <span class="id"><c:out value="${doctor.getUser().getId()}"/></span><br></div>
        </div></td>

        <td>
          <form action="viewEditCharts">
            <input hidden name="id" value="<c:out value="${doctor.getUser().getId()}"/>">
            <input hidden name="name" value="<c:out value="${doctor.getUser().getName()}"/>">
            <input class="default-button" type="submit" value="Edit charts" style="width: auto">
          </form>
        </td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<script src="../js/script.js"></script>
<script src="../js/polycAdmin.js"></script>
</body>
</html>