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
    private int client_id;
    private byte pinHash[];
    private ArrayList<Register> customers = new ArrayList<>();
    

    
    public Register(){

    }
    
    public Register(String firstname, String lastname, String username, String password, String address, String city, String state, String birthdate, int client_id)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.birthdate = birthdate;
        this.client_id = client_id;
    }




    public Register customerLogin(String username, String password) {

        for (Register r : this.customers) {
           if (r.getUsername().compareTo(username) == 0 && r.getPassword().compareTo(password) == 0) {
              return r;
           }
        }
     
        return null;
     }

     public Register(String username, String password) {

        this.username = username;
        this.password = password;
     }


    public Register(String firstname, String lastname, String username, String password, int client_id)
    {
        this.username = username;
        this.password = password;

        System.out.printf("New user %s, %s with ID %s created. \n", firstname, lastname, client_id);
        System.out.printf("Your username: %s, Your password: %s. Store information in a secure place. \n", username, password);
    }


    @Override
    public String toString(){
        return "Registered [firstname = " + firstname + " , lastname = " + lastname + " , address = " + address + " , city = " + city + " , state = " + state + " , birthdate = " + birthdate + "]";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    
}