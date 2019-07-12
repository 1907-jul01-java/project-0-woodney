package com.revature;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Register
{
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String address;
    private String city;
    private String state;
    private String birthdate;
    private byte pinHash[];
    private ArrayList<Account> accounts = new ArrayList<>();

    public Register(String firstname, String lastname, String username, String password, String address, String city, String state, String birthdate)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.birthdate = birthdate;

        //Store the password's MD5 hash
        try 
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e)
        {
            System.err.println("error, caught NoSuchAlgorithmExeption");
            e.printStackTrace();
            System.exit(1);
        }


    }

    

    @Override
    public String toString(){
        return "Registered [firstname = " + firstname + " , lastname = " + lastname + " , address = " + address + " , city = " + city + " , state = " + state + " , birthdate = " + birthdate + "]";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}