/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gaurav
 */
@WebServlet(urlPatterns = {"/AuthenticateEmployeeServlet"})
public class AuthenticateEmployeeServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        //String name="Ramesh";
        //String password="password";        
        String userName=request.getParameter("username");
        HttpSession session=request.getSession();
        String password1=request.getParameter("password");
        session.setAttribute("userName", userName);
        session.setAttribute("password1", password1);
        
        Connection con=null;
        ResultSet rs=null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sugamkaram","root","");
             if(con!=null)
             {
                 System.out.println("Connection Established "+userName+"   "+password1);
                 
                 PreparedStatement pst=(PreparedStatement) con.prepareStatement("Select * from performance where empName=? and Password=?");
                 pst.setString(1,userName);
                 pst.setString(2, password1);
                 rs=pst.executeQuery();
                 if(rs.next())
                 {
                    int id=rs.getInt(1);
                       RequestDispatcher rd=request.getRequestDispatcher("EmployeeHome.jsp");
                       System.out.println("going to EmployeeHome");
                       request.setAttribute("user",String.valueOf(id));
                       rd.forward(request, response);
                     
                 }
                 else
                 {
               response.sendRedirect("error.html");
                 }
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("exception caught");
            
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthenticateEmployeeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AuthenticateEmployeeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
