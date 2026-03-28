package com.airtribe.learntrack.service;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;
import java.util.ArrayList;


public class CourseService {
    private CourseRepository courseRepo = new CourseRepository();

    //AddCourse

    public void addCourse(String courseName, String description, int durationInWeeks)
    {
        //Validate
        InputValidator.validateName(courseName, "Course name");                 //validate course name
        InputValidator.validateName(description, "Description");
        InputValidator.validateBatch(durationInWeeks, "Duration in weeks");     //validate duration in weeks

        int courseId = IdGenerator.getNextCourse();
        Course course = new Course(courseId, courseName, description, durationInWeeks, CourseStatus.ACTIVE);
        courseRepo.addCourse(course);


        System.out.println("Course added successfully!!!");

    }

    public ArrayList<Course> viewAllCourses()
    {
        return courseRepo.getAll();
    }


    //Search course by ID

    public Course searchCourseById(int id)
    {
        Course course = courseRepo.findById(id);

        if(course == null)
            throw new EntityNotFoundException("Course not found");
        return course;
    }

    public void deactivateCourse(int id)
    {
        Course c = searchCourseById(id);
        c.setStatus(CourseStatus.INACTIVE);
        System.out.println("Course deactivated successfully!!!");
    }

    public void activateCourse(int id)
    {
        Course c = searchCourseById(id);
        c.setStatus(CourseStatus.ACTIVE);
        System.out.println("Course activated successfully!!!");
    }
}
