<%--
  Created by IntelliJ IDEA.
  User: nikit
  Date: 05.12.2022
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<nav>
    <label class="logo">Polyclinic</label>
    <ul>
<%--        <li class="hello"> Hello ${user.getName()}!</li>--%>
        <li><b class="active" href="#">${user.getName()}</b></li>
        <form action="signOut" method="post"><li><button class="header-button">Sign out</button></li></form>
    </ul>
</nav>
</body>
</html>
