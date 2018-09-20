package chapter10.courseregisteration;

import java.sql.Date;
import java.util.ArrayList;

public class Student 
{
	//Declare student variables
	private int studentIDNUMBER;
	private String studentName;
	private String studentMajor;
	private Date admissionDate;
	private ArrayList<CourseSection> courseSectionsRegistered; //= new ArrayList<>(5);
	
	public static int MIN_NUMBER_OF_COURSES_REGISTERED = 1;
	public static int MAX_NUMBER_OF_COURSES_REGISTERED = 5;

	public Student() 
	{
		this.studentIDNUMBER = 0;
		this.studentName = "";
		this.studentMajor = "";
		this.courseSectionsRegistered = new ArrayList<>(MAX_NUMBER_OF_COURSES_REGISTERED);
	}
	
	public Student(int studentIDNUMBER, String studentName, String studentMajor) 
	{
		this.studentIDNUMBER = studentIDNUMBER;
		this.studentName = studentName;
		this.studentMajor = studentMajor;
		//this.studentAddmissionDate = new Date();
		this.courseSectionsRegistered = new ArrayList<>(MAX_NUMBER_OF_COURSES_REGISTERED);
	}
	
	public int getStudentIDNumber() 
	{
		return studentIDNUMBER;
	}
	
	public String getStudentName() 
	{
		return studentName;
	}
	
	public String getStudentMajor() 
	{
		//studentMajor = "ITEC";
		return studentMajor;
	}
	
	public ArrayList<CourseSection>  getCourseSectionsRegistered()
	{
		return this.courseSectionsRegistered;
	}
	
	public boolean addCourseSection(CourseSection courseSection) 
	{
		//If there is an empty sapce in the array, add something
			//If full, return: the array is full
		if(this.courseSectionsRegistered.size() < MAX_NUMBER_OF_COURSES_REGISTERED) 
		{
			return this.courseSectionsRegistered.add(courseSection);
		}
		else 
		{
			return false;
		}
	}
	
	public boolean removeCourseSection(CourseSection courseSection) 
	{
		//Trying to see if there is anything in the array
			//If there is, then remove it
				//Else return: there is nothing to remove
		if(this.courseSectionsRegistered.contains(courseSection)) 
		{
			return this.courseSectionsRegistered.remove(courseSection);
		}
		else
		{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Student [studentIDNUMBER=" + studentIDNUMBER + ", studentName=" + studentName + ", studentMajor="
				+ studentMajor + ", admissionDate=" + admissionDate + ", courseSectionsRegistered="
				+ courseSectionsRegistered + "]";
	}
	
	
	
	
	
}
