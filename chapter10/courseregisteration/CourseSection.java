package chapter10.courseregisteration;

import java.util.ArrayList;

public class CourseSection
{
	//Declare encapsulated variables
	private int cRN;
	private int courseSectionNumber;
	private ArrayList<Instructor> instructors; 		// = new ArrayList<>(3);
	private ArrayList<Student> students; 			// = new ArrayList<>(30);
	
	//Instructors restrictions
	public static final int MIN_NUMBER_OF_INSTRUCTORS = 1;
	public static final int MAX_NUMBER_OF_INSTRUCTORS = 3;
	
	//Students restrictions
	public static final int MIN_NUMBER_OF_STUDENTS = 8;
	public static final int MAX_NUMBER_OF_STUDENTS = 30;
	
	
	public CourseSection() 
	{
		this.cRN = 0;
		this.courseSectionNumber = 0;
		instructors = new ArrayList<>(MAX_NUMBER_OF_INSTRUCTORS);
		students = new ArrayList<>(MAX_NUMBER_OF_STUDENTS);
	}
	public CourseSection(int cRN, int courseSectionNumber) 
	{
		this.cRN = cRN;
		this.courseSectionNumber = courseSectionNumber;
		this.instructors = new ArrayList<>(MAX_NUMBER_OF_INSTRUCTORS);
		this.students = new ArrayList<>(MAX_NUMBER_OF_STUDENTS);
	}
	
	//Methods
	public int getCRN()
	{
		return cRN;
	}
	
	public int getCourseSectionNumber() 
	{
		return courseSectionNumber;
	}
	
	/**
	 * @return the instructors
	 */
	public ArrayList<Instructor> getInstructors() 
	{
		return this.instructors;
	}
	/**
	 * @return the students
	 */
	public ArrayList<Student> getStudents() 
	{
		return this.students;
	}
	
	public boolean addInstructor(Instructor instructor)
	{
		if(this.instructors.size() < MAX_NUMBER_OF_INSTRUCTORS) 
		{
			return instructors.add(instructor);
		}
		return false;
	}
	
	public boolean dropInstructor(Instructor instructor) 
	{
		if(this.instructors.contains(instructor) ) 
		{
			return instructors.remove(instructor);
		}
		return false;
	}
	
	public boolean addStudent(Student student)
	{
		if(this.students.size() < MAX_NUMBER_OF_STUDENTS)
		{
			return true;
		}
		return false;
	}
	
	public boolean dropStudent(Student student)
	{
		if(this.students.contains(student))
		{
			return students.remove(student);
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "CourseSection [cRN=" + cRN + ", courseSectionNumber=" + courseSectionNumber + ", instructors="
				+ instructors + ", students=" + students + "]";
	}
	
//	public String toString() {
//		return "The Course registeration number is "  + cRN + 
//				"The course section number is " + courseSectionNumber +
//				"The course Instructor is " + instructors + 
//				"The course Student is " + students;
//	}
	
	
	
}