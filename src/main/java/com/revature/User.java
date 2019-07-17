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

    public User(Connection connection) {
        this.connection = connection;
    }
   
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

    public void createUser(Register customer) {
        try {
            
            PreparedStatement pStatement = connection.prepareStatement("insert into client(firstname,lastname,username,user_password,user_address,city,user_state,DOB) values (?, ?, ?, ?, ?, ?, ?, ?)");
            pStatement.setString(1, customer.getFirstname());
            pStatement.setString(2, customer.getLastname());
            pStatement.setString(3, customer.getUsername());
            pStatement.setString(4, customer.getPassword());
            pStatement.setString(5, customer.getAddress());
            pStatement.setString(6, customer.getCity());
            pStatement.setString(7, customer.getState());
            pStatement.setString(8, customer.getBirthdate());
            pStatement.executeUpdate();
            PreparedStatement pst = connection.prepareStatement("insert into bankaccount(checking_account_balance, savings_account_balance) values (?,?)");
            pst.setFloat(1, 0);
            pst.setFloat(2, 0);
            pst.executeUpdate();

        } catch (SQLException e) {

        }

    }
    /*
    public int get_client_id(String u, String p) {
        int c_id = 0;
        try {
            PreparedStatement pst = connection.prepareStatement("select id from client where username = ? a user_password = ?");
            pst.setString(1, u);
            pst.setString(2, p);
            ResultSet rs = pst.executeQuery();
            //return rs.getInt("id");
            c_id = rs.getInt("id");
        }catch (SQLException e) {

        }
        return c_id;
    }
    */

    public void get_username() {
       
        try {
            PreparedStatement pst = connection.prepareStatement("select * from client");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
            
                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.print(rs.getString(2));
                System.out.print(": ");
                System.out.print(rs.getString(3));
            }
        } catch (SQLException e) {
            
        }

    }

    public void printSummary(int c) {
        try {
            PreparedStatement pst = connection.prepareStatement("select * from bankaccount where id = ?");
            pst.setInt(1, c);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            
                System.out.print("Checkings: ");
                System.out.println(rs.getInt("checking_account_balance"));
                System.out.print("Savings: ");
                System.out.print(rs.getInt("savings_account_balance"));
                System.out.println();
            }
    
        } catch (SQLException e) {
            
        }
    }

    public int get_checking_balance(int c) {
        int checking = 0;
        try {
            PreparedStatement pst = connection.prepareStatement("select checking_account_balance from bankaccount where id = ?" );
            pst.setInt(1, c);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                checking = rs.getInt("checking_account_balance");
            }
    
        } catch (SQLException e) {
            
        }

        return checking;
    }

    public int get_savings_balance(int c) {
        int savings = 0;
        try {
            PreparedStatement pst = connection.prepareStatement("select savings_account_balance from bankaccount where id = ?");
            pst.setInt(1, c);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
               savings = rs.getInt("savings_account_balance");
            }
    
        } catch (SQLException e) {
            
        }

        return savings;
    }

    public void showTransHistory(Register customer) {
    
    }

    public int depositFunds(int a, String f, int c) {
        int savings = get_savings_balance(c) + a;
        int checking = get_checking_balance(c) + a;
        int difference;

        if (f == "checking_account_balance"){
            difference = checking;
        }
        else{
            difference = savings;
        }

        try {
            PreparedStatement pst = connection.prepareStatement("update bankaccount set "+ f +"  = ? where id = ?");
            pst.setDouble(1, difference);
            pst.setInt(2, c);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                checking = rs.getInt("checking_account_balance");
            }
    
        } catch (SQLException e) {
            
        }

        return checking;
    }

    public int withdrawFunds(int a, String f, int c) {
         int savings = get_savings_balance(c) - a;
         int checking = get_checking_balance(c) - a;
         int difference;
        
         if (f == "checking_account_balance"){
             difference = checking;
         }
         else{
             difference = savings;
         }
        
        try {
            PreparedStatement pst = connection.prepareStatement("update bankaccount set "+ f +" = ? where id = ?");
            pst.setInt(1, difference);
            pst.setInt(2, c);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                savings = rs.getInt("checking_account_balance");
            }
    
        } catch (SQLException e) {
            
        }

        return savings;
    }


    public void joinAccounts(Register customer){
    
    }



}