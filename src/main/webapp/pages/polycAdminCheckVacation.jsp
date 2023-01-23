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

<div class="for_caption" style="margin: 40px"><h1 class="caption">List of requests</h1></div>

<div class="scrollit">
    <div class="list-div">
        <table>
            <thead class="thead-list">
            <tr>
                <td>Requests</td>
                <td style="width: 10px;">Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listOfRequestSet}" var="requests">
            <tr>
                <form action="checkVacationDetails" method="post">
                    <td><div class="user">
<%--                        <b>Request №</b> <input name="vacation_id" type="text" value="<c:out value="${requests.getVacationRequestList().get(0).getId()}"/>" style="font-size: 15px"><br>--%>
                        <b>Request from</b> <input name="name" type="text" value="<c:out value="${requests.getDoctor().getUser().getName()}"/>" style="font-size: 15px">
                        <input hidden name="id" type="text" value="<c:out value="${requests.getDoctor().getUser().getId()}"/>">
                    </div>
                    </td>

                    <td><input class="default-button" type="submit" value="Check Details" style="width: auto"></td>
                </form>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<br>
<script src="../js/script.js"></script>
</body>
</html>