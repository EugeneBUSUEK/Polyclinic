<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit & Add users</title>
    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>
<div class="for_caption"><h1 class="caption">List of user</h1></div>

<div class="scrollit">
    <div class="list-div">
        <table style="width: 100%">
            <thead class="thead-list">
            <tr>
                <td>User</td>
                <td>Status</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><div class="user">
                    <b>Username:</b> <span class="username">ghci</span> <br>
                    <b>Name:</b> <span class="name">Billy Haskellton</span> <br>
                    <b>Role:</b> <span class="role">Moderator</span> <br>
                    <div style="display: none"><b>Password:</b> <span class="password">qwerty5</span><br></div>
                    <div style="display: none"><b>Specialization:</b> <span class="specialization">null</span><br></div>
                    <div style="display: none"><b>Cabinet:</b> <span class="cabinet">null</span><br></div>
                </div></td>
                <td>Offline</td>
                <td><input class="default-button" type="button" value="Edit">
                    <form style="display: contents"><input class="blocked-button" type="submit" value="Delete"></form>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</div>

<br>

<!-- -&#45;&#45;-->

<div class="error-alert" hidden>
    <div class="error">User is not created, please edit username</div>
</div>

<div class="error-alert" hidden>
    <div class="error">User is not changed, please edit username</div>
</div>

<div class="error-alert" hidden>
    <div class="successful">User is created</div>
</div>

<div class="error-alert" hidden>
    <div class="successful">User is changed</div>
</div>

<div class="error-alert" hidden>
    <div class="alert">User is deleted</div>
</div>

<!-- -&#45;&#45;-->

<div class ="container-button" style="height: 80px">
    <button id="formButton" class="button" role="button" onclick="displayAddForm()" style="width: 30%">Add user</button>
</div>

<!-- -&#45;&#45;-->

<div id="addForm" class="container-form">
    <div class="form-box">
        <h2 style="margin: 0">Add new user</h2>

        <div class="edit-form" id="add-form">
            <div class="form-group">
            </div>

            <div class="form-group">
                <label>
                    Role
                </label>
                <div style="margin-top: 10px">
                    <label style="margin: 10px" class="radio-inline" onclick="hiddenDoctorFormAdd()">
                        <input type="radio" name="optradio" checked>Moderator
                    </label>
                    <label style="margin: 10px" class="radio-inline" onclick="hiddenDoctorFormAdd()">
                        <input type="radio" name="optradio">System Administrator
                    </label>
                    <label style="margin: 10px" class="radio-inline" onclick="hiddenDoctorFormAdd()">
                        <input type="radio" name="optradio">Polyclinic Administrator
                    </label>
                    <label style="margin: 10px" class="radio-inline" onclick="displayDoctorFormAdd()">
                        <input type="radio" name="optradio">Doctor
                    </label>
                </div>
            </div>

            <div class="form-group">
                <label for="username">
                    Username
                </label>
                <input
                        type="text"
                        name="username"
                        placeholder="Username"
                        required
                >
            </div>

            <div class="form-group">
                <label for="password">
                    Password
                </label>
                <input
                        type="text"
                        name="password"
                        placeholder="Password"
                        required
                >
            </div>

            <div class="form-group">
                <label for="name">
                    Name
                </label>
                <input
                        type="text"
                        name="name"
                        placeholder="Name"
                        required
                >
            </div>

            <div id="doctorFormAddForm" style="display: none">
                <div class="form-group">
                    <label for="specialization">
                        Specialization
                    </label>
                    <input
                            type="text"
                            name="specialization"
                            placeholder="Specialization"
                            required
                    >
                </div>

                <div class="form-group">
                    <label for="cabinet">
                        Cabinet
                    </label>
                    <input
                            type="text"
                            name="cabinet"
                            placeholder="Cabinet"
                            required
                    >
                </div>
            </div>

            <form><input class="submit" type="submit" value="Submit"></form>
            <input class="closed" type="button" value="Close form" onclick="closeAddForm()">
            </div>
        </div>
    </div>

    <!-- -&#45;&#45;-->

    <div id="editForm" class="container-form">
        <div class="form-box">
            <h2 style="margin: 0">Edit information about user</h2>

            <div class="edit-form" id="edit-form">
                <div class="form-group">
                </div>

                <div class="form-group">
                    <label for="name">
                        Role
                    </label>
                    <div style="margin-top: 10px">
                        <label style="margin: 10px" onclick="hiddenDoctorFormEdit()">
                            <input id="moderRB" type="radio" name="optradio">Moderator
                        </label>
                        <label style="margin: 10px" onclick="hiddenDoctorFormEdit()">
                            <input id="sysAdminRB" type="radio" name="optradio">System Administrator
                        </label>
                        <label style="margin: 10px" onclick="hiddenDoctorFormEdit()">
                            <input id="polycAdminRB" type="radio" name="optradio">Polyclinic Administrator
                        </label>
                        <label style="margin: 10px" onclick="displayDoctorFormEdit()">
                            <input id="doctorRB" type="radio" name="optradio">Doctor
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="username">
                        Username
                    </label>
                    <input
                            type="text"
                            name="username"
                            required
                    >
                </div>

                <div class="form-group">
                    <label for="password">
                        Password
                    </label>
                    <input
                            type="text"
                            name="password"
                            required
                    >
                </div>

                <div class="form-group">
                    <label for="name">
                        Name
                    </label>
                    <input
                            type="text"
                            name="name"
                            required
                    >
                </div>

                <div id="doctorFormEditForm" style="display: none">
                    <div class="form-group">
                        <label for="specialization">
                            Specialization
                        </label>
                        <input
                                type="text"
                                name="specialization"
                                required
                        >
                    </div>

                    <div class="form-group">
                        <label for="cabinet">
                            Cabinet
                        </label>
                        <input
                                type="text"
                                name="cabinet"
                                required
                        >
                    </div>
                </div>

                <form><input class="submit" type="submit" value="Submit"></form>
                <input class="closed" type="button" value="Close form" onclick="closeEditForm()">
                </div>
            </div>
        </div>
        <script src="script.js"></script>
</body>
</html>
