package project.manager.model;

public class User
{
    private String userName;
    private String password;

    public User()
    {
        this.userName = null;
        this.password = null;
    }

    public User(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

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

    public String toString()
    {
        return "[Name: " + userName + ", Password: " + password + "]";
    }
}
