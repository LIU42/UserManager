package project.manager.servlet;

import project.manager.model.*;
import project.manager.service.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.alibaba.fastjson.*;
import java.io.*;

public class RegisterServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        RegisterService registerService = new RegisterService(user);
        JSONObject responseJSON = new JSONObject();

        responseJSON.put("statusCode", registerService.doRegister());
        response.getWriter().println(responseJSON);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
