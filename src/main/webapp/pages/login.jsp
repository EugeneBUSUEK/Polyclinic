<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>

    <!-- BoxIcons v2.1.2 -->
    <link href="https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css" rel="stylesheet">

    <!-- Varela Round -->
    <link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">

    <!-- CSS File -->
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<header>
    <nav>
        <label class="logo">Polyclinic</label>
        <ul>
            <li><b class="active" href="#">Log In</b></li>
            <li><b href="#">Sign in</b></li>
        </ul>
    </nav>
</header>
<div class="container">
    <div class="login-box">
        <h2>Authorization</h2>

        <form>
            <div class="form-group">
                <label for="name">
                    Username
                </label>
                <i class="bx bxs-user"></i>
                <input
                        type="text"
                        id="name"
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
                        id="password"
                        placeholder="Your password"
                        required
                >
            </div>

            <input type="submit" value="Log In">

            <br></br>

            <!--           <div class="register">-->
            <!--               <a>Sign in?</a>-->
            <!--           </div>-->

        </form>

    </div>
</div>
</body>
</html>
