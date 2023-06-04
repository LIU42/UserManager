package project.manager.model;

public class User
{
    private static final int USERNAME_MAX_LENGTH = 20;
    private static final int USERNAME_MIN_LENGTH = 3;
    private static final int PASSWORD_MAX_LENGTH = 15;
    private static final int PASSWORD_MIN_LENGTH = 6;

    private String userName;
    private String password;

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean isUserNameInvalid()
    {
        if (userName.length() < USERNAME_MIN_LENGTH || userName.length() > USERNAME_MAX_LENGTH)
        {
            return true;
        }
        if (Character.isDigit(userName.charAt(0)))
        {
            return true;
        }
        for (int i = 0; i < userName.length(); i++)
        {
            if (!Character.isLetter(userName.charAt(i)) && !Character.isDigit(userName.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordInvalid()
    {
        if (password.length() >= PASSWORD_MIN_LENGTH && password.length() <= PASSWORD_MAX_LENGTH)
        {
            return false;
        }
        return true;
    }
}
