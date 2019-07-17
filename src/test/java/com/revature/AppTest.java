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
    
    @Before
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
    
    @Test
    public void TestUser() 
    {
        assertTrue(true);
    }

    @Test
    public static void deleteClients(Scanner sc, User currentUser){
        String client_id;
        System.out.println("Enter username of the client you want to remove");
        client_id = sc.nextLine();
        client_id = sc.nextLine();
        currentUser.delete(client_id);
    }

}
