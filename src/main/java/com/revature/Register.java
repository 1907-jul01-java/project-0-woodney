package com.revature;


public class Register
{
    private String firstname;
    private String lastname;
    private String address;
    private String birthdate;
    private static int client = 0;

    public Register(String firstname, String lastname, String address, String birthdate)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.birthdate = birthdate;
        client++;
    }

    @Override
    public String toString() {
        return "Registered [address= " + address + " , birthdate= " + birthdate + " , firstname= " + firstname
                + " , lastname= " + lastname + "]";
    }
}