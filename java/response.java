/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
/**
 *
 * @author ARUN
 */
@WebServlet(urlPatterns = {"/response"})
public class response extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           
            //request.getRequestDispatcher("compose.html").include(request, response);
            String b1=request.getParameter("b1");
            out.println("<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"    <!-- Required meta tags -->\n" +
"    <meta charset=\"utf-8\" />\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n" +
"\n" +
"    <!-- Bootstrap CSS -->\n" +
"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\n" +
"        integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\" />\n" +
"    <link rel=\"stylesheet\" type=\"text/css\"\n" +
"        href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css\" />\n" +
"    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
"    <link rel=\"stylesheet\" href=\"css/footer.css\">\n" +
"    <title>Learnx</title>\n" +
"\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark  navbar fixed-top p-md-1\">\n" +
"        <div class=\"container\">\n" +
"            <!-- mb-0 h1 -->\n" +
"            <a class=\"navbar-brand \" href=\"index.html\">\n" +
"                <img src=\"image/logo.png\" width=\"120\" height=\"30\" alt=\"\" loading=\"lazy\"></a>\n" +
"            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n" +
"                aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"                <span class=\"navbar-toggler-icon\"></span>\n" +
"            </button>\n" +
"\n" +
"            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
"                <ul class=\" navbar-nav  \">\n" +
"                    <!-- <ul class=\"nav justify-content-end\"> -->\n" +
"                        <li class=\"nav-item active\">\n" +
"                            <a class=\"nav-link\" href=\"admin.html\">Home <span class=\"sr-only\">(current)</span></a>\n" +
"                          </li>\n" +
"                          \n" +
"                          <li class=\"nav-item\">\n" +
"                            <a class=\"nav-link\" href=\"logout.html\">Logout</a>\n" +
"                          </li>\n" +
"                          </li>\n" +
"\n" +
"                </ul>\n" +
"            </div>\n" +
"        </div>\n" +
"    </nav>\n" +
"\n" +
"    <!-- Banner image start -->\n" +
"    <div id=\"carouselExampleCaptions\" class=\"carousel slide carousel-fade\" data-ride=\"carousel\">\n" +
"\n" +
"        <div class=\"carousel-inner\">\n" +
"            <div class=\"carousel-item active\">\n" +
"                <img src=\"image/answer.jpg\" class=\"d-block w-100\" alt=\"...\">\n" +
"\n" +
"            </div>\n" +
"        </div>\n" +
"        <!-- Banner image end -->\n" +
"\n" +
"\n" +
"\n" +
"        <!-- Blog Entries Column Start-->\n" +
"        <div class=\"container\">\n" +
"\n" +
"            <div class=\"row\" style=\"margin-top: 4%\">\n" +
"\n" +
"                <!-- Blog Entries Column -->\n" +
"                <div class=\"col-md-8\">\n" +
"                    <!-- Blog Post -->\n" +
"\n" +
"                    <div class=\"card mb-4\">\n" +
"                        <!-- <img class=\"card-img-top\" src=\"image/slider.png\" alt=\"Jasprit Bumrah ruled out of England T20I series due to injury\"> -->\n" +
"                        <div class=\"card-body\">\n" +
"                            <form action=\"compose\" method=\"post\">\n" +
"                             <input type=\"text\" name='to' value='"+b1+"' hidden/>\n" +
"                            <p>Enter your Answer:<br>\n" +
"                            <textarea  name=\"ans\" rows=\"12\" cols=\"70\" > </textarea></p>\n" +
"                            \n" +
"\n" +
"                            <div><button name=\"res\" value=\"compose\" class=\"btn btn-outline-success\" role=\"button\"\n" +
"                                         aria-pressed=\"true\">Submit</button></div></form>\n" +
"                        </div>\n" +
"\n" +
"                    </div>\n" +
"                    \n" +
"                    <br>\n" +
"                    <!-- Pagination -->\n" +
"\n" +
"                </div>\n" +
"                <!-- Blog Entries Column end-->\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"        <!-- Back to top button start-->\n" +
"        <button type=\"button\" class=\"btn btn-danger btn-floating btn-lg\" id=\"btn-back-to-top\">\n" +
"            <i class=\"fas fa-arrow-up\"></i>\n" +
"        </button>\n" +
"        <!-- Back to top button end-->\n" +
"\n" +
"       \n" +
"    </div>\n" +
"        </div>\n" +
"\n" +
"   <!-- footer start -->\n" +
"   <div>\n" +
"    <footer class=\"footer\">\n" +
"      <div class=\"container\">\n" +
"        <div class=\"row\">\n" +
"          <div class=\"footer-col\">\n" +
"            <h4>Learnx</h4>\n" +
"            <ul>\n" +
"              <li><a href=\"index.html\">Home</a></li>\n" +
"              <li><a href=\"#\">Our Services</a></li>\n" +
"            </ul>\n" +
"          </div>\n" +
"          <div class=\"footer-col\">\n" +
"            <h4>Group members</h4>\n" +
"            <ul>\n" +
"              <li><a href=\"#\">Amritha S</a></li>\n" +
"              <li><a href=\"#\">Madhumitha R</a></li>\n" +
"              <li><a href=\"#\">Thamizharasi M</a></li>\n" +
"            </ul>\n" +
"          </div>\n" +
"          <div class=\"footer-col\">\n" +
"            <h4>College</h4>\n" +
"            <ul>\n" +
"              <li><a href=\"#\">MIT,Anna University</a></li>\n" +
"              <li><a href=\"#\">Web Technology project</a></li>\n" +
"            </ul>\n" +
"          </div>\n" +
"          <div class=\"footer-col\">\n" +
"            <h4>follow us</h4>\n" +
"            <div class=\"social-links\">\n" +
"              <a href=\"#\"><i class=\"fab fa-github\"></i></a>\n" +
"              <a href=\"#\"><i class=\"fab fa-linkedin-in\"></i></a>\n" +
"              <a href=\"#\"><i class=\"fab fa-twitter\"></i></a>\n" +
"              <a href=\"#\"><i class=\"fab fa-facebook-f\"></i></a>\n" +
"            </div>\n" +
"          </div>\n" +
"        </div>\n" +
"      </div>\n" +
"    </footer>\n" +
"  </div>\n" +
"  <!-- footer end -->\n" +
"\n" +
"    <!-- Optional JavaScript -->\n" +
"    <!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" +
"    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"\n" +
"        integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\">\n" +
"    </script>\n" +
"    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"\n" +
"        integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\">\n" +
"    </script>\n" +
"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"\n" +
"        integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\" crossorigin=\"anonymous\">\n" +
"    </script>\n" +
"\n" +
"    <script src=\"js/style.js\"></script>\n" +
"\n" +
"</body>\n" +
"\n" +
"</html>");
            //String b2=request.getParameter("res");
            //out.println(b1);
            //out.println(b2);
        
        }catch(Exception e){
            System.out.println(e);
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
