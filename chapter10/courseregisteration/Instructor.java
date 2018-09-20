package chapter10.courseregisteration;

import java.sql.Date;
import java.util.ArrayList;

public class Instructor 
{
	//Declare variables
	private int instructorIDNumber;
	private String instructorName;
	private String instructorDepartment;
	private Date hiredDate;
	private ArrayList<CourseSection> courseSectionsTaught;
	
	public static final int MIN_NUMBER_OF_COURSES_TAUGHT = 1;
	public static final int MAX_NUMBER_OF_COURSES_TAUGHT = 4;

	public Instructor() 
	{
		this.instructorIDNumber = 0;
		this.instructorName = "";
		this.instructorDepartment = "";
		this.courseSectionsTaught = new ArrayList<>(MAX_NUMBER_OF_COURSES_TAUGHT);
	}
	
	public Instructor(int instructorIDNumber, String instructorName, String instructorDepartment) 
	{
		this.instructorIDNumber = instructorIDNumber;
		this.instructorName = instructorName;
		this.instructorDepartment = instructorDepartment;
		this.courseSectionsTaught = new ArrayList<>(MAX_NUMBER_OF_COURSES_TAUGHT);
	}
	
	public ArrayList<CourseSection> getCourseSectionsTaught()
	{
		return courseSectionsTaught;
	}


	
	public boolean addCourseSection(CourseSection courseSection) 
	{
		
		if(this.courseSectionsTaught.size() < MAX_NUMBER_OF_COURSES_TAUGHT) 
		{
			
			return this.courseSectionsTaught.add(courseSection);
		}
		else 
		{
			return false;
		}
	}
	
	public boolean removeCourseSection(CourseSection courseSection) 
	{
		if(this.courseSectionsTaught.contains(courseSection)) 
		{
			return this.courseSectionsTaught.remove(courseSection);
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
	public String toString() {
		return "Instructor [instructorIDNumber=" + instructorIDNumber + ", instructorName=" + instructorName
				+ ", instructorDepartment=" + instructorDepartment + ", hiredDate=" + hiredDate
				+ ", courseSectionsTaught=" + courseSectionsTaught + "]";
	}
	
	
}