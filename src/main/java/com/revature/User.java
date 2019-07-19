package com.revature;
import java.sql.*;
import com.revature.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User
 */
public class User implements UserDao<Register> {
    Connection connection;

    public User(Connection connection) {
        this.connection = connection;
    }
   
    @Override
    public void view() 
    {
        int counter = 1;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from client");
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                System.out.println(counter + ". ");
                System.out.print("First name: ");
                System.out.print(rs.getString(2));
                System.out.print(" Last name: ");
                System.out.print(rs.getString(3));
                System.out.print(" Username: ");
                System.out.print(rs.getString(4));
                System.out.print(" Password: ");
                System.out.print(rs.getString(5));
                System.out.print(" Address: ");
                System.out.print(rs.getString(6));
                System.out.print(" City: ");
                System.out.print(rs.getString(7));
                System.out.print(" State: ");
                System.out.print(rs.getString(8));
                System.out.print(" DOB: ");
                System.out.print(rs.getString(9));
                System.out.println();
                counter++;
            }
        } catch (SQLException e) {

        }
    }

    public boolean checkjointaccount(String u, String p) {
        boolean success = false;
        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from joint where username = ? and password = ?");
            pStatement.setString(1, u);
            pStatement.setString(2, p);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                
                if(rs.getString(2).compareTo(u) == 0 && rs.getString(3).compareTo(p) == 0) {
                    success = true;
                }
                
                System.out.print(rs.getString(3));
            }
            

        } catch (SQLException e) {

        }

        if(success = true){
            return true;
        }
        else{
        return false;
        }
    }

    public void viewAccount(int c){

        try {
            PreparedStatement pStatement = connection.prepareStatement("select * from bankaccount where id = ?");
            pStatement.setInt(1, c);
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
            
                System.out.print("Checking: ");
                System.out.print(rs.getInt(2));
                System.out.println();
                System.out.println("Savings: ");
                System.out.print(rs.getString(3));
                System.out.println();
            }
            

        } catch (SQLException e) {

        }
    }

    public void deleteAccount(String c, int a) {

        try {
            PreparedStatement pStatement = connection.prepareStatement("delete from bankaccount where id =?");
            pStatement.setInt(1, a);
            pStatement.execute();
            PreparedStatement pst = connection.prepareStatement("delete from client where username =?");
            pst.setString(1, c);
            pst.execute();

        } catch (SQLException e) {

        }

    }

    public void insert() {


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
            pst.setInt(1, difference);
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


    public void joinAccounts(int a, int b, int ca, int sa, int cb, int sb, String u, String p) {
        
        int checking_account_j = ca+cb;
        int savings_account_j = sa+sb;
        try {
            PreparedStatement pst = connection.prepareStatement("insert into joint(username,password,checking_account_balance,savings_account_balance) values (?,?,?,?)");
            pst.setString(1, u);
            pst.setString(2, p);
            pst.setInt(3, checking_account_j);
            pst.setInt(4, savings_account_j);
            pst.executeUpdate();
    
        } catch (SQLException e) {
            
        }

    }



}