<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh">

    <head>
        <meta charset="utf-8">
        <title>登录页面</title>
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
                <a href="Register.jsp">注册</a>
            </div>
        </div>
       
            <div class="row">
                <div class="login span6" id="login">
                    <form name="myForm" action="LoginServlet" method="POST">
                        <h2>用户 <span class="red"><strong>登录</strong></span></h2>
                        <label for="name">用户名</label>
                        <input type="text" id="loginUser" name="name" >
                        <label for="password">密码</label>
                        <input type="password" id="loginPsw" name="password" placeholder="choose a password...">
                        <button type="submit" >登录</button>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="login span6" id="login">
                    <form name="myForm" action="SellerLoginServlet" method="POST">
                        <h2>销售人员 <span class="red"><strong>登录</strong></span></h2>
                        <label for="name">用户名</label>
                        <input type="text" id="loginUser" name="name" >
                        <label for="password">密码</label>
                        <input type="password" id="loginPsw" name="password" placeholder="choose a password...">
                        <button type="submit" >登录</button>
                    </form>
                </div>
            </div>

            <div class="row">
                <div class="login span6" id="login">
                    <form name="myForm" action="ManagerLoginServlet" method="POST">
                        <h2>管理者 <span class="red"><strong>登录</strong></span></h2>
                        <label for="name">用户名</label>
                        <input type="text" id="loginUser" name="name" >
                        <label for="password">密码</label>
                        <input type="password" id="loginPsw" name="password" placeholder="choose a password...">
                        <button type="submit" >登录</button>
                    </form>
                </div>
            </div>
       

        
    </body>

</html>
