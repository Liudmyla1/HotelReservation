<%--
  Created by IntelliJ IDEA.
  User: Admin
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel reservation</title>
</head>
<body>
<form action="LoginServlet" method="post">
    <label>Login:
        <input type="text" name="login"><br />
    </label>
    <label>Password:
        <input type="password" name="pass"><br />
    </label>
    <label>
        <input type="checkbox" name="isAdmin">Admin<br />
    </label>
    <input type="submit" value="Login">
    <input type="reset" value="Reset">
</form>
<div style="text-align: center"><a href="MainPageServlet">Back to main page</a></div>
</body>
</html>
