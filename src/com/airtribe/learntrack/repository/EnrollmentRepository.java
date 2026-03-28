package com.airtribe.learntrack.repository;
import java.util.ArrayList;
import com.airtribe.learntrack.entity.Enrollment;


public class EnrollmentRepository {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment)
    {
        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getAll()
    {
        return enrollments;
    }

    public Enrollment findById(int id)
    {
        for(Enrollment e: enrollments)
        {
            if(e.getId() == id)
            {
                return e;
            }
        }

        return null;
    }

    public void removeById(int id)
    {
        for(Enrollment e: enrollments)
        {
            if(e.getId() == id)
            {
                enrollments.remove(e);
                break;
            }
        }
    }

    public ArrayList<Enrollment> findByStudentId(int id)
    {
        ArrayList<Enrollment> e2 = new ArrayList<>();
        for(Enrollment e: enrollments)
        {
            if(e.getStudentId() == id)
            {
                e2.add(e);
            }
        }

        return e2;
    }

}
