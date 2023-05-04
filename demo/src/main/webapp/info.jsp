<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Dao.InfoDao,entity.Info"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录日志</title>
  </head>
  
  <body>
    <div id ="container" style="height: 100px;background-color: rgb(24, 189, 189);">
      <div id="header" style="background-color: rgb(24, 189, 189);height: 100px;float: left;">
          <h1 style="margin-bottom:0;">瀚海水产</h1>
      </div>
      <div id="menu" style="background-color: rgb(24, 189, 189);height: 100px;float: right;">
          <p><%=session.getAttribute("name")%>,欢迎您   </p>
          <a href="OutServlet">注销</a>
      </div>
    </div>
  <table border="1">
      <tr>
          <td>IP</td>
          <td>时间</td>
          <td>操作</td>
      </tr>
        <%
           InfoDao dao=new InfoDao();
           List<Info> list =dao.readInfo();    
           for(Info sl:list) {
        %>
          <tr>
              <td><%=sl.getIp() %></td>
              <td><%=sl.getTime() %></td>
              <td><%=sl.getOp() %></td>
          </tr>
         <%
          }
         %>
  </table>
  </body>
</html>