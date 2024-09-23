package com.generation.services;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.generation.classes.Course;
import com.generation.classes.Student;
import com.generation.exceptions.CourseNotFoundException;
import com.generation.exceptions.StudentNotFoundException;

public class StudentService
{
   private HashMap<String, Course> courseList = new HashMap<>();

   private HashMap<String, Student> students = new HashMap<>();

   private HashMap<String, List<Course>> coursesEnrolledByStudents = new HashMap<>();


    public StudentService(){
        courseList.put( "Math", new Course( "Math", 10, "Aurelio Baldor" ) );
        courseList.put( "Physics", new Course( "Physics", 10, "Albert Einstein" ) );
        courseList.put( "Art", new Course( "Art", 10, "Pablo Picasso" ) );
        courseList.put( "History", new Course( "History", 10, "Sima Qian" ) );
        courseList.put( "Biology", new Course( "Biology", 10, "Charles Darwin" ) );
    }

    public void enrollStudents( String courseName, String studentID ) throws StudentNotFoundException, CourseNotFoundException {
    	
        if(! courseList.containsKey(courseName)){
        	throw new CourseNotFoundException(courseName);
        }// if
        if(! students.containsKey(studentID)) {
        	throw new StudentNotFoundException(studentID);
        }
        Course course = courseList.get( courseName );
        
        if ( !coursesEnrolledByStudents.containsKey( studentID ) ){
            coursesEnrolledByStudents.put( studentID, new ArrayList<>() );
        }
        coursesEnrolledByStudents.get( studentID ).add( course );
    }

    public void unEnrollStudents( String courseName, String studentID ) throws CourseNotFoundException, StudentNotFoundException{
    	
    	if (!courseList.containsKey(courseName)) {
    		
    		throw new CourseNotFoundException(courseName);
			
		}
    	if (!students.containsKey(studentID)) {
			throw new StudentNotFoundException(studentID);
    		
		}
        Course course = courseList.get( courseName );

        if ( coursesEnrolledByStudents.containsKey( studentID ) )
        {
            coursesEnrolledByStudents.get( studentID ).remove( course );
        }
    }

    public void showEnrolledStudents(String courseId){
        //TODO implement using collections loops
    	Course course = courseList.get(courseId);
    	System.out.println(course);
    	for (String studentid: coursesEnrolledByStudents.keySet() ) {
			List<Course> allcoruses = coursesEnrolledByStudents.get(studentid);
			if(allcoruses.contains(course)) {
				Student student = students.get(studentid);
				System.out.println(student);
			}//
		}//foreach
    
    }//showenrool

    public void showAllCourses(){
        //TODO implement using collections loops
    	for (Course course : courseList.values()) {
			course.toString();
		}
    
    }

	public  void addStudent(Student student) {
		// TODO Auto-generated method stub
		students.put(student.getId(), student);
	}
}