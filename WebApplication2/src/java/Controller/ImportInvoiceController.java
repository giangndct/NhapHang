/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccessaryDAO;
import DAO.ImportInvoiceDAO;
import DAO.SupplierDAO;
import Entity.Accessary;
import Entity.ImportInvoice;
import Entity.ImportInvoiceAccessary;
import Entity.Supplier;
import Entity.User;
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
@WebServlet(name = "ImportInvoiceController", urlPatterns = {"/invoice"})
public class ImportInvoiceController extends HttpServlet {

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
//            out.println("<title>Servlet ImportInvoiceController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ImportInvoiceController at " + request.getContextPath() + "</h1>");
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
        String supplierid = request.getParameter("supplierid");
        String accessaryid = request.getParameter("accessaryid");
        HttpSession session = request.getSession();
        if (supplierid != null) {
            SupplierDAO spDAO = new SupplierDAO();
            ImportInvoice invoice = new ImportInvoice();
            try {
                Supplier sp = spDAO.getSupplier(Integer.parseInt(supplierid));
                invoice.setSupplier(sp);
            } catch (Exception ex) {
                String err = "Có lỗi xảy ra khi tìm nhà cung cấp";
                request.setAttribute("err", err);
                request.getRequestDispatcher("findsupplierframe.jsp").forward(request, response);
            }
            User u = (User) session.getAttribute("user");
            invoice.setUser(u);
            session.setAttribute("invoice", invoice);
        } else if (accessaryid != null) {
            try {
                int soLuong
                        = Integer.parseInt(request.getParameter("amount"));
                int dongia
                        = Integer.parseInt(request.getParameter("price"));
                AccessaryDAO aDAO = new AccessaryDAO();
                Accessary p = aDAO.getAccessary(Integer.parseInt(accessaryid));
                ImportInvoiceAccessary pii = new ImportInvoiceAccessary();
                pii.setAccessary(p);
                pii.setAmount(soLuong);
                pii.setPrice(dongia);
                ImportInvoice invoice = (ImportInvoice) session.getAttribute("invoice");
                invoice.getListAccessarys().add(pii);
                invoice.setTotalMoney(invoice.getTotalMoney()
                        + soLuong * dongia);
                session.setAttribute("invoice", invoice);
            } catch (Exception ex) {
                String err = "Có lỗi xảy ra trong quá trình nhập linh kiện";
                request.setAttribute("err", err);
            }

        }
        request.getRequestDispatcher("importinvoiceframe.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        ImportInvoice invoice = (ImportInvoice) session.getAttribute("invoice");
        ImportInvoiceDAO pDAO = new ImportInvoiceDAO();
        if (pDAO.addImportInvoice(invoice)) {
            String message = "Lưu hoá đơn nhập thành công";
            request.setAttribute("message", message);
            request.getRequestDispatcher("importinvoiceframe.jsp").forward(request, response);
        } else {
            String err = "Lưu hoá đơn nhập thất bại";
            request.setAttribute("err", err);

            request.getRequestDispatcher("importinvoiceframe.jsp").forward(request, response);
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
