<%-- 
    Document   : compose
    Created on : 10 Jan, 2023, 10:39:35 PM
    Author     : ARUN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "javax.mail.*"%>
<%@ page import = "java.util.*"%>
<%@ page import = "javax.mail.internet.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/footer.css">
    <title>Learnx</title>

</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark  navbar fixed-top p-md-1">
        <div class="container">
            <!-- mb-0 h1 -->
            <a class="navbar-brand " href="index.html">
                <img src="image/logo.png" width="120" height="30" alt="" loading="lazy"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class=" navbar-nav  ">
                    <!-- <ul class="nav justify-content-end"> -->
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                          </li>
                          
                          <li class="nav-item">
                            <a class="nav-link" href="">Logout</a>
                          </li>
                          </li>

                </ul>
            </div>
        </div>
    </nav>

    <!-- Banner image start -->
    <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-ride="carousel">

        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="image/answer.jpg" class="d-block w-100" alt="...">

            </div>
        </div>
        <!-- Banner image end -->



        <!-- Blog Entries Column Start-->
        <div class="container">

            <div class="row" style="margin-top: 4%">

                <!-- Blog Entries Column -->
                <div class="col-md-8">
                    <!-- Blog Post -->

                    <div class="card mb-4">
                        <!-- <img class="card-img-top" src="image/slider.png" alt="Jasprit Bumrah ruled out of England T20I series due to injury"> -->
                        <div class="card-body">
                            <form action="compose.jsp" method="post">
                            <p>Enter your Answer:<br>
                            <textarea  name="ans" rows="12" cols="70" > </textarea></p>
                            

                            <div><button name="res" value="compose" class="btn btn-outline-success" role="button"
                                         aria-pressed="true">Submit</button></div></form>
                        </div>

                    </div>
                    
                    <br>
                    <!-- Pagination -->

                </div>
                <!-- Blog Entries Column end-->




        <!-- Back to top button start-->
        <button type="button" class="btn btn-danger btn-floating btn-lg" id="btn-back-to-top">
            <i class="fas fa-arrow-up"></i>
        </button>
        <!-- Back to top button end-->

       
    </div>
        </div>
                <%        
       
        String to="amritha111577@gmail.com";
        String ans=request.getParameter("ans");
                String from="amrithas135@gmail.com";
                String rec=to;
                Properties prop=System.getProperties();
            String host="smtp.gmail.com";
            prop.put("mail.smtp.host",host);
            prop.put("mail.smtp.port","465");
            prop.put("mail.smtp.ssl.enable","true");
            prop.put("mail.smtp.auth", "true");
            Session s= Session.getInstance(prop, new javax.mail.Authenticator(){
                 @Override protected PasswordAuthentication getPasswordAuthentication(){
                     return new PasswordAuthentication(from,"udbr khqy wods lewe");
                 }
            });
            s.setDebug(true);
            try{
                MimeMessage message=new MimeMessage(s);
                message.setFrom(new InternetAddress(from));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
               
                message.setSubject("query result");
                message.setText(ans);
                Transport.send(message);
                               out.println("success.....");

            }
        
        catch(Exception e){
            System.out.println(e);
        }
       
         
         %>




   <!-- footer start -->
   <div>
    <footer class="footer">
      <div class="container">
        <div class="row">
          <div class="footer-col">
            <h4>Learnx</h4>
            <ul>
              <li><a href="index.html">Home</a></li>
              <li><a href="#">Our Services</a></li>
            </ul>
          </div>
          <div class="footer-col">
            <h4>Group members</h4>
            <ul>
              <li><a href="#">Amritha S</a></li>
              <li><a href="#">Madhumitha R</a></li>
              <li><a href="#">Thamizharasi M</a></li>
            </ul>
          </div>
          <div class="footer-col">
            <h4>College</h4>
            <ul>
              <li><a href="#">MIT,Anna University</a></li>
              <li><a href="#">Web Technology project</a></li>
            </ul>
          </div>
          <div class="footer-col">
            <h4>follow us</h4>
            <div class="social-links">
              <a href="#"><i class="fab fa-github"></i></a>
              <a href="#"><i class="fab fa-linkedin-in"></i></a>
              <a href="#"><i class="fab fa-twitter"></i></a>
              <a href="#"><i class="fab fa-facebook-f"></i></a>
            </div>
          </div>
        </div>
      </div>
    </footer>
  </div>
  <!-- footer end -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous">
    </script>

    <script src="js/style.js"></script>

</body>

</html>
