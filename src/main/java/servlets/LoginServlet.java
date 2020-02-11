package servlets;

import models.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        UserDAO userDAO = new UserDAO();

        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));

        int userId = userDAO.validateUser(login, password, isAdmin);
        if (userId != 0) {
            request.setAttribute("login", login);
            if (isAdmin) {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            } else {
                request.setAttribute("userId", userId);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            PrintWriter writer = response.getWriter();
            writer.print("Incorrect login or password!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
