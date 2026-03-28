package com.airtribe.learntrack.service;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.InputValidator;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.ArrayList;

public class StudentService {

    private StudentRepository studentRepo = new StudentRepository();


    //Add student
    public void addStudent(String firstName, String lastName, String email, int batch) {
        //Validate name
        InputValidator.validateName(firstName, "First name");
        InputValidator.validateName(lastName, "Last name");
        InputValidator.validateBatch(batch, "Batch");

        //Validate Email
        InputValidator.validateEmail(email);

        //generate ID
        int studentId = IdGenerator.getNextStudent();


        //create student object
        Student s = new Student(studentId, firstName, lastName, email, batch, true);

        //add student to the arraylist
        studentRepo.addStudent(s);
        System.out.println("Student added successfully!!!");
    }

    //Get list of all the students
    public ArrayList<Student> viewAllStudents() {
        return studentRepo.getAll();
    }

    //Search student by ID

    public Student searchStudentById(int id) {
        Student s = studentRepo.findById(id);

        if (s == null)
            throw new EntityNotFoundException("Student not found");
        return s;
    }

    //Method to deactivate a student
    public void deactivateStudent(int id) {
        Student s = searchStudentById(id);
        s.setActive(false);
        System.out.println("Student deactivated successfully!!!");
    }

    //Method to activate a studentq
    public void activateStudent(int id) {
        Student s = searchStudentById(id);
        s.setActive(true);
        System.out.println("Student activated successfully!!!");
    }
}
