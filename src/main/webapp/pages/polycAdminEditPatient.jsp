<html lang="en">
<head>
    <title>Edit & Add users</title>
    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<%@include file="header.jsp" %>
<%@include file="buttons.jsp" %>

<div class="for_caption"><h1 class="caption">List of patient</h1></div>

<div class="scrollit">
    <div class="list-div">
        <table style="width: 100%">
            <thead class="thead-list">
            <tr>
                <td>Patient</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listOfPatients}" var="patient">
                <tr>
                    <td><div class="user">
                        <b>Name:</b> <span class="name"><c:out value="${patient.getName()}"/></span> <br>
                        <b>Phone number:</b> <span class="phone"><c:out value="${patient.getPhoneNumber()}"/></span> <br>
                        <div style="display: none"><b>Id:</b> <span class="id"><c:out value="${patient.getId()}"/></span><br></div>
                        <div style="display: none"><b>gender:</b> <span class="gender"><c:out value="${patient.getGender()}"/></span><br></div>
                        <div style="display: none"><b>birth:</b> <span class="birth"><c:out value="${patient.getBirthDay()}"/></span><br></div>
                        <div style="display: none"><b>address:</b> <span class="address"><c:out value="${patient.getAddress()}"/></span><br></div>
                    </div></td>

                    <td><input class="default-button" type="button" value="Edit">
                        <form action="deletePatient" method="post" style="display: contents">
                            <input type="hidden" name="id" value="<c:out value="${patient.getId()}"/>"/>
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
    <button id="formButton" class="button" role="button" onclick="displayAddForm()" style="width: 30%">Add patient</button>
</div>

<!-- -&#45;&#45;-->

<div id="addForm" class="container-form">
    <div class="form-box">
        <h2 style="margin: 0">Add new patient</h2>

        <div class="edit-form" id="add-form">
            <div class="form-group">
            </div>

            <form>
                <div class="form-group">
                    <label>
                        Gender
                    </label>
                    <div style="margin-top: 10px">
                        <label style="margin: 10px" class="radio-inline" onclick="maleRbAddOnClick()">
                            <input id="addMaleRB" type="radio" name="optradio" required>Male
                        </label>
                        <label style="margin: 10px" class="radio-inline" onclick="femaleRbAddOnClick()">
                            <input id="addFemaleRB" type="radio" name="optradio">Female
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label>
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

                <div class="form-group">
                    <label>
                        Birth Date
                    </label>
                    <input
                            type="text"
                            name="birth"
                            placeholder="Birth Date"
                            required
                            id="birth"
                    >
                </div>

                <div class="form-group">
                    <label>
                        Phone number
                    </label>
                    <input
                            type="text"
                            name="phone"
                            placeholder="Phone number"
                            required
                            id="phone"
                    >
                </div>

                <div class="form-group">
                    <label>
                        Address
                    </label>
                    <input
                            type="text"
                            name="address"
                            required
                            placeholder="Address"
                            id="address"
                    >
                </div>

                <div class="form-group" hidden>
                    <label>
                        Gender
                    </label>
                    <input
                            type="text"
                            name="gender"
                            required
                            placeholder="Address"
                            id="gender"
                    >
                </div>


                <input id="required" type="submit" class="submit" value="Submit" style="display: none">
            </form>

            <form id="actionAddForm" action="addPatient" method="post">
                <input name="name" style="display: none" required/>
                <input name="birth" style="display: none" required/>
                <input name="phone" style="display: none" required/>
                <input name="address" style="display: none" required/>
                <input name="gender" style="display: none" required/>
                <input class="submit" type="submit" value="Submit" onclick="dataToActionAdd()" >
            </form>
            <input class="closed" type="button" value="Close form" onclick="closeAddForm()">
        </div>
    </div>
</div>

<!-- -&#45;&#45;-->

<div id="editForm" class="container-form">
    <div class="form-box">
        <h2 style="margin: 0">Edit information about patient</h2>

        <div class="edit-form" id="edit-form">
            <div class="form-group">
            </div>

            <form>
                <div class="form-group">
                    <label>
                        Gender
                    </label>
                    <div style="margin-top: 10px">
                        <label style="margin: 10px" class="radio-inline" onclick="maleRbOnClick()">
                            <input id="addMaleRB" type="radio" name="optradio" required>Male
                        </label>
                        <label style="margin: 10px" class="radio-inline" onclick="femaleRbOnClick()">
                            <input id="addFemaleRB" type="radio" name="optradio">Female
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label>
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

                <div class="form-group">
                    <label>
                        Birth Date
                    </label>
                    <input
                            type="text"
                            name="birth"
                            placeholder="Birth Date"
                            required
                            id="birth"
                    >
                </div>

                <div class="form-group">
                    <label>
                        Phone number
                    </label>
                    <input
                            type="text"
                            name="phone"
                            placeholder="Phone number"
                            required
                            id="phone"
                    >
                </div>

                <div class="form-group">
                    <label>
                        Address
                    </label>
                    <input
                            type="text"
                            name="address"
                            required
                            placeholder="Address"
                            id="address"
                    >
                </div>

                <div class="form-group" hidden>
                    <label>
                        Gender
                    </label>
                    <input
                            type="text"
                            name="gender"
                            required
                            placeholder="Address"
                            id="gender"
                    >
                </div>


                <input id="required" type="submit" class="submit" value="Submit" style="display: none">
            </form>

            <form id="actionForm" action="editPatient" method="post">
                <input name="id" style="display: none" required/>
                <input name="name" style="display: none" required/>
                <input name="birth" style="display: none" required/>
                <input name="phone" style="display: none" required/>
                <input name="address" style="display: none" required/>
                <input name="gender" style="display: none" required/>
                <input class="submit" type="submit" value="Submit" onclick="dataToAction()" >
            </form>

            <input class="closed" type="button" value="Close form" onclick="closeEditForm()">
        </div>
    </div>
</div>
<script src="../js/script.js"></script>
<script src="../js/polycAdmin.js"></script>
</body>
</html>
