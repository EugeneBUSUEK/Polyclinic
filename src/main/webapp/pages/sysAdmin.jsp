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
<body style="height: 100%">
<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>
<div class="for_caption"><h1 class="caption" style="margin: 40px">List of user</h1></div>

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
            <c:forEach items="${listOfUsersAdmin}" var="user">
                <tr>
                    <td><div class="user">
                        <b>Username:</b> <span class="username"><c:out value="${user.getUser().getLogin()}"/></span> <br>
                        <b>Name:</b> <span class="name"><c:out value="${user.getUser().getName()}"/></span> <br>
                        <b>Role:</b> <span class="role"><c:out value="${user.getUser().getRole()}"/></span> <br>
                        <div style="display: none"><b>Password:</b> <span class="password"><c:out value="${user.getUser().getPassword()}"/></span><br></div>
                        <div style="display: none"><b>Specialization:</b> <span class="specialization"><c:out value="${user.getSpecialization()}"/></span><br></div>
                        <div style="display: none"><b>Cabinet:</b> <span class="cabinet"><c:out value="${user.getCabinet()}"/></span><br></div>
                        <div style="display: none"><b>Id:</b> <span class="id"><c:out value="${user.getUser().getId()}"/></span><br></div>
                    </div></td>

                    <td>VstaVIT STATUS</td>
<%--                    <c:out value="${user.getStatus()}"/>--%>

                    <td><input class="default-button" type="button" value="Edit">
                        <form action="deleteUser" method="post" style="display: contents">
                            <input type="hidden" name="id" value="<c:out value="${user.getUser().getId()}"/>"/>
                            <input type="hidden" name="username" value="<c:out value="${user.getUser().getLogin()}"/>"/>
                            <input class="blocked-button" type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
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
                <form>
                    <div class="form-group">
                        <label>
                            Role
                        </label>
                        <div style="margin-top: 10px">
                            <label style="margin: 10px" class="radio-inline" onclick="moderRbAddOnClick()">
                                <input id="addModerRB" type="radio" name="optradio" required>Moderator
                            </label>
                            <label style="margin: 10px" class="radio-inline" onclick="sysAdminRbAddOnClick()">
                                <input id="addSysAdminRB" type="radio" name="optradio">System Administrator
                            </label>
                            <label style="margin: 10px" class="radio-inline" onclick="polycAdminRbAddOnClick()">
                                <input id="addPolycAdminRB" type="radio" name="optradio">Polyclinic Administrator
                            </label>
                            <label style="margin: 10px" class="radio-inline" onclick="doctorRbAddOnClick()">
                                <input id="addDoctorRb" type="radio" name="optradio">Doctor
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
                                id="username"
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
                                id="password"
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
                                id="name"
                        >
                    </div>

                    <div class="form-group" hidden>
                        <label>
                            ROLE
                        </label>
                        <input
                                type="text"
                                name="role"
                                required
                                id="role"
                        >
                    </div>

                    <div id="doctorFormAddForm" style="display: none">
                        <div class="form-group">
                            <label>
                                Specialization
                            </label>
                            <input
                                    type="text"
                                    name="specialization"
                                    placeholder="Specialization"
                                    required
                                    id="spec"
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
                                    id="cabinet"
                            >
                        </div>
                    </div>
                    <input id="required" class="submit" type="submit" value="Submit" style="display: none">
                </form>

                <form id="actionAddForm" action="addUser" method="post">
                    <input type="hidden" name="username" required/>
                    <input type="hidden" name="password" required/>
                    <input type="hidden" name="name" required/>
                    <input type="hidden" name="role" required/>
                    <input type="hidden" name="spec" required/>
                    <input type="hidden" name="cabinet" required/>
                    <input class="submit" type="submit" value="Submit" onclick="dataToActionAdd()" >
                </form>
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
                <form>
                <div class="form-group">
                    <label>
                        Role
                    </label>

                    <div style="margin-top: 10px">
                        <label style="margin: 10px" onclick="moderRbOnClick()">
                            <input id="moderRB" type="radio" name="optradio">Moderator
                        </label>
                        <label style="margin: 10px" onclick="sysAdminRbOnClick()">
                            <input id="sysAdminRB" type="radio" name="optradio">System Administrator
                        </label>
                        <label style="margin: 10px" onclick="polycAdminRbOnClick()">
                            <input id="polycAdminRB" type="radio" name="optradio">Polyclinic Administrator
                        </label>
                        <label style="margin: 10px" onclick="doctorRbOnClick()">
                            <input id="doctorRB" type="radio" name="optradio">Doctor
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label>
                        Username
                    </label>
                    <input
                            type="text"
                            name="username"
                            required
                            id="username"
                    >
                </div>

                <div class="form-group">
                    <label>
                        Password
                    </label>
                    <input
                            type="text"
                            name="password"
                            required
                            id="password"
                    >
                </div>

                <div class="form-group">
                    <label>
                        Name
                    </label>
                    <input
                            type="text"
                            name="name"
                            required
                            id="name"
                    >
                </div>

                    <div class="form-group" hidden>
                        <label>
                            ID
                        </label>
                        <input
                                type="text"
                                name="id"
                                required
                                id="id"
                        >
                    </div>

                    <div class="form-group" hidden>
                        <label>
                            ROLE
                        </label>
                        <input
                                type="text"
                                name="role"
                                required
                                id="role"
                        >
                    </div>

                <div id="doctorFormEditForm" style="display: none">
                    <div class="form-group">
                        <label>
                            Specialization
                        </label>
                        <input
                                type="text"
                                name="specialization"
                                required
                                id="spec"
                        >
                    </div>

                    <div class="form-group">
                        <label>
                            Cabinet
                        </label>
                        <input
                                type="text"
                                name="cabinet"
                                required
                                id="cabinet"
                        >
                    </div>
                </div>
                    <input id="requiredEdit" class="submit" type="submit" value="Submit" style="display: none">
                </form>
                <form id="actionForm" action="editUser" method="post">
                    <input type="hidden" name="id" required/>
                    <input type="hidden" name="username" required/>
                    <input type="hidden" name="password" required/>
                    <input type="hidden" name="name" required/>
                    <input type="hidden" name="role" required/>
                    <input type="hidden" name="spec" required />
                    <input type="hidden" name="cabinet" required/>
                    <input class="submit" type="submit" value="Submit" onclick="dataToAction()">
                </form>

                <input class="closed" type="button" value="Close form" onclick="closeEditForm()">
                </div>
            </div>
        </div>
<br>
<script src="../js/script.js"></script>
<script src="../js/sysAdmin.js"></script>
</body>
</html>
