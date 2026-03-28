package com.airtribe.learntrack.repository;
import com.airtribe.learntrack.entity.Student;


import java.util.ArrayList;

public class StudentRepository {

    //Create array list of student objects
    private ArrayList<Student> students = new ArrayList<>();

    //Add student
    public Student addStudent(Student student)
    {
        students.add(student);
        return student;
    }

    public ArrayList<Student> getAll()
    {
        return students;
    }

    public Student findById(int id)
    {
        for(Student s : students)
        {
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public void removeById(int id)
    {
        for(Student s: students)
        {
            if(s.getId() == id)
            {
                students.remove(s);
                break;
            }
        }
    }
}
