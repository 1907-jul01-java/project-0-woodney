package com.revature;
import java.util.List;

/**
 * UserDao
 */
public interface UserDao<E> 
{
    void view();
    void viewAccount(int c);
    void deleteAccount(String c,int a);
    void createUser(E e);
    void get_username();
    boolean checkadminaccount(String u, String p);
    boolean checkjointaccount(String u, String p);
    int get_savings_balance(int c);
    int get_checking_balance(int c);
    void printSummary(int c);
    void showTransHistory(E e);
    int depositFunds(int e, String p, int c);
    int withdrawFunds(int e,String p, int c);
    void joinAccounts(int a, int b, int ca, int sa, int cb, int sb, String u, String p);
}
