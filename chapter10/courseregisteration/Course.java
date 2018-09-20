package chapter10.courseregisteration;

//import
import java.lang.String;
import java.util.ArrayList;

public class Course 
{
	//Encapsulation: declare variables
	private String courseNumber;
	private String courseName;
	private int numberOfCourses;
	private ArrayList<CourseSection> courseSections;   // = new ArrayList<CourseSection>(15);
	
	//Public constant declaration
	public static final int MIN_NUMBER_OF_SECTIONS = 1;
	public static final int MAX_NUMBER_OF_SECTIONS = 15;
	
	//Default Constructor
	public Course()
	{
		this.courseNumber = "";
		this.courseName = "";
		this.numberOfCourses = 0;
		this.courseSections = new ArrayList<>(MAX_NUMBER_OF_SECTIONS);
	}
	
	//Constructor w/ parameters
	public Course(String  courseNumber, String courseName) 
	{
		this.courseNumber = courseNumber;
		this.courseName = courseName;
//		this.numberOfCourses = numberOfCourses;
		this.courseSections = new ArrayList<>(MAX_NUMBER_OF_SECTIONS);
	}
	
	//Getters
	public String  getCourseNumber() 
	{
		return courseNumber;
	}
	
	public String getCourseName() 
	{
		return courseName;
	}
	
	public int getNumberOfCourses() 
	{
		return numberOfCourses;
	}
	
	public ArrayList<CourseSection> getCourseSections() 
	{
		return courseSections;
	}
	
	//Add Course Section using CourseSection object
	public boolean addCourseSection(CourseSection courseSection) 
	{
			//If there is an empty space, add
				//If full, say it's full
		if(courseSections.size() < MAX_NUMBER_OF_SECTIONS) 
		{
			return courseSections.add(courseSection);
		}
		return false;
	}
	
	public boolean removeCourseSection(CourseSection courseSection) 
	{
		//If there is a course, remove it
			//If there is no course then 
				//return: there is no course to be removed
		if(courseSections.contains(courseSection)) 
		{
			return this.courseSections.remove(courseSection);
		}
		return false;
	}
	
	public void purgeCourseSections()
	{
		ArrayList<CourseSection> purgeCourseSections = new ArrayList<>();

		for(CourseSection courseSection: courseSections)
		{
			if(courseSection.getStudents().size() < Student.MIN_NUMBER_OF_COURSES_REGISTERED){
				purgeCourseSections.add(courseSection);

				ArrayList<Instructor> instructors = courseSection.getInstructors();
				ArrayList<Student> students = courseSection.getStudents();

				for(Instructor instructor: instructors) {
					ArrayList<CourseSection> courseSectionTaught = instructor.getCourseSectionsTaught();
					purgeCourseSections.remove(courseSection);
				}

				for(Student student: students) {
					ArrayList<CourseSection> courseSectionsRegistered = student.getCourseSectionsRegistered();
					purgeCourseSections.remove(courseSection);
				}
			}

			for(CourseSection courseSection1: purgeCourseSections){
				this.removeCourseSection(courseSection1);
			}
		}
	}

	@Override
	public String toString() 
	{
		return "Course [courseNumber=" + courseNumber + ", courseName=" + courseName + ", numberOfCourses="
				+ numberOfCourses + ", courseSections=" + courseSections + "]";
	}
	
	//	Incomplete toString
//	public String toString() {
//		return ("The course number is " + courseNumber + 
//				", the course name is " + courseName + 
//				", the numberOf courses are: " + numberOfCourses +
//				", and the course Section is " + courseSections + ".");
//	}
}
