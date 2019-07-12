package com.revature;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class App 
{
    
    public static void main(String[] args) 
    {
        int num, client = 0;
        String user,pass,cur_user,cur_pass;
        ArrayList<Register> customers = new ArrayList<>();

        do
        {

            System.out.println("Welcome to Revature Bank!");
            System.out.println("Please choose one of the following: ");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            Scanner scan = new Scanner(System.in);
            num = scan.nextInt();
            Scanner myObj = new Scanner(System.in);

            if (num == 1)
            {
                System.out.println("Please enter your First name: ");
                String f = myObj.nextLine();
                System.out.println("Please enter your last name: ");
                String l = myObj.nextLine();
                System.out.println("Please enter your address: ");
                String a = myObj.nextLine();
                System.out.println("Create your username: ");
                String u = myObj.nextLine();
                System.out.println("Create your password: ");
                String p = myObj.nextLine();
                System.out.println("City: ");
                String c = myObj.nextLine();
                System.out.println("State: ");
                String s = myObj.nextLine();
                System.out.println("Please enter your birthdate (mm/dd/yyyy): ");
                String d = myObj.nextLine();
                SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
                customers.add(new Register(f,l,u,p,a,c,s,d));
                cur_pass = customers.get(client).getPassword();
                cur_user = customers.get(client).getUsername();
            }

            if (num == 2)
            {
                System.out.println("Username: ");
                user = myObj.nextLine();
                System.out.println("Password: ");
                pass = myObj.nextLine();
            }

            if (num != 1 && num != 2 && num != 3)
            {
                System.err.println("Error, Invalid Entry");;
            }

        } while(num != 3);


    }
}
