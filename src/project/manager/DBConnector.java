package project.manager;

import java.sql.*;

public class DBConnector
{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/user_manager";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "132465";

    private static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        if (connection == null)
        {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }
}
