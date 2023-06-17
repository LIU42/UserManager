package project.manager.service;

import project.manager.model.User;
import project.manager.dao.UserDao;

public class LoginService
{
    private UserDao userDao;

    public LoginService(User user)
    {
        this.userDao = new UserDao(user);
    }

    public int doLogin()
    {
        try
        {
            if (userDao.isUserInfoRight())
            {
                return 10000;
            }
        }
        catch (Exception exception)
        {
            return 10002;
        }
        return 10001;
    }
}
