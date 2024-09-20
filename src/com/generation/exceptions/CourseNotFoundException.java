package com.generation.exceptions;

public class CourseNotFoundException extends Exception
{

    public CourseNotFoundException()
    {
        super("course not found!!");
    }
}