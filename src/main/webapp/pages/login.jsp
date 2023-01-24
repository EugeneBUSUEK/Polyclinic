<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Log in</title>
    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
    <style><jsp:include page="../css/style.css"/></style>
</head>
<body style="height: 100vH">
<nav>
    <label class="logo">Polyclinic</label>
    <ul>
        <li><b class="active" href="#">Log In</b></li>
    </ul>
</nav>

<div class="container">
    <div class="login-box">
        <h2>Authorization</h2>

        <form class="login-form" action="login" method="post">
            <div class="form-group">
                <label for="name">
                    Username
                </label>
                <i class="bx bxs-user"></i>
                <input
                        type="text"
                        name="login"
                        placeholder="Your username"
                        required
                >
            </div>

            <div class="form-group">
                <label for="password">
                    Password
                </label>
                <i class="bx bxs-lock"></i>
                <input
                        type="password"
                        name="password"
                        placeholder="Your password"
                        required
                >
            </div>

            <div ${invalidAuth ? "" : "hidden"}>
                    <div class="error">Incorrect username or password!</div>
            </div>

            <input class="login" type="submit" value="Log In">

            <br>

        </form>
    </div>
</div>
</body>
</html>
