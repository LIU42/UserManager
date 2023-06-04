package project.manager.dao;

import project.manager.*;
import project.manager.model.*;
import java.sql.*;

public class UserDao
{
    private User user;

    public UserDao(User user)
    {
        this.user = user;
    }

    public boolean isUserNameExist() throws SQLException, ClassNotFoundException
    {
        String querySQL = "SELECT name FROM user WHERE name = ?";
        String userName = user.getUserName();

        Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(querySQL);
        statement.setString(1, userName);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }

    public boolean isUserInfoRight() throws SQLException, ClassNotFoundException
    {
        String querySQL = "SELECT name FROM user WHERE name = ? AND password = ?";
        String userName = user.getUserName();
        String password = user.getPassword();

        Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(querySQL);
        statement.setString(1, userName);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();

        return resultSet.next();
    }

    public int addNewUser() throws SQLException, ClassNotFoundException
    {
        String insertSQL = "INSERT INTO user VALUES (?, ?)";
        String userName = user.getUserName();
        String password = user.getPassword();

        Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(insertSQL);
        statement.setString(1, userName);
        statement.setString(2, password);

        return statement.executeUpdate();
    }

    public int updateUserName(String newUserName) throws SQLException, ClassNotFoundException
    {
        String updateSQL = "UPDATE user SET name = ? WHERE name = ? AND password = ?";
        String userName = user.getUserName();
        String password = user.getPassword();

        Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateSQL);
        statement.setString(1, newUserName);
        statement.setString(2, userName);
        statement.setString(3, password);

        return statement.executeUpdate();
    }

    public int updatePassword(String newPassword) throws SQLException, ClassNotFoundException
    {
        String updateSQL = "UPDATE user SET password = ? WHERE name = ? AND password = ?";
        String userName = user.getUserName();
        String password = user.getPassword();

        Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateSQL);
        statement.setString(1, newPassword);
        statement.setString(2, userName);
        statement.setString(3, password);

        return statement.executeUpdate();
    }

    public int deleteUser() throws SQLException, ClassNotFoundException
    {
        String deleteSQL = "DELETE FROM user WHERE name = ? AND password = ?";
        String userName = user.getUserName();
        String password = user.getPassword();

        Connection connection = DBConnector.getConnection();
        PreparedStatement statement = connection.prepareStatement(deleteSQL);
        statement.setString(1, userName);
        statement.setString(2, password);

        return statement.executeUpdate();
    }
}
