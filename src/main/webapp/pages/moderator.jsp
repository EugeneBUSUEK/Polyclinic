<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit users blocked status</title>
    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<%
  List<List<String>> rs = (List<List<String>>) request.getAttribute("listOfUsers");
  String username = "username";
  String name = "name";
  String role = "role";
  String blocked = "blocked";
%>


<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<div class="for_caption"><h1 class="caption">List of user</h1></div>

<div class="scrollit">
  <form class="list-form">
    <table>
      <thead class="thead-list">
      <tr>
        <td>User</td>
        <td>Status</td>
        <td>Action</td>
      </tr>
      </thead>
      <c:forEach items="${rs}" var="user">
      <tbody>
      <tr>
        <td><div class="user"><b>Username:</b> <c:out value="${user.get(1)}"/> <br>
          <b>Name:</b><c:out value="${user.get(2)}"/> <br>
          <b>Role:</b> <c:out value="${user.get(3)}"/> <br></div></td>
        <td>Offline</td>
        <td>
          <c:if test="${user.get(4).equals(BlockedCondition.BLOCKED.getBlockedCondition())}">
            <input class="unblocked-button" type="submit" value="Unblocked">
          </c:if>
          <c:if test="${!user.get(4).equals(BlockedCondition.UNBLOCKED.getBlockedCondition())}">
            <input class="blocked-button" type="submit" value="Blocked">
          </c:if>
        </td>
      </tr>
      </tbody>
      </c:forEach>
    </table>
  </form>
</div>

<br>

<div class="error-alert" style="margin-bottom: 20px" hidden>
  <div class="alert">User is blocked</div>
</div>

<div class="error-alert" style="margin-bottom: 20px" hidden>
  <div class="alert">User is unblocked</div>
</div>

</body>
</html>

</body>
</html>
