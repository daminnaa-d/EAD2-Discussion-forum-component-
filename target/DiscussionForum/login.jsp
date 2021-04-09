<%--
  Created by IntelliJ IDEA.
  User: D.Dilara
  Date: 08.02.2021
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="resources/formstyle.css" rel="stylesheet">
    <title>Login</title>
</head>
<body>
<a href="index.jsp">Home</a>
    <form action="login" method="post">
        <div class="container">
            <h2>Login</h2>
            <div classs="field">
                <label for="email">Email</label>
                <input type="text" placeholder="Enter email" id="email" name="email" required>
            </div>
            <div classs="field">
                <label for="pswd">Password</label>
                <input type="password" placeholder="Enter password" id="pswd" name="pswd" required>
            </div>
            <hr>
            <p> Not registered yet? <a href="registration.jsp">Register</a> </p>
            <input type="submit" class="btn" value="Log In">
        </div>

    </form>
</body>
</html>
