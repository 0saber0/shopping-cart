<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	
	<style type="text/css">
	   hr{
	    border-color:FF7F00; 
	   }
	   div{
	      float:left;
	      margin: 10px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	</style>
  </head>
  
  <body>
    <h1>商品展示</h1>
    <hr>
   
    <center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td>
          
          <!-- 商品循环开始 -->
         <c:forEach items="${listAll}" var="items">
          <div>
             <dl>
               <dt>
                 <a href="/shopping-cart/shopping/details?id=${items.id}"><img src="../resources/images/${items.picture}" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name">${items.name}</dd> 
               <dd class="dd_city">产地:${items.city}&nbsp;&nbsp;价格: ￥${items.price}</dd> 
             </dl>
          </div>
          <!-- 商品循环结束 -->
        </c:forEach>
         
        </td>
      </tr>
    </table>
    </center>
  </body>
</html>
