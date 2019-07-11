package com.revature;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class App 
{
    
    public static void main(String[] args) 
    {
        int num;
        ArrayList<Register> customer = new ArrayList<>();
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
                System.out.println("City: ");
                String c = myObj.nextLine();
                System.out.println("State: ");
                String s = myObj.nextLine();
                System.out.println("Please enter your birthdate (mm/dd/yyyy): ");
                String d = myObj.nextLine();
                SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
                customer.add(new Register(f,l,a,c,s,d));
                for (Register r: customer)
                {
                    System.out.println(r);
                }
            }

            if (num == 2)
            {

            }

            if (num != 1 || num != 2)
            {
                System.out.println("Invalid entry!");
            }

        } while(num != 3);


    }
}
