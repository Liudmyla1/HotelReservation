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

/**
 * Show to admin list of open requests to manage them
 */
@WebServlet(name = "OpenRequestsServlet")
public class OpenRequestsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));

        if (request.getParameter("method").equals("apply")) {
            request.setAttribute("requestId", requestId);
            request.getRequestDispatcher("apply-request.jsp").forward(request, response);
        } else if (request.getParameter("method").equals("close")) {
            HotelDAO hotelDAO = new HotelDAO();
            hotelDAO.closeRequest(requestId, hotelDAO.getRoomRequest(requestId).getRoom().getNumber());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HotelDAO hotelDAO = new HotelDAO();
        List<RoomRequest> openRequestsList = hotelDAO.getOpenRequests();

        request.setAttribute("openRequestsList", openRequestsList);
        request.getRequestDispatcher("open-requests.jsp").forward(request, response);
    }
}
