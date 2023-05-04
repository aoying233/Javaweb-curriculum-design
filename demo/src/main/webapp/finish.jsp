<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>购买成功</title>
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
    <div>
        <p>购买成功</p>
        <a href="OutServlet">退出</a>
        <a href="main.jsp">返回主页</a>
    </div>
</body>
</html>