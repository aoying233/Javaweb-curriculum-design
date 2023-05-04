<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Dao.SellerDao,entity.Seller"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>人员管理</title>
  </head>
  
  <body>
    <div id ="container" style="height: 100px;background-color: rgb(24, 189, 189);">
      <div id="header" style="background-color: rgb(24, 189, 189);height: 100px;float: left;">
          <h1 style="margin-bottom:0;">瀚海水产</h1>
      </div>
      <div id="menu" style="background-color: rgb(24, 189, 189);height: 100px;float: right;">
          <p><%=session.getAttribute("name")%>,欢迎您   </p>
          <a href="OutServlet">注销</a>
          <a href="info.jsp">登录日志</a>
      </div>
    </div>
  <table border="1">
      <tr>
          <td>姓名</td>
          <td>密码</td>
      </tr>
        <%
           SellerDao dao=new SellerDao();
           List<Seller> list =dao.readSeller();    
           for(Seller sl:list) {
        %>
          <tr>
              <td><%=sl.getName() %></td>
              <td><%=sl.getPassword() %></td>
          </tr>
         <%
          }
         %>
  </table>
  <form name="SellerForm" method="post">
    姓名：<input type="text" id="name" name="name">
    密码：<input type="password" id="password" name="password">
    <input type="button" value="修改" onclick="SellerForm.action='ManageChangeServlet';SellerForm.submit()">
    <input type="button" value="添加" onclick="SellerForm.action='ManageAddServlet';SellerForm.submit()">
    <input type="button" value="删除" onclick="SellerForm.action='ManageDeleteServlet';SellerForm.submit()">
  </form>
  </body>
</html>