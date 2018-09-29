/*
 * @author: Raghu Khanal
 * @description: This program will test the person class using arraylist to store objects of person, and print it.
 * 
 * 
 * */

package chapter11.assingment;

import java.util.ArrayList;

public class TestPerson 
{
	public static void main(String[] args) 
	{
		ArrayList<Person> personObject = new ArrayList<>();
		personObject.add(new Person("Raghu", "123 Main Street", "404-333-3333","rkhanal@ggc.edu"));
		personObject.add(new Student("Raghu", "123 Main Street", "404-333-3333", "rkhanal@ggc.edu","Shopmore" ));
		personObject.add(new Employee("Employee", "Address", "404-123-4567", "e@gmail.com", "D-1101", 10000));
		personObject.add(new Faculty("Faculty", "Address", "404-345=5679", "e@gmail.com", "C-1101", 11000,"9:00AM - 5:00PM", "Professor"));
		
		
		//Print the ArrayList
		for(int i = 0; i < personObject.size(); i++) 
		{
			System.out.println(personObject.get(i).toString());
		}
		
		System.out.println();
		
		//Search for the student by email address and change the phone number
			//personObject.contains(Student.) student email address? //change phone number
		for(Person person: personObject) {

			if(person.getEmailAddress().equals("rkhanal@ggc.edu")) {
				person.setPhoneNumber("404-345-3321");
			}
		}
		
		//Remove the employee object
		personObject.remove(2);
		
		//Print the ArrayList
		for(int i = 0; i < personObject.size(); i++) 
		{
			System.out.println(personObject.get(i).toString());
		}
		
		System.out.println();
		//Add staff object
		personObject.add(new Staff("TheStaff", "2345 Hello-World Street", "678-543-7654", "e@gmail.com", "H-1101", 11000, "Principle"));
		
		//Print the ArrayList
		for(int i = 0; i < personObject.size(); i++) 
		{
			System.out.println(personObject.get(i).toString());
		}
		
		Faculty faculty = new Faculty("Faculty", "Address", "404-345=5679", "e@gmail.com", "C-1101", 11000,"9:00AM - 5:00PM", "Professor");
		System.out.println("The total pay for the Faculty is " + faculty.getTotalPay());
		
		Staff staff = new Staff("TheStaff", "2345 Hello-World Street", "678-543-7654", "e@gmail.com", "H-1101", 11000, "Principle");
		System.out.println("The total pay for the Staff is " + staff.getTotalPay());
	}
}