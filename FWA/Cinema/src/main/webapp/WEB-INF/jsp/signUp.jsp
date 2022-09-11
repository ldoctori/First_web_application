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
<center>
<h1>Registration</h1>

<form action = "signUp" method = "POST">
    <table width="50%" cellspacing="0" cellpadding="2">
        <tr>
            <td> First Name: </td>
            <td> <input type = "text" name = "first_name"> </td>
        </tr>
        <tr>
            <td> Last Name: </td>
            <td> <input type = "text" name = "last_name"> </td>
        </tr>
        <tr>
            <td> Email: </td>
            <td> <input type = "text" name = "email"> </td>
        </tr>
        <tr>
            <td> Phone number: </td>
            <td> <input type = "text" name = "phone"> </td>
        </tr>
        <tr>
            <td> Password: </td>
            <td> <input type = "text" name = "password" /> </td>
        </tr>
        <tr>
        <input type = "submit" value = "Submit" />
        </tr>
    </table>
</form>
</center>
</body>
</html>
