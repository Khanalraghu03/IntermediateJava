package practice.Ch11;

public class Faculty extends Employee{
	public static void main(String[] args) {
		//creates a new Faculty object, w/out any variable reference
		new Faculty(); //calls the Faculty constructor; w.out it, nothing compiles
		
		//we could have had a Faculty with faculty as variable
			//since we not using the object
				//new Faculty(); does the job.
	}
	
	//Default constructor
	public Faculty() {
		//super(); this is provided by java for free: this is the path to Employee constructor
		System.out.println("In the default Faculty constructor!");
	}
}

class Employee extends Person{
	//Default constructor
	public Employee() {
		//super(); same story: path to the second constructor if any, then to the general class
		this("Inside default Employee constructor: this method"); //s = this
		System.out.println("Inside Employee sysout method ");
	}
	
	//Parameterized constructor
	public Employee(String s) {
		//super(); this is called: take it to the extended class: Person
		System.out.println("(Employee w/ s as parameter) " +s 
				+ " (Employee w/ s as parameter)");
	}
}

class Person{
	//Default constructor
	public Person(){
		//This classes doesn't extend anything, thus what ever is here gets executed first
		System.out.println("Inside Person default constructor");
	}
}