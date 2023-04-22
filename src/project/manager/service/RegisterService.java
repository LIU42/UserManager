package project.manager.service;

import project.manager.dao.*;
import project.manager.model.*;

public class RegisterService
{
    private UserDao userDao;

    public RegisterService(User user)
    {
        this.userDao = new UserDao(user);
    }

    public int doRegister()
    {
        try
        {
            if (userDao.isUserNameInvalid())
            {
                return 10001;
            }
            if (userDao.isPasswordInvalid())
            {
                return 10002;
            }
            if (userDao.isUserNameExist())
            {
                return 10003;
            }
            userDao.addNewUser();
        }
        catch (Exception exception)
        {
            return 10004;
        }
        return 10000;
    }
}
