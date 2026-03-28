package com.airtribe.learntrack.entity;

public class Student extends Person {

    //Private instance variables
    private int batch;
    private boolean active;

    //Default constructor
    public Student(){}

    //Parameterised constructor
    public Student(int id, String firstName, String lastName, String email, int batch, boolean active)
    {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    //Constructor overloading
    public Student(int id, String firstName, String lastName, int batch, boolean active)
    {
        super(id, firstName, lastName, "");
        this.batch = batch;
        this.active = active;
    }

    //Getters

    public int getBatch()
    {
        return batch;
    }

    public boolean isActive()
    {
        return active;
    }


    //Setters

    public void setBatch(int batch)
    {
        this.batch = batch;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                " | Name: " + getDisplayName() +
                " | Email: " + getEmail() +
                " | Batch: " + batch +
                " | Active: " + active;
    }


}
