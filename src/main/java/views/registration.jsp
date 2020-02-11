<%--
  Created by IntelliJ IDEA.
  User: Admin
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="RegistrationServlet" method="post">
    <label>Name:
        <input type="text" name="name"><br />
    </label>
    <label>Login:
        <input type="text" name="login"><br />
    </label>
    <label>Password:
        <input type="password" name="pass"><br />
    </label>
    <input type="submit" value="Create account">
    <input type="reset" value="Reset">
</form>
<div style="text-align: center"><a href="MainPageServlet">Back to main page</a></div>
</body>
</html>
