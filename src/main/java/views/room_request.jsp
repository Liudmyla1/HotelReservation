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
<form action="RoomRequestServlet" method="post">
    <label>Number of people:
        <input type="text" name="peopleNum"><br />
    </label>
    <label>Choose category:
        <select name="category">
            <option value="Standard" selected>Standard</option>
            <option value="Economy">Economy</option>
            <option value="Family Standard">Family Standard</option>
            <option value="Suite">Suite</option>
            <option value="Business Suite">Business Suite</option>
            <option value="Duplex">Duplex</option>
            <option value="Executive Suite">Executive Suite</option>
            <option value="King Suite">King Suite</option>
            <option value="Apartment">Apartment</option>
            <option value="De Luxe">De Luxe</option>
        </select>
    </label>
    <label>Check-in date:
        <input type="date" name="checkIn"><br />
    </label>
    <label>Check-out date:
        <input type="date" name="checkOut"><br />
    </label>
    <input type="submit" value="Order">
    <input type="reset" value="Reset">
</form>
<div style="text-align: center"><a href="MainPageServlet">Back to main page</a></div>
</body>
</html>
