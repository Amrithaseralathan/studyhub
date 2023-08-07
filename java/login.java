/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ARUN
 */
@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           String uname=request.getParameter("uname");
           String pwd=request.getParameter("pwd");
           String b1=request.getParameter("b1");
          //out.println(b1);
           Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/elearning","root","");
           if(b1.equals("Admin")){
               request.getRequestDispatcher("admin.html").include(request, response);
                 
            Statement st1=con.createStatement();
            //out.println("hello");
            ResultSet res=st1.executeQuery("select apwd from admin where aname='"+uname+"'");
            String pwds="";
            //out.println("hello");
            if(res.next()){
                pwds=res.getString("pwd");
                out.println(pwds);
            }
            if(!pwd.equals(pwds)){
                
                request.getRequestDispatcher("login.html").include(request, response);
                out.println("<script>window.alert('Invalid user name or password')</script>");
               
            }   
            else{
                request.getRequestDispatcher("index_1.html").include(request, response); 
            }
               
           }
           else{
           //out.println("hello");
            
            Statement st2=con.createStatement();
            //out.println("hello");
            ResultSet res=st2.executeQuery("select pwd from student where uname='"+uname+"'");
            String pwds="";
            //out.println("hello");
            if(res.next()){
                pwds=res.getString("pwd");
                out.println(pwds);
            }
            if(!pwd.equals(pwds)){
                
                request.getRequestDispatcher("login.html").include(request, response);
                out.println("<script>window.alert('Invalid user name or password')</script>");
               
            }   
            else{
                request.getRequestDispatcher("index_1.html").include(request, response); 
            }
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
