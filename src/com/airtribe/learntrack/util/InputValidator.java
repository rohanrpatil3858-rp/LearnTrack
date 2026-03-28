package com.airtribe.learntrack.util;
import com.airtribe.learntrack.exception.InvalidInputException;

public class InputValidator {

    //Validations for Student and course
    public static boolean validateName(String name, String fieldName)
    {
        if(name == null)
        {
            throw new InvalidInputException("Exception:" + fieldName + " is NULL");
        }

        name = name.trim();

        if(name.length() == 0)
        {
            throw new InvalidInputException(fieldName + " cannot be empty");
        }

        return true;

    }


    public static boolean validateEmail(String email)
    {

        if(email == null)
        {
            throw new InvalidInputException("Exception: Email is NULL");
        }

        email = email.trim();

        if(email.length() == 0)
        {
            throw new InvalidInputException("Email cannot be empty");
        }

        if(email.contains("@") == false)
        {
            throw new InvalidInputException("Invalid Email ID");
        }

        if(email.contains(".") == false)
        {
            throw new InvalidInputException("Invalid Email ID");
        }

//        if(email.equalsIgnoreCase(email))
//        {
//            throw new InvalidInputException("Email ID already present in the database");
//        }

        return true;
    }

    public static boolean validateBatch(int batch, String fieldName)
    {
        if(batch <= 0 )
        {
            throw new InvalidInputException(fieldName + " cannot be negative or zero");
        }
        return true;
    }

}
