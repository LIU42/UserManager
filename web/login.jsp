<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="style/background.css">
        <link rel="stylesheet" href="style/login.css">
        <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
        <script src="https://code.jquery.com/color/jquery.color-2.2.0.min.js"></script>
        <script src="script/animate.js"></script>
        <script src="script/login.js"></script>
    </head>
    <body onload="mainWrapperFadeIn()">
        <div id="container">
            <div id="main-wrapper">
                <div id="header">登录</div>
                <div id="input-wrapper">
                    <input id="username-input" class="input-frame" type="text" placeholder="请输入用户名">
                    <input id="password-input" class="input-frame" type="password" placeholder="请输入密码">
                    <button id="submit-button" onclick="doLogin()">登录</button>
                </div>
                <div id="error-info-wrapper"></div>
                <div id="switch-link-wrapper">还未注册？
                    <a id="switch-link" href="register.jsp">注册新用户</a>
                </div>
            </div>
        </div>
    </body>
</html>