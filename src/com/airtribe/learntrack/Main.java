package com.airtribe.learntrack;
import java.util.ArrayList;
import java.util.Scanner;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.constants.AppConstants;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

public class Main {

    public static void main(String[] args)
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

        while(true)
        {
            System.out.println("\n==== Welcome to Learn Track ===\n");
            System.out.println("1.Student Management");
            System.out.println("2.Course Management");
            System.out.println("3.Enrollment Management");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();


            if(choice == 4)
                break;
            else if(choice < 1 || choice > 4)
                System.out.println("Enter valid choice");

            //Student management
            if(choice == MenuOptions.MANAGE_STUDENTS)
            {
                while(true)
                {
                    System.out.println("\n==== Student management ===\n");
                    System.out.println("1.Add student");
                    System.out.println("2.View all students");
                    System.out.println("3.Search student by ID");
                    System.out.println("4.Activate student");
                    System.out.println("5.Deactivate student");
                    System.out.println("6.Back");
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();

                    if(choice == 6)
                    {
                        choice = 0;
                        break;
                    }
                    else if(choice < 1 || choice > 6)
                        System.out.println("Enter valid choice");

                    //logic
                    if(choice == MenuOptions.ADD_STUDENT)
                    {

                        try
                        {
                            System.out.println("Enter Student's First Name: ");
                            String firstName = sc.next();
                            System.out.println("Enter Student's Last Name: ");
                            String lastName = sc.next();
                            System.out.println("Enter Student's Email ID: ");
                            String email = sc.next();
                            System.out.println("Enter Student's Batch no: ");
                            int batch = sc.nextInt();
                            studentService.addStudent(firstName, lastName, email, batch);
                        } catch (InvalidInputException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    else if(choice == MenuOptions.VIEW_STUDENTS)
                    {
                        ArrayList<Student> students =  studentService.viewAllStudents();

                        if(students.isEmpty()) {
                            System.out.println("No students found!");
                        } else {
                            for(Student s: students) {
                                System.out.println(s);
                            }
                        }

                    }
                    else if(choice == MenuOptions.SEARCH_STUDENT_BY_ID)
                    {

                        try {
                            System.out.println("Enter ID of the student: ");
                            int id = sc.nextInt();
                            Student s = studentService.searchStudentById(id);
                            System.out.println(s);
                        }
                        catch(EntityNotFoundException e)
                        {
                            System.out.println("Error: " + e.getMessage());
                        }

                    }
                    else if (choice == MenuOptions.ACTIVATE_STUDENT) {
                        try
                        {
                            System.out.println("Enter ID of the student that you want to activate: ");
                            int id = sc.nextInt();
                            studentService.activateStudent(id);
                        }
                        catch(EntityNotFoundException e)
                        {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    else if (choice == MenuOptions.DEACTIVATE_STUDENT)
                    {
                        try
                        {
                            System.out.println("Enter ID of the student that you want want to de-activate: ");
                            int id = sc.nextInt();
                            studentService.deactivateStudent(id);

                        }
                        catch(EntityNotFoundException e)
                        {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                }
            }

            //Course management
            if(choice == MenuOptions.MANAGE_COURSES)
            {
                while(true)
                {
                    System.out.println("\n==== Course management ===\n");
                    System.out.println("1.Add course");
                    System.out.println("2.View all courses");
                    System.out.println("3.Activate course");
                    System.out.println("4.Deactivate course");
                    System.out.println("5.Back");
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();

                    if(choice == 5)
                    {
                        choice = 0;
                        break;
                    }
                    else if(choice < 1 || choice > 5)
                        System.out.println("Enter valid choice");

                    //logic
                    if(choice == MenuOptions.ADD_COURSE)
                    {
                        try {
                            System.out.println("Enter Course Name: ");
                            sc.nextLine();
                            String courseName = sc.nextLine();
                            System.out.println("Enter Description: ");
                            String description = sc.nextLine();
                            System.out.println("Enter Duration in weeks: ");
                            int durationInWeeks = sc.nextInt();
                            courseService.addCourse(courseName, description, durationInWeeks);
                        }
                        catch(InvalidInputException e)
                        {
                            System.out.println("Error : " + e.getMessage());
                        }
                    }
                    else if(choice == MenuOptions.VIEW_ALL_COURSES)
                    {
                        ArrayList<Course> courses =  courseService.viewAllCourses();
                        if(courses.isEmpty()) {
                            System.out.println("No courses found!");
                        } else {
                            for(Course c: courses) {
                                System.out.println(c);
                            }
                        }

                    }
                    else if (choice == MenuOptions.ACTIVATE_COURSE)
                    {
                        try
                        {
                            System.out.println("Enter ID of the course that you want to activate: ");
                            int id = sc.nextInt();
                            courseService.activateCourse(id);
                        }
                        catch(EntityNotFoundException e)
                        {
                            System.out.println("Error " + e.getMessage());
                        }
                    }
                    else if (choice == MenuOptions.DEACTIVATE_COURSE) {

                        try
                        {
                            System.out.println("Enter ID of the course that you want to de-activate: ");
                            int id = sc.nextInt();
                            courseService.deactivateCourse(id);
                        }
                        catch(EntityNotFoundException e)
                        {
                            System.out.println("Error " + e.getMessage());
                        }
                    }
                }
            }

            //Enrollment management
            if(choice == MenuOptions.MANAGE_ENROLLMENTS)
            {
                while(true)
                {
                    System.out.println("\n==== Enrollment management ===\n");
                    System.out.println("1.Enroll student in course");
                    System.out.println("2.View enrollments by student");
                    System.out.println("3.Mark enrollment complete");
                    System.out.println("4.Mark enrollment cancelled");
                    System.out.println("5.Back");
                    System.out.println("Enter your choice: ");
                    choice = sc.nextInt();

                    if(choice == 5)
                        break;
                    else if(choice < 1 || choice > 5)
                        System.out.println("Enter valid choice");

                    //logic

                    if(choice == MenuOptions.ENROLL_STUDENT)
                    {
                        try
                        {
                            System.out.println("Enter Student ID: ");
                            int studentId = sc.nextInt();
                            System.out.println("Enter Course ID: ");
                            int courseId = sc.nextInt();
                            enrollmentService.enrollStudent(studentId, courseId);
                        }
                        catch (InvalidInputException | EntityNotFoundException e)
                        {
                            System.out.println("Error : " + e.getMessage());
                        }
                    }
                    else if(choice == MenuOptions.VIEW_ENROLLMENTS)
                    {
                        System.out.println("Enter Student ID: ");
                        int studentId = sc.nextInt();
                        ArrayList<Enrollment> enrollments =  enrollmentService.viewEnrollments(studentId);
                        if(enrollments.isEmpty()) {
                            System.out.println("No enrollments found!");
                        } else {
                            for(Enrollment e: enrollments) {
                                System.out.println(e);
                            }
                        }
                    }
                    else if (choice == MenuOptions.MARK_COMPLETE)
                    {
                        System.out.println("Enter Enrollment ID");

                        try {
                            int id = sc.nextInt();
                            enrollmentService.markComplete(id);
                        }
                        catch (EntityNotFoundException e)
                        {
                            System.out.println("Error : " + e.getMessage());
                        }
                    }
                    else if (choice == MenuOptions.MARK_CANCELLED) {
                        System.out.println("Enter Enrollment ID");

                        try {
                            int id = sc.nextInt();
                            enrollmentService.markCancelled(id);
                        }
                        catch (EntityNotFoundException e)
                        {
                            System.out.println("Error : " + e.getMessage());
                        }
                    }
                }
            }

        }

        System.out.println(AppConstants.EXIT_MESSAGE);

    }
}
