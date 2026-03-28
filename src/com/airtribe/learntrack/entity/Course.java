package com.airtribe.learntrack.entity;

//Fields: id, courseName, description, durationInWeeks, active

import com.airtribe.learntrack.enums.CourseStatus;

public class Course {
    //private instance variables
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;

    //Default constructor
    public Course(){}

    //Parameterised constructor
    public Course(int id, String courseName, String description, int durationInWeeks, CourseStatus status)
    {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.status = status;
    }

    //getters

    public int getId()
    {
        return id;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public String getDescription()
    {
        return description;
    }

    public int getDurationInWeeks()
    {
        return durationInWeeks;
    }

    public CourseStatus getStatus()
    {
        return status;
    }

    //Setters


    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setDurationInWeeks(int durationInWeeks)
    {
        this.durationInWeeks = durationInWeeks;
    }

    public void setStatus(CourseStatus status)
    {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Course: " + courseName +
                " | Description: " + description +
                " | Duration: " + durationInWeeks + " weeks" +
                " | Status: " + status;
    }


}

