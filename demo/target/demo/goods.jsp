<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Dao.GoodsDao,entity.Goods"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品管理</title>
  </head>
  
  <body>
    <div id ="container" style="height: 100px;background-color: rgb(24, 189, 189);">
      <div id="header" style="background-color: rgb(24, 189, 189);height: 100px;float: left;">
          <h1 style="margin-bottom:0;">瀚海水产</h1>
      </div>
      <div id="menu" style="background-color: rgb(24, 189, 189);height: 100px;float: right;">
          <p><%=session.getAttribute("name")%>,欢迎您   </p>
          <a href="OutServlet">注销</a>
          <a href="sale.jsp">销售日志</a>
      </div>
    </div>
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
  <form name="GoodsForm" method="post">
    商品名：<input type="text" id="name" name="name">
    价格：<input type="text" id="price" name="price">
    <input type="button" value="修改" onclick="GoodsForm.action='GoodsChangeServlet';GoodsForm.submit()">
    <input type="button" value="添加" onclick="GoodsForm.action='GoodsAddServlet';GoodsForm.submit()">
    <input type="button" value="删除" onclick="GoodsForm.action='GoodsDeleteServlet';GoodsForm.submit()">
  </form>
  </body>
</html>