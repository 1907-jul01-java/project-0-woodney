package com.revature;
import java.util.List;

/**
 * Dao
 */
public interface Dao<E> 
{
    void insert(E e);
    void createUser(E e);
    void get_username();
    int get_savings_balance(int c);
    int get_checking_balance(int c);
    void printSummary(int c);
    void showTransHistory(E e);
    int depositFunds(int e, String p, int c);
    int withdrawFunds(int e,String p, int c);
    void joinAccounts(E e);
}
