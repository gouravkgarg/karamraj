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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gaurav
 */
public class citizenRegistrationServlet extends HttpServlet {

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
         Connection con=null;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name=request.getParameter("name");
            String aadhar =request.getParameter("aadhar");
            
            System.out.println(" "+name +" "+aadhar);
            
            try{
             Class.forName("com.mysql.jdbc.Driver");
             con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sugamkaram","root","");
             if(con!=null)
                 System.out.println("Connection Established");
                 PreparedStatement pst=(PreparedStatement) con.prepareStatement("insert into userdetails(Name,aadhar) values(?,?)");
                 pst.setString(1, name);
                 pst.setString(2, aadhar);
                 
                 RequestDispatcher rd =request.getRequestDispatcher("submit.jsp");
                 int t=pst.executeUpdate();
                 
                 PreparedStatement pst2=(PreparedStatement) con.prepareStatement("Select reqId from userdetails where aadhar=?");
                 
                 
                 
                 pst2.setString(1,aadhar);
                 ResultSet rs=pst2.executeQuery();

                 int requestId = 0;
                 
                 while(rs.next()){
                     requestId=Integer.parseInt(rs.getString(1));
                     System.out.println("Request Id"+requestId);
                 }
                 
                 
                 PreparedStatement pst3=(PreparedStatement) con.prepareStatement("insert into stages values(?,?,?,?)");
                 pst3.setInt(1,requestId);
                 pst3.setString(2,"1");
                 pst3.setString(3,"1");
                 pst3.setString(4,"Pending");
                 int x=pst3.executeUpdate();
                 
                 HttpSession session=request.getSession();
                 session.setAttribute("reqId", requestId);
                 
                 if(t>=1)
                 {
                    rd.forward(request, response);

                 }
        }catch(Exception e){
            System.out.println(e.getMessage());
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
