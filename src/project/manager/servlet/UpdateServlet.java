package project.manager.servlet;

import project.manager.model.*;
import project.manager.service.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.alibaba.fastjson.*;
import java.io.*;

public class UpdateServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Object currentUserObject = request.getSession().getAttribute("user");
        String optionCodeString = request.getParameter("option");

        if (currentUserObject == null)
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        String newUserName = request.getParameter("new-username");
        String newPassword = request.getParameter("new-password");

        User currentUser = (User)currentUserObject;
        User updateUser = new User();
        updateUser.setUserName(newUserName);
        updateUser.setPassword(newPassword);

        UpdateService updateService = new UpdateService(currentUser, updateUser);
        JSONObject responseJSON = new JSONObject();

        switch (optionCodeString)
        {
            case "0": responseJSON.put("statusCode", updateService.updateUserName()); break;
            case "1": responseJSON.put("statusCode", updateService.updatePassword()); break;
        }
        response.getWriter().println(responseJSON);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
