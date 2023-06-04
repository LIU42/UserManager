package project.manager.service;

import project.manager.dao.*;
import project.manager.model.*;

public class UpdateService
{
    private UserDao currentUserDao;
    private UserDao updateUserDao;
    private User currentUser;
    private User updateUser;

    public UpdateService(User currentUser, User updateUser)
    {
        this.currentUserDao = new UserDao(currentUser);
        this.updateUserDao = new UserDao(updateUser);
        this.currentUser = currentUser;
        this.updateUser = updateUser;
    }

    public int updateUserName()
    {
        try
        {
            if (updateUser.getUserName() == null)
            {
                return 10001;
            }
            if (updateUser.isUserNameInvalid())
            {
                return 10002;
            }
            if (updateUserDao.isUserNameExist())
            {
                return 10003;
            }
            currentUserDao.updateUserName(updateUser.getUserName());
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
            if (updateUser.getUserName() == null)
            {
                return 10001;
            }
            if (updateUser.isPasswordInvalid())
            {
                return 10002;
            }
            currentUserDao.updatePassword(updateUser.getPassword());
        }
        catch (Exception exception)
        {
            return 10003;
        }
        return 10000;
    }
}
