<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Doctor</title>
  <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="../css/style.css">
</head>
<body style="height: 100Vh">

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<div class="for_caption" style="margin: 40px"><h1 class="caption">Previous requests </h1></div>

<div class="scrollit">
  <div class="list-div">
    <table style="width: 100%">
      <thead class="thead-list">
      <tr>
        <td>Request</td>
        <td>Status</td>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${doctorRequestList}" var="request">
        <tr>
          <td><div class="user">
            <b>Request №</b> <span class="name"><c:out value="${request.getId()}"/></span> <br>
            <b>Reason:</b> <span class="name"><c:out value="${request.getRequest()}"/></span> <br>
            <b>Date from</b> <input type="date" value="<c:out value="${request.getDate_from()}"/>" style="font-size: 15px; width: auto; text-align: center;" disabled>  <br>
            <b>Date to</b> <input type="date" value="<c:out value="${request.getDate_to()}"/>" style="font-size: 15px; width: auto; text-align: center;" disabled>  <br>
          </div></td>

          <td>
            <c:if test="${request.isApproved() == true}">
            <input class="unblocked-button" type="button" value="Approved" disabled>
            </c:if>
            <c:if test="${request.isApproved() == false}">
            <input class="default-button" type="button" value="In waiting" disabled>
            </c:if>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<div class ="container-button" style="height: 80px">
  <button id="formButton" class="button" role="button" style="width: 30%" onclick="displayForm()">Create vacation request</button>
</div>


<div id="createForm" class="container-form" style="margin-top: 50px; display: none;">
  <div class="form-box">
    <h2 style="margin: 0">Create appointments for</h2>

    <div id="checkform" class="edit-form">
      <div class="form-group">
      </div>
      <form>
        <div class="form-group">
          <label>
            Reason
          </label>
          <input
                  type="text"
                  id="reason"
                  required
          >
        </div>

        <div class="form-group">
          <label>
            From
          </label>
          <input
                  type="date"
                  id="time_from"
                  required
                  class="time"
                  style="margin-top: 10px; width: 25%"
          >
        </div>

        <div class="form-group">
          <label>
            To
          </label>
          <input
                  type="date"
                  id="time_to"
                  required
                  class="time"
                  style="margin-top: 10px; width: 25%"
          >
        </div>
        <input id="checkBt" style="width: 40%; display: none" class="submit" type="submit">
      </form>


      <div>
        <form id="actionForm" action="addVacationRequest" method="post">
        <input hidden name="reason" style="font-size: 15px" required>
        <input hidden name="time_from" style="font-size: 15px" required>
        <input hidden name="time_to" style="font-size: 15px" required>
        <input style="width: 40%" class="submit" type="submit" value="Submit" onclick="dataToAction()">
        </form>
      </div>
    </div>

    <input class="closed" type="button" value="Close form" onclick="closeForm()">
  </div>
</div>
<br>
<script src="../js/checkCreateVacation.js"></script>
</body>
</html>