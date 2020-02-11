package servlets;

import entities.Client;
import models.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        UserDAO userDAO = new UserDAO();

        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("pass");

        boolean added = userDAO.addUser(new Client(name, login, password));

        PrintWriter writer = response.getWriter();
        if (!added) {
            writer.print("Failed to create account. Please try later");
        } else {
            writer.print("Account created successfully");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/registration.jsp");
        requestDispatcher.forward(request, response);
    }
}
