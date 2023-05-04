<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">

    <head>
        <meta chaarset="utf-8">
        <title>注册</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

    </head>

    <body>
        <div id ="container" style="height: 100px;background-color: rgb(24, 189, 189);">
            <div id="header" style="background-color: rgb(24, 189, 189);height: 100px;float: left;">
                <h1 style="margin-bottom:0;">瀚海水产</h1>
            </div>
            <div id="menu" style="background-color: rgb(24, 189, 189);height: 100px;float: right;">
                <a href="login.jsp">返回登录</a>
            </div>
          </div>
        
        <div class="register-container container">
            <div class="row">
                <div class="login span6" id="login">
                    <form action="RegisterServlet" method="post">
                        <h2>注册 <span class="red"><strong>用户</strong></span></h2>
                        <label for="name">用户名</label>
                        <input type="text" id="name" name="name" placeholder="enter your username...">
                        <label for="password">密码</label>
                        <input type="password" id="password" name="password" placeholder="choose a password...">
                        <button type="submit">注册</button>
                    </form>
                </div>
               
            </div>
        </div>
        
    </body>

</html>
