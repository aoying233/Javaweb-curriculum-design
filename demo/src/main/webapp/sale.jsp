<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Dao.SaleDao,entity.Sale"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>销售日志</title>
  </head>
  
  <body>
    <div id ="container" style="height: 100px;background-color: rgb(24, 189, 189);">
      <div id="header" style="background-color: rgb(24, 189, 189);height: 100px;float: left;">
          <h1 style="margin-bottom:0;">瀚海水产</h1>
      </div>
      <div id="menu" style="background-color: rgb(24, 189, 189);height: 100px;float: right;">
          <p><%=session.getAttribute("name")%>,欢迎您   </p>
          <a href="OutServlet">注销</a>
          <a href="goods.jsp">商品管理</a>
      </div>
    </div>
  <table border="1">
      <tr>
          <td>姓名</td>
          <td>商品名</td>
          <td>单价</td>
          <td>数量</td>
      </tr>
        <%
           SaleDao dao=new SaleDao();
           List<Sale> list =dao.readSale();    
           for(Sale sl:list) {
        %>
          <tr>
              <td><%=sl.getName() %></td>
              <td><%=sl.getGood() %></td>
              <td><%=sl.getPrice() %></td>
              <td><%=sl.getNumber() %></td>
          </tr>
         <%
          }
         %>
  </table>
  </body>
</html>