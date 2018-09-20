package chapter10.courseregisteration;

import java.util.ArrayList;

public class TestCourseRegisteration 
{
	public static void main(String[] args)
	{
//		Course courseObj = new Course();
//		CourseSection courseSectionObj = new CourseSection();
//		Instructor instructorObj = new Instructor();
//		Student studentObj = new Student();
		
		//1 course class w/ number and name
		Course course = new Course("1102", "Math");
		
		//2 course section class with CRN and number
		CourseSection courseSectionObj = new CourseSection(222, 322);
		CourseSection courseSectionObj2 = new CourseSection(123, 432);
		
		//ArrayList of Students

//		Student[] students = new Student();
		
		for(int i = 0; i < 11; i++) 
		{
	
			
		}
			//Creates and add 11 students to the ArrayList using a loop.
				//Name the students: Student Name 1,2,3....11
				//Student ID: 90001,90002,90003...90011. 
				//Major: static ITEC
		
		
		//2 Instructor: instructor1 and instructor1
			/*
			 * Adds the first 10 student from the ArrayList
			 * Adds the first course section to the 10 students and instructor
			 * Adds the 5th student and the 11th student and other instructor to the section section
			 * 
			 * 
			 * */

	}
}