
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

/**
 *
 * @author Gaurav
 */
@WebServlet(urlPatterns = {"/PerformanceTrakker"})
public class PerformanceTrakker extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          
            String reqId=request.getParameter("reqId");
            String empId=request.getParameter("emp_id");
            String status=request.getParameter("status");
            
            System.out.println("In performance Traker"+reqId +" "+empId+" "+status);
            
            Connection con=null;
            Connection connect=null;
        ResultSet rs=null;
        ResultSet rst=null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sugamkaram","root","");
        connect=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sugamkaram","root","");
        if(con!=null)
             {
                 System.out.println("Connection Established ");
                 
                 PreparedStatement pst=(PreparedStatement) con.prepareStatement("UPDATE stages SET stageId = ? ,empId = ? ,status = ? WHERE reqId =? ");
                 PreparedStatement pst2=(PreparedStatement) connect.prepareStatement("update performance set points=points+1 where empId=? ");
                 RequestDispatcher rd=null;
                 int t=0;
                 if(status.equalsIgnoreCase("accepted")){
                    if(empId.equalsIgnoreCase("1")){
                        pst.setString(1,"2");
                        pst.setString(2,"2");
                        pst.setString(3,"accepted");
                        pst.setString(4,reqId);
                       t=pst.executeUpdate();
                       
                    }
                    
                   if(empId.equalsIgnoreCase("2")){
                        pst.setString(1,"3");
                        pst.setString(2,"3");
                        pst.setString(3,"accepted");
                       t=pst.executeUpdate();
                    }
                   
                   
                    if(empId.equalsIgnoreCase("3")){
                        pst.setString(1,"4");
                        pst.setString(2,"4");
                        pst.setString(3,"accepted");
                       t=pst.executeUpdate();
                    }
                 }
             
                 pst2.setString(1, empId);
                 int s=pst2.executeUpdate();
                 
                 rd=request.getRequestDispatcher("EmployeeHome.jsp");
                 if(t>0){
                     rd.forward(request, response);
                 }
       
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("exception caught");
            
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
