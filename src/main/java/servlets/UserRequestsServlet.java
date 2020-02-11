package servlets;

import entities.RoomRequest;
import models.HotelDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserRequestsServlet")
public class UserRequestsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));

        request.setAttribute("invoiceId", invoiceId);
        request.getRequestDispatcher("invoice.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HotelDAO hotelDAO = new HotelDAO();

        int clientId = (request.getParameter("userId") != null)? Integer.parseInt(request.getParameter("userId")) : 0;
        List<RoomRequest> requestList = hotelDAO.getUserRequests(clientId);

        request.setAttribute("requestList", requestList);
        request.getRequestDispatcher("requests.jsp").forward(request, response);
    }
}
