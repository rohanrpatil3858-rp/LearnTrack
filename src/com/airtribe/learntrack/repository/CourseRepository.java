package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;

public class CourseRepository {

    //Array list for course objects
    private ArrayList<Course> courses = new ArrayList<>();

    //Method for add course
    public void addCourse(Course course)
    {
        courses.add(course);
    }

    //Method for getting the array list
    public ArrayList<Course> getAll()
    {
        return courses;
    }

    //method to find the course by id
    public Course findById(int id)
    {
        for(Course c: courses)
        {
            if(c.getId() == id)
            {
                return c;
            }
        }

        return null;
    }

    //Method to remove course object from array list
    public void removeById(int id)
    {
        for(Course c: courses)
        {
            if(c.getId() == id)
            {
                courses.remove(c);
                break;
            }
        }
    }
}
