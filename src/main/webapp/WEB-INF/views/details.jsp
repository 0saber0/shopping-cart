<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'details.jsp' starting page</title>
    
	<link href="../resources/css/main.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../resources/js/lhgcore.js"></script>
    <script type="text/javascript" src="../resources/js/lhgdialog.js"></script>
    <script type="text/javascript">
      function selflog_show(id)
      { 
         var num =  document.getElementById("number").value; 
         J.dialog.get({id: 'haoyue_creat',title: '购物成功',width: 600,height:400, link: '/shopping-cart/cart/choose?id='+id+'&num='+num+'&action=add', cover:true});
      }
      function add()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num<100)
         {
            document.getElementById("number").value = ++num;
         }
      }
      function sub()
      {
         var num = parseInt(document.getElementById("number").value);
         if(num>1)
         {
            document.getElementById("number").value = --num;
         }
      }
     
    </script>
	
    <style type="text/css">
	   hr{
	     
	     border-color:FF7F00; 
	   }
	   
	   div{
	      float:left;
	      margin-left: 30px;
	      margin-right:30px;
	      margin-top: 5px;
	      margin-bottom: 5px;
	     
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
	   div #cart
	   {
	     margin:0px auto;
	     text-align:right; 
	   }
	   span{
	     padding:0 2px;border:1px #c0c0c0 solid;cursor:pointer;
	   }
	   a{
	      text-decoration: none; 
	   }
	</style>
  </head>
  
  <body>
    <h1>商品详情</h1>
    <a href="/shopping-cart/shopping/index">首页</a> >> <a href="/shopping-cart/shopping/index">商品列表</a>
    <hr>
    <center>
      <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <!-- 商品详情 -->
          
          <td width="70%" valign="top">
             <table>
               <tr>
                 <td rowspan="5"><img src="../resources/images/${items.picture}" width="200" height="160"/></td>
               </tr>
               <tr>
                 <td><B>${items.name}</B></td> 
               </tr>
               <tr>
                 <td>产地：${items.city}</td>
               </tr>
               <tr>
                 <td>价格：${items.price} ￥</td>
               </tr>
               <tr>
                 <td>购买数量：<span id="sub" onclick="sub();">-</span><input type="text" id="number" name="number" value="1" size="2"/><span id="add" onclick="add();">+</span></td>
               </tr> 
             </table>
             <div id="cart">
               <img src="../resources/images/buy_now.png"><a href="javascript:selflog_show(${items.id})"><img src="../resources/images/in_cart.png"></a><a href="/shopping-cart/cart/choose?action=show"><img src="../resources/images/view_cart.jpg"/></a>
             </div>
          </td>
          
         
         
         
          <!-- 浏览过的商品 -->
          <td width="30%" bgcolor="#EEE" align="center">
             <br>
             <b><font color="#FF7F00">您浏览过的商品</font></b><br>
             <!-- 循环开始 -->
             
             <c:forEach items="${viewList}" var="history">
             <div>
             <dl>
               <dt>
                 <a href="/shopping-cart/shopping/details?id=${history.id}"><img src="../resources/images/${history.picture}" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name">${history.name}</dd> 
               <dd class="dd_city">产地:${history.city}&nbsp;&nbsp;价格:${history.price} ￥ </dd> 
             </dl>
             </div>
            </c:forEach>
            
             <!-- 循环结束 -->
          </td>
        </tr>
      </table>
    </center>
  </body>
</html>
