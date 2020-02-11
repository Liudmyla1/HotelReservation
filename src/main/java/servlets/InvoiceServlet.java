package servlets;

import entities.Invoice;
import models.HotelDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Show to client invoice of the request
 */
@WebServlet(name = "InvoiceServlet")
public class InvoiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        HotelDAO hotelDAO = new HotelDAO();

        int invoiceId = Integer.getInteger(request.getParameter("invoiceId"));
        Invoice invoice = hotelDAO.getInvoice(invoiceId);

        request.setAttribute("invoice", invoice);
        request.getRequestDispatcher("invoice.jsp").forward(request, response);
    }
}
