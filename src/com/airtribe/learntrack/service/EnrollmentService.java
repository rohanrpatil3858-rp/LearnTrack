package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.InputValidator;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import java.util.ArrayList;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.CourseService;


public class EnrollmentService {
    private EnrollmentRepository enrollmentrepo = new EnrollmentRepository();
    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();

    //Constructor
    public EnrollmentService(StudentService studentService,
                             CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }


    //Enroll new Student

    public void enrollStudent(int studentId, int courseId)
    {
        //Validations

        InputValidator.validateBatch(studentId,"Student ID");
        InputValidator.validateBatch(courseId,"Course ID");

        //validate if student is present in database or not
        Student student = studentService.searchStudentById(studentId);

        //validate if student is active or not
        if(student.isActive() == false)
        {
            throw new EntityNotFoundException("Student is inactive");
        }

        //validate if course is present in database or not
        Course course = courseService.searchCourseById(courseId);

        //validate if course is active or not
        CourseStatus status = course.getStatus();
        if(status == CourseStatus.INACTIVE)
        {
            throw new EntityNotFoundException("Course is inactive");

        }

        int enrollmentId = IdGenerator.getNextEnrollment();             //generate enrollment ID
        String enrollmentDate = java.time.LocalDate.now().toString();   //get today's date

        Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseId, enrollmentDate, EnrollmentStatus.ACTIVE);
        enrollmentrepo.addEnrollment(enrollment);
        System.out.println("Enrollment added successfully");
    }

    //View Enrollments
    public ArrayList<Enrollment> viewEnrollments(int id)
    {
        return enrollmentrepo.findByStudentId(id);
    }

    //Mark complete
    public void markComplete(int id)
    {
        Enrollment enrollment = enrollmentrepo.findById(id);
        if(enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found");
        }

        if(enrollment.getStatus() == EnrollmentStatus.COMPLETED)
        {
            throw new EntityNotFoundException("Enrollment is already completed");
        }

        enrollment.setStatus(EnrollmentStatus.COMPLETED);
        System.out.println("Enrollment Completed successfully");
    }

    //Mark cancelled
    public void markCancelled(int id)
    {
        Enrollment enrollment = enrollmentrepo.findById(id);

        if(enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found");
        }

        if(enrollment.getStatus() == EnrollmentStatus.CANCELLED)
        {
            throw new EntityNotFoundException("Enrollment is already cancelled");
        }



        enrollment.setStatus(EnrollmentStatus.CANCELLED);
        System.out.println("Enrollment CANCELLED successfully");
    }

}
