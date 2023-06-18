package project.manager.servlet;

import project.manager.model.User;
import project.manager.service.UpdateService;
import com.alibaba.fastjson2.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        String optionString = request.getParameter("option");
        User currentUser = (User)request.getSession().getAttribute("user");

        if (currentUser == null)
        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        String newUserName = request.getParameter("new-username");
        String newPassword = request.getParameter("new-password");

        User updateUser = new User();
        updateUser.setUserName(newUserName);
        updateUser.setPassword(newPassword);

        UpdateService updateService = new UpdateService(currentUser, updateUser);
        JSONObject responseJSON = new JSONObject();

        switch (optionString)
        {
            case "0" -> responseJSON.put("statusCode", updateService.updateUserName());
            case "1" -> responseJSON.put("statusCode", updateService.updatePassword());
        }
        response.getWriter().println(responseJSON);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
