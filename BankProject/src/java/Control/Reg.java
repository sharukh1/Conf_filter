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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Inspiron
 */
public class Reg extends HttpServlet {

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

            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String emailid = request.getParameter("emailid");
            String username = request.getParameter("username");
            String password = (String) request.getParameter("password");
            String language = request.getParameter("language");

            if (!language.equals("")) {
                Connection con = DbConnect.DbConnect.con();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from registration where emailid='" + emailid + "'");

                response.setContentType("text/html;charset=UTF-8");

                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    if (rs.first()) {
                        out.print("user already exist");
                        RequestDispatcher rd = request.getRequestDispatcher("index.html");
                        rd.include(request, response);
                    } else {
                        ResultSet rs2 = stmt.executeQuery("select * from registration where username='" + username + "'");
                        if (rs2.first()) {
                            out.print("registration failed....username already taken,choose another one");
                            RequestDispatcher rd = request.getRequestDispatcher("Registration.html");
                            rd.include(request, response);

                        } else {

                            int i = stmt.executeUpdate("insert into registration (emailid,name,address,username,password) values ('" + emailid + "','" + name + "','" + address + "','" + username + "','" + password + "')");
                            stmt.executeUpdate("insert into login (idlogin,username,password) values (0,'" + username + "','" + password + "')");
                            stmt.executeUpdate("insert into account (emailid,balance) values ('" + emailid + "',0)");
                            if (i > 0) {
                                out.print("registration completed");
                                Cookie ck = new Cookie(language, language);
                                response.addCookie(ck);
                                RequestDispatcher rd = request.getRequestDispatcher("Decide.html");
                                rd.include(request, response);
                            } else {
                                out.print("registration failed");
                                RequestDispatcher rd = request.getRequestDispatcher("Registration.html");
                                rd.forward(request, response);
                            }

                        }

                    }

                }
            } else {
//                response.setContentType("text/html;charset=UTF-8");

                response.sendRedirect("Registration.html");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Reg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reg.class.getName()).log(Level.SEVERE, null, ex);
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
