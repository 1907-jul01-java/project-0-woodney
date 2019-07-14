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

    public void get_username() {
       
        try {
            PreparedStatement pst = connection.prepareStatement("select * from client");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
                System.out.print(": ");
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            
        }

        ;

    }

}