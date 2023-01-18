<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit users blocked status</title>
    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<%--<%--%>
<%--  String unblocked = "unblocked";--%>
<%--  String blocked = "blocked";--%>
<%--%>--%>

<div class="for_caption"><h1 class="caption">List of user</h1></div>
<%--<div class="for_caption"><h1 class="caption"><c:out value="${listOfUsers.get(5).get(3)}"/></h1></div>--%>

<div class="scrollit">
  <div class="list-div">
    <table>
      <thead class="thead-list">
      <tr>
        <td>User</td>
        <td>Status</td>
        <td>Action</td>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${listOfUsers}" var="user">
      <tr>
        <td><div class="user"><b>Username:</b> <c:out value="${user.get(0)}"/> <br>
          <b>Name:</b> <c:out value="${user.get(1)}"/> <br>
          <b>Role:</b> <c:out value="${user.get(2)}"/> <br>
        </div></td>
        <td>Offline</td>
        <td style="width: 50%">
          <c:if test="${Integer.parseInt(user.get(3)) == 1}">
          <form action="blockUser" method="post" style="text-align: center; margin: auto;">
            <input type="hidden" name="username" value="<c:out value="${user.get(0)}"/>"/>
            <input type="hidden" name="isBlocked" value="<c:out value="${user.get(3)}"/>"/>
            <input class="unblocked-button" type="submit" value="Unblocked">
          </form>
          </c:if>

          <c:if test="${Integer.parseInt(user.get(3)) == 0}">
          <form action="blockUser" method="post" style="text-align: center; margin: auto;">
            <input type="hidden" name="username" value="<c:out value="${user.get(0)}"/>"/>
            <input type="hidden" name="isBlocked" value="<c:out value="${user.get(3)}"/>"/>
            <input class="blocked-button" type="submit" value="Blocked">
          </form>
          </c:if>

        </td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<br>

<div ${invalidModerBlock ? "" : "hidden"} class="error-alert" style="margin-bottom: 20px">
  <div class="alert">You cant block yourself</div>
</div>

<div class="error-alert" style="margin-bottom: 20px" hidden>
  <div class="alert">User is unblocked</div>
</div>

</body>
</html>

</body>
</html>
