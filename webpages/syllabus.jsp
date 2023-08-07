<%-- 
    Document   : syllabus
    Created on : 8 Jan, 2023, 11:22:56 AM
    Author     : ARUN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%     
         int s=Integer.parseInt(request.getParameter("n3"));
         %>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/elearning"
         user = "root"  password = ""/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT paper,unit1,unit2,unit3,unit4,unit5 from semester where semno=5;
      </sql:query>
 
      <table border = "1" width = "100%">
         <tr>
            <th>SUBJECT</th>
            <th>UNIT-1</th>
            <th>UNIT-2</th>
             <th>UNIT-3</th>
             <th>UNIT-4</th>
             <th>UNIT-5</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td><c:out value = "${row.paper}"/></td>
               <td><c:out value = "${row.unit1}"/></td>
               <td><c:out value = "${row.unit2}"/></td>
               <td><c:out value = "${row.unit3}"/></td>
               <td><c:out value = "${row.unit4}"/></td>
               <td><c:out value = "${row.unit5}"/></td>
            </tr>
         </c:forEach>
          
      </table>
        
   </body>
</html>
           
