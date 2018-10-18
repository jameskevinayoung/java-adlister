package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {

    //Use steps to form the connection
    private Connection connection;

    public MySQLUsersDao(Config config) {

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connection to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String userQuery = "SELECT username FROM users WHERE username = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(userQuery);

            statement.setString(1, username);


            ResultSet rs = statement.executeQuery();

//            ResultSet rs = statement.getGeneratedKeys();

            rs.next();

            return createUserFromResults(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error! ", e);
        }catch(RuntimeException e){
            throw new RuntimeException("Error: could not locate user", e);
        }

    }

    private User createUserFromResults(ResultSet rs) {
        User user = new User();

        try {
            user = new User(rs.getLong(1),
                    rs.getString(2 ),
                    rs.getString(3),
                    rs.getString(4)
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error creating user", e);
        }
        return user;
    }

    //Use similar steps as MySQLAdsDao insert method;

    @Override
    public Long insert(User user) {
        String userInsertQuery = "INSERT INTO users (username, email, password) VALUES (?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(userInsertQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            rs.next();

            return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error! ", e);
        }
    }


}
