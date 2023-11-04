/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccessaryDAO;
import Entity.Accessary;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddAccessaryController", urlPatterns = {"/addacc"})
public class AddAccessaryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AddAccessaryController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AddAccessaryController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Accessary accessary = new Accessary();
        accessary.setName(request.getParameter("name"));
        accessary.setCompany(request.getParameter("company"));
        accessary.setDescription(request.getParameter("description"));
        try {
            double price
                    = Double.parseDouble(request.getParameter("price"));
            if (price <= 0) {
                String err = "Dữ liệu giá bán không phù hợp";
                request.setAttribute("accessary", accessary);
                request.getRequestDispatcher("addaccessaryframe.jsp").forward(request, response);
            }
            accessary.setPrice((float) price);
            AccessaryDAO aDAO = new AccessaryDAO();

            if (aDAO.addAccessary(accessary)) {
                request.getRequestDispatcher("findaccessaryframe.jsp").forward(request, response);
            } else {
                String err = "Thêm linh kiện thất bại";
                request.setAttribute("accessary", accessary);

                request.getRequestDispatcher("addaccessaryframe.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            String err = "Dữ liệu giá bán không phù hợp";
            request.setAttribute("accessary", accessary);

            request.getRequestDispatcher("addaccessaryframe.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
