package project.manager.service;

import project.manager.model.User;
import project.manager.dao.UserDao;

public class RegisterService
{
    private UserDao userDao;
    private User user;

    public RegisterService(User user)
    {
        this.userDao = new UserDao(user);
        this.user = user;
    }

    public int doRegister()
    {
        try
        {
            if (user.isUserNameInvalid())
            {
                return 10001;
            }
            if (user.isPasswordInvalid())
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
