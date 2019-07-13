package com.revature;
import com.revature.util.ConnectionUtil;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class App 
{
    static String f,l,a,u,p,c,s,d;
    static int num, client = -1;
    
    public static void main(String[] args) 
    {
        String user,pass,cur_user,cur_pass;
        ArrayList<Register> customers = new ArrayList<>();
        ConnectionUtil connectionUtil = new ConnectionUtil();
        User new_user = new User(connectionUtil.getConnection());
        new_user.insert(new Register("ruth_30","leo3030"));
        connectionUtil.close();

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
                client++;
                System.out.println("Please enter your First name: ");
                f = myObj.nextLine();
                System.out.println("Please enter your last name: ");
                l = myObj.nextLine();
                System.out.println("Please enter your address: ");
                a = myObj.nextLine();
                System.out.println("Create your username: ");
                u = myObj.nextLine();
                System.out.println("Create your password: ");
                p = myObj.nextLine();
                System.out.println("City: ");
                c = myObj.nextLine();
                System.out.println("State: ");
                s = myObj.nextLine();
                System.out.println("Please enter your birthdate (mm/dd/yyyy): ");
                d = myObj.nextLine();
                SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
                customers.add(new Register(f,l,u,p,a,c,s,d));
                cur_pass = customers.get(client).getPassword();
                cur_user = customers.get(client).getUsername();
            }

            else if (num == 2)
            {
                System.out.println(u + " " + p);
                System.out.println("Username: ");
                user = myObj.nextLine();
                System.out.println("Password: ");
                pass = myObj.nextLine();
                if (user != u && pass != p)
                {
                    System.out.println("False");
                }
                else
                {
                    System.out.println("True");
                }
            }

            else if (num != 1 && num != 2 && num != 3)
            {
                System.err.println("Error, Invalid Entry");;
            }

        } while(num != 3);


    }
}
