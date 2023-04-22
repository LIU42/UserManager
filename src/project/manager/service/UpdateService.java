package project.manager.service;

import project.manager.dao.*;
import project.manager.model.*;

public class UpdateService
{
    private UserDao currentUserDao;
    private UserDao updateUserDao;
    private String newUserName;
    private String newPassword;

    public UpdateService(User currentUser, User updateUser)
    {
        this.currentUserDao = new UserDao(currentUser);
        this.updateUserDao = new UserDao(updateUser);
        this.newUserName = updateUser.getUserName();
        this.newPassword = updateUser.getPassword();
    }

    public int updateUserName()
    {
        try
        {
            if (newUserName == null)
            {
                return 10001;
            }
            if (updateUserDao.isUserNameInvalid())
            {
                return 10002;
            }
            if (updateUserDao.isUserNameExist())
            {
                return 10003;
            }
            currentUserDao.updateUserName(newUserName);
        }
        catch (Exception exception)
        {
            return 10004;
        }
        return 10000;
    }

    public int updatePassword()
    {
        try
        {
            if (newPassword == null)
            {
                return 10001;
            }
            if (updateUserDao.isPasswordInvalid())
            {
                return 10002;
            }
            currentUserDao.updatePassword(newPassword);
        }
        catch (Exception exception)
        {
            return 10003;
        }
        return 10000;
    }
}
