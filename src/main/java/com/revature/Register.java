package com.revature;


public class Register
{
    public String firstname;
    public String lastname;
    public String address;
    public String birthdate;

    public Register(String firstname, String lastname, String address, String birthdate)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Registered [address= " + address + " , birthdate= " + birthdate + " , firstname= " + firstname
                + " , lastname= " + lastname + "]";
    }
}