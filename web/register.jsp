<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="style/background.css">
        <link rel="stylesheet" href="style/login.css">
        <link rel="stylesheet" href="style/dialog.css">
        <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
        <script src="https://code.jquery.com/color/jquery.color-2.2.0.min.js"></script>
        <script src="script/animate.js"></script>
        <script src="script/register.js"></script>
    </head>
    <body onload="mainWrapperFadeIn()">
        <div id="container">
            <div id="main-wrapper">
                <div id="header">注册</div>
                <div id="input-wrapper">
                    <input id="username-input" class="input-frame" type="text" placeholder="请输入用户名">
                    <input id="password-input" class="input-frame" type="password" placeholder="请输入密码">
                    <button id="submit-button" onclick="doRegister()">注册</button>
                </div>
                <div id="error-info-wrapper"></div>
                <div id="switch-link-wrapper">已有账号？
                    <a id="switch-link" href="login.jsp">登录现有账户</a>
                </div>
            </div>
            <div id="dialog-wrapper">
                <div id="dialog">
                    <p id="dialog-info">注册成功！请前往登录页面</p>
                    <div id="dialog-button" onclick="jumpToLoginPage()">确定</div>
                </div>
            </div>
        </div>
    </body>
</html>