package com.revature;
import java.util.ArrayList;

public class Register
{
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private String birthdate;
    private static int client = 0;


    public Register(String firstname, String lastname, String address, String city, String state, String birthdate)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Registered [firstname = " + firstname + " , lastname = " + lastname + " , address = " + address + " , city = " + city + " , state = " + state + " , birthdate = " + birthdate + "]";
    }
}