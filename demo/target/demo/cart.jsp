<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Dao.GoodsDao,Dao.CartDao,Dao.SaleDao,entity.Goods,entity.Cart"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车</title>
  </head>
  
  <body>
    <div id ="container" style="height: 100px;background-color: rgb(24, 189, 189);">
        <div id="header" style="background-color: rgb(24, 189, 189);height: 100px;float: left;">
            <h1 style="margin-bottom:0;">瀚海水产</h1>
        </div>
        <div id="menu" style="background-color: rgb(24, 189, 189);height: 100px;float: right;">
            <p><%=session.getAttribute("name")%>,欢迎您   </p>
            <a href="OutServlet">注销</a>
            <a href="main.jsp">主页</a>
        </div>
    </div>
    <p>商品列表：</p>
  <table border="1">
      <tr>
          <td>商品名</td>
          <td>价格</td>
      </tr>
        <%
           GoodsDao dao=new GoodsDao();
           List<Goods> list =dao.readGoods();    
           for(Goods sl:list) {
        %>
          <tr>
              <td><%=sl.getName() %></td>
              <td><%=sl.getPrice() %></td>
          </tr>
         <%
          }
         %>
  </table>
  <div>
    <p>最近最多人购买：</p>
    <table border="1">
      <tr>
          <td>商品名</td>
      </tr>
        <%
           SaleDao saledao=new SaleDao();
           List<String> goodlist =saledao.recommend();    
           for(String sl:goodlist) {
        %>
          <tr>
              <td><%=sl %></td>
          </tr>
         <%
          }
         %>
  </table>
  </div>
  <form name="GoodsForm" method="post">
    商品名：<input type="text" id="good" name="good">
    数量：<input type="text" id="number" name="number">
    <input type="button" value="添加或修改" onclick="GoodsForm.action='OrdersAddServlet';GoodsForm.submit()">
    <p>购物车：</p>
    <table border="1">
    <tr>
        <td>商品名</td>
        <td>数量</td>
    </tr>
      <%
         CartDao cartdao=new CartDao();
         List<Goods> cartlist =cartdao.readCart((String)session.getAttribute("name"));    
         for(Goods sl:cartlist) {
      %>
        <tr>
            <td><%=sl.getName() %></td>
            <td><%=sl.getPrice() %></td>
        </tr>
       <%
        }
       %>
</table>
    <input type="button" value="购买" onclick="GoodsForm.action='BuyServlet';GoodsForm.submit()">
  </form>
  
  </body>
</html>