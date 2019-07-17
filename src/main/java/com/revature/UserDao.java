package com.revature;
import java.util.List;

/**
 * UserDao
 */
public interface UserDao<E> 
{
    void insert();
    void view();
    void viewAccount(int c);
    void delete(String c);
    void createUser(E e);
    void get_username();
    int get_savings_balance(int c);
    int get_checking_balance(int c);
    void printSummary(int c);
    void showTransHistory(E e);
    int depositFunds(int e, String p, int c);
    int withdrawFunds(int e,String p, int c);
    void joinAccounts(int a, int b, int ca, int sa, int cb, int sb, String u, String p);
}
