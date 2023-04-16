package project.manager.servlet;

import project.manager.model.*;
import project.manager.dao.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.alibaba.fastjson.*;
import java.io.*;

public class UpdateServlet extends HttpServlet
{
    protected int updateUserName(String newUserName, UserDao userDao, UserDao newUserDao)
    {
        try
        {
            if (!newUserDao.isUserNameValid())
            {
                return 10002;
            }
            if (newUserDao.isUserNameExist())
            {
                return 10003;
            }
            userDao.updateUserName(newUserName);
        }
        catch (Exception exception)
        {
            return 10004;
        }
        return 10000;
    }

    protected int updatePassword(String newPassword, UserDao userDao, UserDao newUserDao)
    {
        try
        {
            if (!newUserDao.isPasswordValid())
            {
                return 10002;
            }
            userDao.updatePassword(newPassword);
        }
        catch (Exception exception)
        {
            return 10003;
        }
        return 10000;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Object userObject = request.getSession().getAttribute("user");

        if (userObject == null)
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        String newUserName = request.getParameter("newusername");
        String newPassword = request.getParameter("newpassword");

        User user = (User)userObject;
        User newUser = new User(newUserName, newPassword);

        UserDao userDao = new UserDao(user);
        UserDao newUserDao = new UserDao(newUser);
        JSONObject responseJSON = new JSONObject();

        if (newUserName != null)
        {
            responseJSON.put("statusCode", updateUserName(newUserName, userDao, newUserDao));
        }
        else if (newPassword != null)
        {
            responseJSON.put("statusCode", updatePassword(newPassword, userDao, newUserDao));
        }
        else
        {
            responseJSON.put("statusCode", 10001);
        }
        response.getWriter().println(responseJSON);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
