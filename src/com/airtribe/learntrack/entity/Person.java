package com.airtribe.learntrack.entity;

public class Person {

    //Private instance variables
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    //Default constructor
    public Person(){}

    //Parametrised constructor
    public Person(int id, String firstName, String lastName, String email)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //Getters
    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }


    //Get full name
    public String getDisplayName()
    {
        return firstName + " " + lastName;
    }


    //Setters
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


}
