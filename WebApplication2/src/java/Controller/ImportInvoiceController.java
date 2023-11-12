/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.AccessaryDAO205;
import DAO.ImportInvoiceDAO205;
import DAO.SupplierDAO205;
import Entity.Accessary205;
import Entity.ImportInvoice205;
import Entity.ImportInvoiceAccessary205;
import Entity.Supplier205;
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
            SupplierDAO205 spDAO = new SupplierDAO205();
            ImportInvoice205 invoice = new ImportInvoice205();
            try {
                Supplier205 sp = spDAO.getSupplier(Integer.parseInt(supplierid));
                invoice.setSupplier(sp);
            } catch (Exception ex) {
                String err = "Có lỗi xảy ra khi tìm nhà cung cấp";
                request.setAttribute("err", err);
                request.getRequestDispatcher("findsupplierframe.jsp").forward(request, response);
            }
            User205 u = (User205) session.getAttribute("user");
            invoice.setUser(u);
            session.setAttribute("invoice", invoice);
        } else if (accessaryid != null) {
            try {
                int soLuong
                        = Integer.parseInt(request.getParameter("amount"));
                int dongia
                        = Integer.parseInt(request.getParameter("price"));
                AccessaryDAO205 aDAO = new AccessaryDAO205();
                Accessary205 p = aDAO.getAccessary(Integer.parseInt(accessaryid));
                ImportInvoiceAccessary205 pii = new ImportInvoiceAccessary205();
                pii.setAccessary(p);
                pii.setAmount(soLuong);
                pii.setPrice(dongia);
                ImportInvoice205 invoice = (ImportInvoice205) session.getAttribute("invoice");
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
        ImportInvoice205 invoice = (ImportInvoice205) session.getAttribute("invoice");
        ImportInvoiceDAO205 pDAO = new ImportInvoiceDAO205();
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
