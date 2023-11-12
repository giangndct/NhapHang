/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccessaryDAO205;
import DAO.ServiceDAO205;
import Entity.Accessary205;
import Entity.Service205;
import Entity.User205;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
@WebServlet(name = "InfomationSerAcc", urlPatterns = {"/info"})
public class InfomationSerAccController extends HttpServlet {

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
//            out.println("<title>Servlet InfomationSerAccController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet InfomationSerAccController at " + request.getContextPath() + "</h1>");
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
        String serviceid = request.getParameter("serviceid");
        String accessaryid = request.getParameter("accessaryid");
        HttpSession session = request.getSession();
        if (serviceid != null) {
            ServiceDAO205 spDAO = new ServiceDAO205();
            try {
                Service205 sp = spDAO.getService(Integer.parseInt(serviceid));
                session.setAttribute("sp", sp);
            } catch (Exception ex) {
                String err = "Có lỗi xảy ra";
                request.setAttribute("err", err);
                request.getRequestDispatcher("findaccessaryclientframe.jsp").forward(request, response);
            }
           
        }else if (accessaryid != null) {
             AccessaryDAO205 aDAO = new AccessaryDAO205();
            try {
                
               
                Accessary205 acc = aDAO.getAccessary(Integer.parseInt(accessaryid));
                session.setAttribute("acc", acc);
                
            } catch (Exception ex) {
                String err = "Có lỗi xảy ra trong quá trình nhập linh kiện";
                request.setAttribute("err", err);
            }

        }
         request.getRequestDispatcher("informationseracc.jsp").forward(request, response);
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
