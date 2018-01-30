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
public class AddBalance extends HttpServlet {

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
                 
                int amount = Integer.parseInt(request.getParameter("cash"));
                System.out.println(">" + amount);
                
                Connection con = DbConnect.DbConnect.con();
                Statement stmt = con.createStatement();
                int check = 0;
                  ResultSet stat=stmt.executeQuery("select status from account where emailid='"+emailid+"'");
                while(stat.next()){
                    check=stat.getInt(1);
                }
                
               if(check>0) {
                    ResultSet rs=stmt.executeQuery("select balance from account where emailid='"+emailid+"'");
                int bal=0;
                while(rs.next()){
                    bal=rs.getInt(1);
                }
               int NewBal=bal+amount;
                 int i = stmt.executeUpdate("update account set balance = '"+NewBal+"' where emailid = '"+emailid+"'");
            
                
                response.setContentType("text/html;charset=UTF-8");
                
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                     if (i > 0) {
                            out.println("account updated");
                             out.println("<br>");
                            RequestDispatcher rd = request.getRequestDispatcher("AddBalance.jsp");
                            rd.include(request, response);
                        } else {
                            out.print("problem occured..try again");
                            RequestDispatcher rd = request.getRequestDispatcher("AddBalance.jsp");
                            rd.forward(request, response);
                        }
                }
               }else{
                   PrintWriter out = response.getWriter();
                   response.setContentType("text/html;charset=UTF-8");
                            RequestDispatcher rd = request.getRequestDispatcher("Join.jsp");
                            rd.forward(request, response);
                   }
                
               
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(AddBalance.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AddBalance.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("> invalid");
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
