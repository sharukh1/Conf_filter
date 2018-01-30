/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Inspiron
 */
public class Transfer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String emailid = (String) session.getAttribute("emailid");
        if (!emailid.equals("")) {

            try {

                String from = request.getParameter("cashfrom");
                String to = request.getParameter("cashto");
                int cash = Integer.parseInt(request.getParameter("cash"));
                
                System.out.println("from"+from+"to "+to);
                Connection con = DbConnect.DbConnect.con();
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT a1.balance, a2.balance FROM account a1 CROSS JOIN account a2 WHERE a1.emailid = '" + from + "' and a2.emailid = '" + to + "'");
                int balfrom = 0;
                int balto = 0;
                while (rs.next()) {
                    balfrom = rs.getInt(1);
                    balto = rs.getInt(2);
                }
                System.out.println("from "+balfrom);
                 System.out.println("to "+balto);
                int NewBalfrom = balfrom - cash;
                int NewBalto = balto + cash;
                if (NewBalfrom <= 500) {

                    RequestDispatcher rd = request.getRequestDispatcher("Transfer.jsp");
                    rd.include(request, response);
                    PrintWriter out = response.getWriter();
                    out.println("<br>");
                    out.print("limited balance..transferrng not possible");
                } else if (NewBalfrom > 500) {
                    stmt.executeUpdate("update account set balance = '" + NewBalfrom + "' where emailid = '" + from + "'");
                    stmt.executeUpdate("update account set balance = '" + NewBalto + "' where emailid = '" + to + "'");

                    RequestDispatcher rd = request.getRequestDispatcher("Transfer.jsp");
                    rd.include(request, response);
                    PrintWriter out = response.getWriter();
                //    out.print("done");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("Transfer.jsp");
                    rd.include(request, response);
                    PrintWriter out = response.getWriter();
                    out.println("<br>");
                    out.print("limited balance");

                }
                response.setContentType("text/html;charset=UTF-8");
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
