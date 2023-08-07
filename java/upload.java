/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;
/**
 *
 * @author ARUN
 */
@WebServlet(name = "upload", urlPatterns = { "/upload" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class upload extends HttpServlet {

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
         request.getRequestDispatcher("fileupload.html");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           request.getRequestDispatcher("fileupload.html").include(request, response);
           int id=Integer.parseInt(request.getParameter("id"));
           int sem=Integer.parseInt(request.getParameter("sem"));
           String paper=request.getParameter("paper");
           int unit=Integer.parseInt(request.getParameter("unit"));
            Class.forName("com.mysql.jdbc.Driver");
            out.println("hello");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning","root","");
            PreparedStatement st=con.prepareStatement("Insert into courses  values(?,?,?,?,?)");
            out.println("hello");
            st.setInt(1,id);
            st.setInt(2,sem);
            st.setString(3,paper);
            st.setInt(4,unit);
            out.println("hello");
            InputStream inputStream = null;
            Part filepart=request.getPart("fileName");
             out.println("hi");
        if (filepart != null) {
            // prints out some information for debugging
            System.out.println(filepart.getName());
            System.out.println(filepart.getSize());
            System.out.println(filepart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filepart.getInputStream();
           out.println("hello");
        }
            st.setBlob(5,inputStream);
            //st.executeUpdate("insert into course values('"+id+"','"+sem+"','"+paper+"','"+unit+"','"+inputStream+"')");
             int row = st.executeUpdate();
             out.println("hello");
             if(row>0){
                 out.println("<script>window.alert('file uploaded successfully')</script>");
             }
        }catch(Exception e){
            
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
