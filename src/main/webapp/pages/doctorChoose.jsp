<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PolyAdmin</title>
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body style="height: 100vH;">

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<div class="for_caption" style="margin: 30px"><h1 class="caption" style="width: 60%">The record was created successfully!</h1></div>

<div id="checkForm" class="container-form" style="display: flex; margin-top: 20px">
    <div class="form-box">
        <div style="text-align: center;"><span style="margin: 0;">Do you want to make an appointment for a repeat appointment or to see another doctor?</span></div>

        <div class="edit-form" id="edit-form">
            <form id="actionForm" action="startReappointment" method="post">
                <input class="submit" type="submit" value="Create Appointment">
                <input class="closed" style="width: 60%" type="submit" value="Back to profile">
            </form>
        </div>
    </div>
</div>
</body>
</html>