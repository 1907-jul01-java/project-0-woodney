package com.revature;
import com.revature.util.ConnectionUtil;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Random;


public class App 
{
    static String f,l,a,u,p,c,s,d;
    static int num, client = 0;

    public static void main(String[] args) 
    {
        ConnectionUtil connectionUtil = new ConnectionUtil();
        User new_user = new User(connectionUtil.getConnection());
        //new_user.insert(new Register("ruth_30","leo3030"));
        Register newCustomer = new Register();
        App.mainMenu(new_user);
        connectionUtil.close();
    }

    public static void mainMenu(User new_user) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Register> customers = new ArrayList<>();

        do
        {

            System.out.println("Welcome to Revature Bank!");
            System.out.println("Please choose one of the following: ");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Employee Login");
            System.out.println("4.Exit");
            num = sc.nextInt();

            if (num == 1)
            {
                f = sc.nextLine();
                System.out.println("Please enter your First name: ");
                f = sc.nextLine();
                System.out.println("Please enter your last name: ");
                l = sc.nextLine();
                System.out.println("Create your username: ");
                u = sc.nextLine();
                System.out.println("Create your password: ");
                p = sc.nextLine();
                System.out.println("Please enter your address: ");
                a = sc.nextLine();
                System.out.println("City: ");
                c = sc.nextLine();
                System.out.println("State: ");
                s = sc.nextLine();
                System.out.println("Please enter your birthdate (mm/dd/yyyy): ");
                d = sc.nextLine();
                SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
                new_user.createUser(new Register(f,l,u,p,a,c,s,d));
                customers.add(new Register(f,l,u,p,a,c,s,d));
                System.out.printf("New user %s, %s created. \n", f, l);
                System.out.printf("Your username: %s, Your password: %s. Store information in a secure place. \n", u, p);
                client++;
            }
            

            else if (num == 2)
            {
                Register cur_User;
                boolean success = false;
                do
                {
                    u = sc.nextLine();
                    System.out.println("Enter username: ");
                    u = sc.nextLine();
                    System.out.println("Enter password: ");
                    p = sc.nextLine();
                    //System.out.println(customers.get(0).getUsername());

                    for (Register r : customers) {
                        if (r.getUsername().compareTo(u) == 0 && r.getPassword().compareTo(p) == 0) {
                                System.out.println("Login Successful!");
                                success = true;
                        }
                    }
                }while(success == false);

                while(true) {
                    App.userMenu(sc, new_user);   
                }
        
            }

    
            else if (num < 1 || num > 4)
            {
                System.err.println("Error, Invalid Entry");
            }

        }while(num != 4);

    }

    public static void userMenu(Scanner sc, User currentUser) { 
        currentUser.printSummary(client);
        int choice;

        do {
            System.out.printf("Welcome, what would you like to do?\n");
            System.out.println("  1) Show account transaction history");
            System.out.println("  2) Withdraw");
            System.out.println("  3) Deposit");
            System.out.println("  4) Transfer");
            System.out.println("  5) Create joint account");
            System.out.println("  6) Logout");
            choice = sc.nextInt();

            if (choice < 1 || choice > 6)
            {
                System.out.println("Invalid choice. Please choose 1-5");
            }
        }while(choice < 1 || choice > 6);

        switch (choice) {

            case 1: 
                //App.showTransHistory(theUser, sc);
                break;
            case 2: 
                App.withdrawFunds(sc,currentUser,client);
                break;
            case 3:
                App.depositFunds(sc,currentUser,client);
                break;
            case 4:
                App.transferFunds(sc,currentUser,client);
                break;
            case 5:
                break;
            case 6:
                App.mainMenu(currentUser);
        }

        if (choice !=6){
            App.userMenu(sc, currentUser);
        }


    }
    /*
    public static void showTransHistory(Register theUser, Scanner sc) {
    
        int theAcct;

        do {
            System.out.printf("Enter the number (1-%d) of the account\n" + " whose transactions you want to see: ", theUser.numAccounts());
            theAcct = sc.nextInt() -1;
            if (theAcct < 0 || theAcct >= theUser.numAccounts()) {
                System.out.println("Invalid account. Please try again. ");
            }

        } while(theAcct < 0 || theAcct >= theUser.numAccounts());

        theUser.printAcctTransHistory(theAcct);
    }
    */

    public static void transferFunds(Scanner sc, User currentUser, int client) {

        int fromAcct,toAcct;
        boolean valid = false;
        int checking_acctBal,savings_acctBal,amount;
        String checking = "checking_account_balance";
        String savings = "savings_account_balance";

        do {
            System.out.println("Which account do you want to transfer from?");
            System.out.println("1.Checking");
            System.out.println("2.Savings");
            fromAcct = sc.nextInt();
            if(fromAcct < 1 || fromAcct > 2) {
                System.out.println("Invalid account. Please try again.");
            }
        }while(fromAcct < 1 || fromAcct > 2);
        
        if (fromAcct == 1)
        {
            
            checking_acctBal = currentUser.get_checking_balance(client);
            System.out.println(checking_acctBal);
            System.out.print("Enter the amount to transfer: ");
            amount = sc.nextInt();
    
                if (amount < 0) {
                    System.out.println("Amount must be greater than zero");
                }
                else if (amount > checking_acctBal) {
                    System.out.printf("Amount must not be greater than\n" + "balance of $%.02f.\n", checking_acctBal);
                }
                else {
                    System.out.println("Transfer to savings account ");
                    currentUser.withdrawFunds(amount,checking,client);
                    currentUser.depositFunds(amount, savings,client);
                    App.userMenu(sc, currentUser);
                }
        }

        else {
            savings_acctBal = currentUser.get_savings_balance(client);
            System.out.println(savings_acctBal);

                System.out.print("Enter the amount to transfer: ");
                amount = sc.nextInt();
    
                if (amount < 0) {
                    System.out.println("Amount must be greater than zero");
                }
                else if (amount > savings_acctBal) {
                    System.out.printf("Amount must not be greater than\n" + "balance of $%.02f.\n", savings_acctBal);
                }
                else {
                    System.out.println("Transfer to checking account");
                    currentUser.withdrawFunds(amount, savings,client);
                    currentUser.depositFunds(amount, checking,client);
                    App.userMenu(sc, currentUser);
                }
        }

    }

    public static void withdrawFunds(Scanner sc, User currentUser, int client) {

        int fromAcct;
        boolean valid = false;
        int checking_acctBal,savings_acctBal,amount;
        String checking = "checking_account_balance";
        String savings = "savings_account_balance";

        do {
            System.out.println("Which account do you want to withdraw from?");
            System.out.println("1.Checking");
            System.out.println("2.Savings");
            fromAcct = sc.nextInt();
            if(fromAcct < 1 || fromAcct > 2) {
                System.out.println("Invalid account. Please try again.");
            }
        }while(fromAcct < 1 || fromAcct > 2);
        
        if (fromAcct == 1)
        {
            
            checking_acctBal = currentUser.get_checking_balance(client);
            System.out.println(checking_acctBal);

                System.out.print("Enter the amount to withdraw: ");
                amount = sc.nextInt();
    
                if (amount < 0) {
                    System.out.println("Amount must be greater than zero");
                }
                else if (amount > checking_acctBal) {
                    System.out.printf("Amount must not be greater than\n" + "balance of $%.02f.\n", checking_acctBal);
                }
                else {
                    System.out.println("Withdraw from checking account");
                    currentUser.withdrawFunds(amount,checking,client);
                    App.userMenu(sc, currentUser);
                }
    
        }

        else {
            savings_acctBal = currentUser.get_savings_balance(client);
            System.out.println(savings_acctBal);

            
                System.out.print("Enter the amount to withdraw: ");
                amount = sc.nextInt();
    
                if (amount < 0) {
                    System.out.println("Amount must be greater than zero");
                }
                else if (amount > savings_acctBal) {
                    System.out.printf("Amount must not be greater than\n" + "balance of $%.02f.\n", savings_acctBal);
                }
                else {
                    System.out.printf("Withdraw from savings account");
                    currentUser.withdrawFunds(amount, savings,client);
                    App.userMenu(sc, currentUser);
                }
    
        }

    }

    public static void depositFunds(Scanner sc, User currentUser, int client) {

        int fromAcct;
        boolean valid = false;
        int checking_acctBal,savings_acctBal,amount;
        String checking = "checking_account_balance";
        String savings = "savings_account_balance";

        do {
            System.out.println("Which account do you want to deposit to?");
            System.out.println("1.Checking");
            System.out.println("2.Savings");
            fromAcct = sc.nextInt();
            if(fromAcct < 1 || fromAcct > 2) {
                System.out.println("Invalid account. Please try again.");
            }
        }while(fromAcct < 1 || fromAcct > 2);
        
        if (fromAcct == 1)
        {
            checking_acctBal = currentUser.get_checking_balance(client);
            System.out.println(checking_acctBal);
            System.out.print("Enter the amount to deposit: ");
            amount = sc.nextInt();
            System.out.printf("Deposit to account %s", checking);
            currentUser.depositFunds(amount, checking,client);
            App.userMenu(sc, currentUser);
        }

        else {
            savings_acctBal = currentUser.get_savings_balance(client);
            System.out.println(savings_acctBal);
            System.out.print("Enter the amount to Deposit: ");
            amount = sc.nextInt();
            System.out.printf("Deposit to account %s\n", savings);
            currentUser.depositFunds(amount, savings,client);
            App.userMenu(sc, currentUser);
        }

    }
}
