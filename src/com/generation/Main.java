package com.generation;

import com.generation.classes.Student;
import com.generation.exceptions.CourseNotFoundException;
import com.generation.exceptions.StudentNotFoundException;
import com.generation.services.StudentService;

public class Main {

    public static void main(String[] args) {
	    StudentService studentService = new StudentService();
	    //TODO refactor this code to use encapsulation inside studentsService
	    studentService.addStudent(new Student("Carlos", "1030", 31));
	    studentService.addStudent(new Student( "Ian", "1020", 28 ) );
	    studentService.addStudent(new Student( "Elise", "1020", 26 ) );
	    studentService.addStudent(new Student( "Santiago", "1020", 33 ));

//        studentService.students.put( "1030", new Student( "Carlos", "1030", 31 ) );
//        studentService.students.put( "1040", new Student( "Ian", "1020", 28 ) );
//        studentService.students.put( "1050", new Student( "Elise", "1020", 26 ) );
//        studentService.students.put( "1020", new Student( "Santiago", "1020", 33 ) );

        try {
			studentService.enrollStudents( "Math", "1030" );
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			studentService.enrollStudents( "History", "1030" );
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        studentService.showAllCourses();
        studentService.showEnrolledStudents("Math");
        studentService.showEnrolledStudents("History");
    }
    
}