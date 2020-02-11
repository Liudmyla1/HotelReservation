<%--
  Created by IntelliJ IDEA.
  User: Admin
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Hotel reservation</title>
  </head>
  <body>
    <div>
      <h1>Hotel reservation</h1>
    </div>
    <c:choose>
      <c:when test="${not empty request.getAttribute('login')}">
        <div style="text-align: right">Welcome, <%= request.getAttribute("login") %>
          <c:if test="${not empty request.getAttribute('userId')}">
            <% request.setAttribute("userId", request.getAttribute("userId")); %>
          </c:if>
          <a href="LogoutServlet">Logout</a></div>
        <button href="UserRequestsServlet" method="get">My orders</button>
        <button href="RoomRequestServlet" method="get">Make an order</button>
      </c:when>
      <c:otherwise>
        <div style="text-align: right"><a href="LoginServlet">Login</a></div>
        <div><h2>To make an order you need to login first.</h2></div>
      </c:otherwise>
    </c:choose>

    <!-- room catalogue -->

  </body>
</html>
