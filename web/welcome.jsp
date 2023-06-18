<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="project.manager.model.User" %>

<%
    User user = (User)request.getSession().getAttribute("User");

    if (user == null)
    {
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return;
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><%=user.getUserName()%> - Welcome</title>
        <link rel="stylesheet" href="style/background.css">
        <link rel="stylesheet" href="style/welcome.css">
        <link rel="stylesheet" href="style/dialog.css">
        <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
        <script src="https://code.jquery.com/color/jquery.color-2.2.0.min.js"></script>
        <script src="script/animate.js"></script>
        <script src="script/welcome.js"></script>
    </head>
    <body>
        <div id="container">
            <div id="menu-bar">
                <div id="welcome-info"><%=user.getUserName()%> 欢迎使用！</div>
            </div>
        </div>
    </body>
</html>
