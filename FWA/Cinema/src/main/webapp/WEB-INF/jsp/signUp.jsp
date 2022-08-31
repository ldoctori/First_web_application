<%--
  Created by IntelliJ IDEA.
  User: ldoctori
  Date: 30.08.2022
  Time: 08:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h1>Registration</h1>

<form action = "signUp" method = "POST">
    First Name: <input type = "text" name = "first_name">
    <br />
    Last Name: <input type = "text" name = "password" />
    <input type = "submit" value = "Submit" />
</form>

</body>
</html>
