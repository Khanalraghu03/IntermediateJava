package practice.Ch11;

public class CastingObjectsAndinstaceOf {

	//One object reference(address that gets printed on the console)
		//can be typecast into another object reference.
				//This is called casting object.
	
	//m(new Student()); same as ==> 
		//Object o = new Student();  ==> implicit casting
		//m(o)
	
	//Implicit casting: legal- an instance of Student is an instance of Object
	
	
	//Student b = o; ==> //compiler error: Object is not necessarily be an instance of Student
		//Student is a instance of Object
			//Object is not an instance of Student
				//even though o is a Student object, compiler is not clever enough to know it.
	//To do this: use explicit casting
		//Student B = (Student) B; //Explicit casting
	//The syntax is similar to the one used for casting among primitive data types.
	
	
	//Electronic is super class, Apple is a subclass
		//Electronic apple = new Apple();  //Downcasting
	
	//apple actual type is Apple but it's reference type is Electronic.
	
		//Apple apple2 = (Apple) apple; //Upcasting
	//apple2 reference type is Apple and apple reference type is Electronic even though it's actual type is apple
		//Thus you must cast (Apple) which is called explicit casting
	
	
	//You have to make sure that the subclass is an instance of the superclass
		//To avoid ClassCastException error do:
		
	//if(super(variable) instanceOf sub(class)) {
		// (Circle)variable.getMethod();
			//variable.getMethod(); would cause an error because
					//super doesn't have specific getMethod(), Circle does
			//}
	//To Enable generic programming, it is a good practice to define a variable with a supertype
		//which can accept an object of any subtype
	
	
	//Every letter is Java keyword is lowercase
	
	/*
	 * Apple can be an instance of Fruit.
	 * Fruit is not Just apple, so you have to explicitly cast to assign an instance of Apple*/






}
