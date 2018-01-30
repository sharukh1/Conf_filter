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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Inspiron
 */
@WebServlet(name = "Bank", urlPatterns = {"/Bank"})
public class Bank extends HttpServlet {

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

        try {
            String key = request.getParameter("key");
            String name = request.getParameter("name");

            Connection con = DbConnect.DbConnect.con();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from bankdb where name='" + name + "'");
            System.out.println(">res" + rs);
            try (PrintWriter out = response.getWriter()) {
                if (rs.first()) {

                    RequestDispatcher rd = request.getRequestDispatcher("BankRegistration.html");
                    rd.include(request, response);
                    out.print("bank already exist");
                } else {

                    int i = 0;
                    i = stmt.executeUpdate("insert into bankdb values (0,'" + name + "','" + key + "',0)");

                    if (i > 0) {
                         
                        RequestDispatcher rd = request.getRequestDispatcher("BankLogin.html");
                        rd.include(request, response);
                         out.print("registration completed");
                    } else {
                         out.print("registration failed");
                        RequestDispatcher rd = request.getRequestDispatcher("BankRegistration.html");
                        rd.forward(request, response);
                    }

                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
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
