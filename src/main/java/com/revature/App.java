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

    
    public static void mainMenu(User currentUser) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Register> customers = new ArrayList<>();
        ArrayList<Register> employees = new ArrayList<>();
        employees.add(new Register("2713839","revature45"));

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
                client++;
                System.out.println();
                System.out.println();
                System.out.printf("New user %s, %s created. \n", f, l);
                System.out.printf("Your id: %s \n", client);
                System.out.printf("Your username: %s, Your password: %s. Store information in a secure place. \n", u, p);
                currentUser.createUser(new Register(f,l,u,p,a,c,s,d,client));
                customers.add(new Register(f,l,u,p,a,c,s,d,client));
            }
            

            else if (num == 2)
            {
                Register cur_User;
                boolean success = false;
                int acctChoice;
                do
                {
                    System.out.println("Please select one of the following: ");
                    System.out.println("1.Personal Account");
                    System.out.println("2.Joint Account");
                    acctChoice = sc.nextInt();
                    if(acctChoice == 1)
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
                    }
                    else if(acctChoice == 2){
                        u = sc.nextLine();
                        System.out.println("Enter username: ");
                        u = sc.nextLine();
                        System.out.println("Enter password: ");
                        p = sc.nextLine();
                        //System.out.println(customers.get(0).getUsername());
                        currentUser.checkjointaccount(u,p);
                    
                }
                }while(success == false);

                while(true) {
                    App.userMenu(sc, currentUser);  
                }
        
            }

            else if(num == 3) {
                boolean success = false;
                do {
                    u = sc.nextLine();
                    System.out.println("Enter username: ");
                    u = sc.nextLine();
                    System.out.println("Enter password: ");
                    p = sc.nextLine();

                    for (Register e : employees){
                        if (e.getUsername().compareTo(u) == 0 && e.getPassword().compareTo(p) == 0) {
                                System.out.println("Login Successful!");
                                success = true;
                        }
                }
            }while(success == false);
            while(true) {
                App.userMenu(sc,currentUser);  
            }
            }

    
            else if (num < 1 || num > 4)
            {
                System.err.println("Error, Invalid Entry");
            }

            else if (num == 4){
                System.exit(1);
            }

        }while(num != 4);

    }

    
    public static void userMenu(Scanner sc, User currentUser) { 
        currentUser.printSummary(client);
        int choice;

        do {
            System.out.printf("Welcome, what would you like to do?\n");
            System.out.println("  1) Withdraw");
            System.out.println("  2) Deposit");
            System.out.println("  3) Transfer");
            System.out.println("  4) Create joint account");
            System.out.println("  5) Employee?");
            System.out.println("  6) Logout");
            choice = sc.nextInt();

            if (choice < 1 || choice > 6)
            {
                System.out.println("Invalid choice. Please choose 1-5");
            }
        }while(choice < 1 || choice > 6);

        switch (choice) {

            
            case 1: 
                App.withdrawFunds(sc,currentUser,client);
                break;
            case 2:
                App.depositFunds(sc,currentUser,client);
                break;
            case 3:
                App.transferFunds(sc,currentUser,client);
                break;
            case 4:
                App.createJointAccount(sc,currentUser);
                break;
            case 5:
                App.employeeMenu(sc,currentUser);
            case 6:
                App.mainMenu(currentUser);
        }

        if (choice !=5){
            App.userMenu(sc, currentUser);
        }

        App.mainMenu(currentUser);
    }

    public static void employeeMenu(Scanner sc, User currentUser) {
        int choice;
        do{
        System.out.printf("Welcome, what would you like to do?\n");
            System.out.println("  1) View Client Information");
            System.out.println("  2) Delete");
            System.out.println("  3) View Client Accounts");
            System.out.println("  4) Logout");
            choice = sc.nextInt();
        
            if (choice < 1 || choice > 4)
            {
                System.out.println("Invalid choice. Please choose 1-5");
            }
        }while(choice < 1 || choice > 4);

        switch (choice) {

            
            case 1: 
                App.viewClients(sc,currentUser);
                App.employeeMenu(sc, currentUser);
                break;
            case 2:
                App.deleteClients(sc,currentUser);
                App.employeeMenu(sc, currentUser);
                break;
            case 3:
                App.viewClientAccounts(sc,currentUser);
                App.employeeMenu(sc, currentUser);
                break;
            case 4:
                App.mainMenu(currentUser);
                App.employeeMenu(sc, currentUser);
        }

        if (choice !=4){
            App.userMenu(sc, currentUser);
        }

        App.mainMenu(currentUser);

    }

    public static void viewClients(Scanner sc, User currentUser){
        currentUser.view();
    }
    public static void viewClientAccounts(Scanner sc, User currentUser) {
        int client_id;
        System.out.println("Enter id of the client's account you want to review");
        client_id = sc.nextInt();
        currentUser.viewAccount(client_id);
    }

    public static void deleteClients(Scanner sc, User currentUser){
        String client_id = "";
        System.out.println("Enter username of the client you want to remove");
        sc.nextLine();
        client_id = sc.nextLine();
        currentUser.delete(client_id);
    }

    public static void createJointAccount(Scanner sc, User currentUser){
        int account_a = client;
        int account_b;
        int check_a,check_b,savings_a,savings_b;
        String username,password;
        System.out.println("Type in the client id number to join accounts with");
        account_b = sc.nextInt();
        System.out.println();
        f = sc.nextLine();
        System.out.println("Please enter the first name of one of the account owners: ");
        f = sc.nextLine();
        System.out.println("Please enter the first name of the other account owner: ");
        l = sc.nextLine();
        System.out.println("Create your username: ");
        u = sc.nextLine();
        System.out.println("Create your password: ");
        p = sc.nextLine();
        check_a = currentUser.get_checking_balance(account_a);
        savings_a = currentUser.get_savings_balance(account_a);
        check_b = currentUser.get_checking_balance(account_b);
        savings_b = currentUser.get_savings_balance(account_b);
        currentUser.joinAccounts(account_a,account_b,check_a,savings_a,check_b,savings_b,u,p);
        client++;
        System.out.printf("New user created.");
        System.out.printf("Your id: %s \n", client);
        System.out.printf("Your username: %s, Your password: %s. Store information in a secure place. \n", u, p);
        App.mainMenu(currentUser);
    }

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
                    System.out.printf("Amount must not be greater than $" + checking_acctBal);
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
                    System.out.printf("Amount must not be greater than $" + savings_acctBal);
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
                    App.withdrawFunds(sc, currentUser, client);
                }
                else if (amount > checking_acctBal) {
                    System.out.println("Amount must not be greater than $" + checking_acctBal);
                    App.withdrawFunds(sc, currentUser, client);
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
                    App.withdrawFunds(sc, currentUser, client);
                }
                else if (amount > savings_acctBal) {
                    System.out.println("Amount must not be greater than $" + savings_acctBal);
                    App.withdrawFunds(sc, currentUser, client);
                }
                else {
                    System.out.println("Withdraw from savings account");
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
            System.out.println("Deposit to checking account");
            currentUser.depositFunds(amount, checking,client);
            App.userMenu(sc, currentUser);
        }

        else {
            savings_acctBal = currentUser.get_savings_balance(client);
            System.out.println(savings_acctBal);
            System.out.print("Enter the amount to Deposit: ");
            amount = sc.nextInt();
            System.out.println("Deposit to savings account");
            currentUser.depositFunds(amount, savings,client);
            App.userMenu(sc, currentUser);
        }

    }
}
