<%--
  Created by IntelliJ IDEA.
  User: ldoctori
  Date: 04.09.2022
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>

<center>
<h1>Hello!</h1>


            <h5>Please, sign in</h5>

            <form action = "" method = "POST">
                <table width="50%" cellspacing="0" cellpadding="2">
                   <tr>
                       <td> Email or first name</td>
                       <td> <input type = "text" name = "EorFN"> </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type = "text" name = "password" /></td>
                    </tr>
                    <tr>
                        <input type = "submit" value = "Submit" />
                    </tr>
                </table>
            </form>
            <h5>or</h5>

    <li><a href="signUp">Sign up</a></li>

</center>
</body>
</html>
