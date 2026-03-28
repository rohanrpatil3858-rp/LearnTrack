package com.airtribe.learntrack.util;


public class IdGenerator {
    private static int studentIdCounter = 0;
    private static int courseIdCounter = 0;
    private static int enrollmentIdCounter = 0;

    //getters

    public static int getNextStudent()
    {
        studentIdCounter += 1;
        return studentIdCounter;
    }

    public static int getNextCourse()
    {
        courseIdCounter += 1;
        return courseIdCounter;
    }

    public static int getNextEnrollment()
    {
        enrollmentIdCounter += 1;
        return enrollmentIdCounter;
    }


}
