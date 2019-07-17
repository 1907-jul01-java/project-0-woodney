package com.revature;
import java.util.List;

/**
 * EmployeeDao
 */

 public interface EmployeeDao<E> {

    void insert();
    void view();
    void delete();
    void depositFunds(int a, int c, String f);
    void withdrawFunds(int a, int c, String f);

 }