package com.revature;
import java.sql.*;
import com.revature.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee
 */

 public class Employee implements EmployeeDao<Register> {

    Connection connection;

    public Employee(Connection connection) {
        this.connection = connection;
    }
    
    public void view() {
        int counter = 1;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from client");
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                System.out.println(counter + ". ");
                System.out.print("First name: ");
                System.out.print(rs.getString(1));
                System.out.print("Last name: ");
                System.out.print(rs.getString(2));
                System.out.print("Username: ");
                System.out.print(rs.getString(3));
                System.out.print("Password: ");
                System.out.print(rs.getString(4));
                System.out.print("Address: ");
                System.out.print(rs.getString(5));
                System.out.print("City: ");
                System.out.print(rs.getString(6));
                System.out.print("State: ");
                System.out.print(rs.getString(7));
                System.out.print("DOB: ");
                System.out.print(rs.getString(8));
                System.out.println();
                counter++;
            }
        } catch (SQLException e) {

        }
    }

    public void delete() {

    }

    public void insert() {

    }

    public void depositFunds(int a, int c, String f) {

    }

    public void withdrawFunds(int a, int c, String f) {

    }

 }
 