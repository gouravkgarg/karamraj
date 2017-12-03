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
import java.util.ArrayList;
import java.util.List;
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

public class employeeTrackerServlet extends HttpServlet {

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
            List<Integer> requests=new ArrayList<>();
            List<String> employees=new ArrayList<>();
            try{
             Class.forName("com.mysql.jdbc.Driver");
             con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sugamkaram","root","");
             if(con!=null)
                 System.out.println("Connection Established");
                 PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from pool where status = 'pending'");
                 ResultSet rst=pst.executeQuery();
                 
                 while (rst.next()){
                     requests.add(rst.getInt(1));
                 }
                 rst.close();
                 pst.close();
                 pst=(PreparedStatement) con.prepareStatement("select * from performance order by tasks ASC");
                 rst=pst.executeQuery();
                 while (rst.next()){
                     employees.add(rst.getString(1));
                 }
                 
                 rst.close();
                 pst.close();
                 
                 pst=(PreparedStatement) con.prepareStatement("insert into empid values (?,?)");
                 pst.setString(1, "Employee");
                 pst.setInt(2, 2);
                 
                 if(pst.executeUpdate()>0){
                     System.out.println("The values has been inserted ");
                 }
                 
                 pst.close();
                 
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
