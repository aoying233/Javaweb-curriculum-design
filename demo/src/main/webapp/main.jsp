<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="UTF-8">
        <title>瀚海水产</title>
    </head>
    <body>
        <div id ="container" style="height: 100px;background-color: rgb(24, 189, 189);">
            <div id="header" style="background-color: rgb(24, 189, 189);height: 100px;float: left;">
                <h1 style="margin-bottom:0;">瀚海水产</h1>
            </div>
            <div id="menu" style="background-color: rgb(24, 189, 189);height: 100px;float: right;">
                <p><%=session.getAttribute("name")%>,欢迎您   </p>
                <a href="OutServlet">注销</a>
                <a href="cart.jsp">购物车</a>
            </div>
        </div>
        <div style="float:left">
            <div style="float:left">
                <img src="./img/changyu.jpg" height="500" width="500">
                <br>
                <p>鲳鱼 20元/斤</p>
            </div>
            <div style="float:right">
                <img src="./img/pangxie.jpg" height="500" width="500">
                <br>
                <p>螃蟹 30元/斤 </p>
            </div>
        </div>
        <br>
        <div style="float:left">
            <div style="float:left">
                <img src="./img/daiyu.jpg" height="500" width="500">
                <br>
                <p>带鱼 40元/斤</p>
            </div>
            <div style="float:right">
                <img src="./img/xia.jpg" height="500" width="500">
                <br>
                <p>虾 50元/斤</p>
            </div>
        </div>
    </body>
</html>