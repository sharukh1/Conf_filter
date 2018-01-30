/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.UserInfo;
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
public class UserAccount extends HttpServlet {

    String id = "";
    String n = "";
    String add = "";
    String un = "";
    String p = "";
    int bal = 0;

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
        if (!emailid.equals(null)) {
            System.out.println("email" + emailid);
            try {
                Connection con = DbConnect.DbConnect.con();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT r.*, a.balance FROM registration r CROSS JOIN account a WHERE r.emailid = '" + emailid + "' and a.emailid = '" + emailid + "'");

                while (rs.next()) {
                    id = rs.getString(1);
                    n = rs.getString(2);
                    add = rs.getString(3);
                    un = rs.getString(4);
                    p = rs.getString(5);
                    bal = rs.getInt(6);
                }
//                ResultSet rs1 = stmt.executeQuery("select balance from account where emailid='" + emailid + "'");
//
//                while (rs1.next()) {
//                    bal = rs.getInt(2);
//                }System.out.println(">"+bal);

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserAccount.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        UserInfo u = new UserInfo();

        u.setAdd(add);
        u.setId(id);
        u.setN(n);
        u.setP(p);
        u.setUn(un);
        u.setBal(bal);
        System.out.println(u.getAdd() + "user");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher rd = request.getRequestDispatcher("Nav.html");
            rd.include(request, response);

            out.print(" <ul>\n"
                    + "               <h1><ul><i>Account information</i></ul></h1>  \n"
                    + "            <h2>\n"
                    + "                Name&nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp;: " + u.getN() + " <br>\n"
                    + "                Address&nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp;: " + u.getAdd() + " <br>\n"
                    + "                Email id  &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp;: " + u.getId() + " <br>\n"
                    + "                Username&nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp;: " + u.getUn() + " <br>\n"
                    + "                Password   &nbsp;  &nbsp;  &nbsp; &nbsp; &nbsp;: " + u.getP() + " <br> <br>  <br>\n"
                    + "                Account balance  &nbsp;  &nbsp; &nbsp; &nbsp;: " + u.getBal() + " <br>\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "            </h2>\n"
                    + "\n"
                    + "        </ul>");

        }
        u = null;
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
