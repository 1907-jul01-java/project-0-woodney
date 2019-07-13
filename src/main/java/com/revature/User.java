package com.revature;
import java.sql.*;
import com.revature.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User
 */
public class User implements Dao<Register> {
    Connection connection;

    @Override
    public void insert(Register customer) {
        try {
            PreparedStatement pStatement = connection.prepareStatement("insert into client(username, user_password) values(?, ?)");
            pStatement.setString(1, customer.getUsername());
            pStatement.setString(2, customer.getPassword());
            pStatement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public User(Connection connection) {
        this.connection = connection;
    }

}