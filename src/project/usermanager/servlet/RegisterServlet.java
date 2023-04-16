package project.usermanager.servlet;

import project.usermanager.model.*;
import project.usermanager.dao.*;
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

        User user = new User(userName, password);
        UserDao userDao = new UserDao(user);
        JSONObject responseJSON = new JSONObject();

        try
        {
            if (!userDao.isUserNameValid())
            {
                responseJSON.put("statusCode", 10001);
            }
            else if (!userDao.isPasswordValid())
            {
                responseJSON.put("statusCode", 10002);
            }
            else if (userDao.isUserNameExist())
            {
                responseJSON.put("statusCode", 10003);
            }
            else
            {
                userDao.addNewUser();
                responseJSON.put("statusCode", 10000);
            }
        }
        catch (Exception exception)
        {
            responseJSON.put("statusCode", 10004);
        }
        response.getWriter().println(responseJSON);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
