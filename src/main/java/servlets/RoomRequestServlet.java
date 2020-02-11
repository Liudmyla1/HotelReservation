package servlets;

import entities.Client;
import entities.RoomRequest;
import models.HotelDAO;
import models.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Creating of a new request by client
 */
@WebServlet(name = "RoomRequestServlet")
public class RoomRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HotelDAO hotelDAO = new HotelDAO();
        UserDAO userDAO = new UserDAO();

        int userId = (request.getParameter("userId") != null)? Integer.parseInt(request.getParameter("userId")) : 0;
        int peopleNum = Integer.getInteger(request.getParameter("peopleNum"));
        String category = request.getParameter("category");
        Date checkIn = Date.valueOf(request.getParameter("checkIn"));
        Date checkOut = Date.valueOf(request.getParameter("checkOut"));

        Client client = (Client) userDAO.getUser(userId, false);
        RoomRequest roomRequest = new RoomRequest(client, peopleNum, category, checkIn, checkOut);

        hotelDAO.createRequest(roomRequest);

        PrintWriter writer = response.getWriter();
        writer.print("Request created successfully!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }
}
