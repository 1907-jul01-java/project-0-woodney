package com.revature;
import java.util.Scanner;
import java.text.SimpleDateFormat;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome to Revature Bank!");
        System.out.println("Please choose one of the following: ");
        System.out.println("1.Register");
        System.out.println("2.Login");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        Scanner myObj = new Scanner(System.in);
    
        if (num == 1)
        {
            System.out.println("Please enter your First name: ");
            String f = myObj.nextLine();
            System.out.println("Please enter your last name: ");
            String l = myObj.nextLine();
            System.out.println("Please enter your address: ");
            String a = myObj.nextLine();
            System.out.println("Please enter your birthdate (mm/dd/yyyy): ");
            String d = myObj.nextLine();
            SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
            Register Customer = new Register(f, l, a, d);
            System.out.println(Customer.toString());
        }

    }
}
