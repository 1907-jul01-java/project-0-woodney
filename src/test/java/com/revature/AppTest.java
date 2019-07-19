package com.revature;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;
import com.revature.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest {
    Connection connection;
    Scanner sc = new Scanner(System.in);
    
    @Test
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
    @Test
    public void TestUser() 
    {
        assertTrue(true);
    }

    @Test
    public static void deleteClients(Scanner sc, User currentUser){
        String client_username = "";
        int client_id = 0;
        System.out.println("Enter the id of the client you want to remove");
        client_id = sc.nextInt();
        System.out.println("Enter username of the client you want to remove");
        sc.nextLine();
        client_username = sc.nextLine();
        currentUser.deleteAccount(client_username,client_id);
    }


}
