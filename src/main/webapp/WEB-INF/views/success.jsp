<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'success.jsp' starting page</title>

  </head>
  
  <body>
    <center>
      <img src="../resources/images/add_cart_success.jpg"/>
      <hr>
      <% 
         String id = request.getParameter("id");
         String num = request.getParameter("num");
      %>
             您成功购买了<%=num%>件商品编号为<%=id%>的商品&nbsp;&nbsp;&nbsp;&nbsp;
      <br>
      <br>
      <br>
      
    </center>
  </body>
</html>
