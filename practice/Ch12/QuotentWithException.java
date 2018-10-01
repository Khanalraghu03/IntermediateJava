package practice.Ch12;

import java.util.Scanner;

public class QuotentWithException {
	public static int quotent(int number1, int number2)
	{
		if(number2 == 0)
		{
			throw new ArithmeticException("Divisor cannot be zero"); //This is called Exception
		}
		
		return number1/number2;
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		try //Used for normal operation
		{
			int result = quotent(number1, number2);
			System.out.println(number1 + " / " + number2 
					+ " is " + result);
		}
		
		//ex acts like the parameter in a method. this parameter is referred to as a catch-block parameter. 
			//specifies what kind of exception the catch block can catch. 
		catch(ArithmeticException ex) //Used to catch exception: dividing by zero{Handle the exception}
		{
			System.out.println("Exception: an integer cannot be "+
					"divided by zero.");
		}
		System.out.println("Execution continues ...");
		
		input.close();
		
		
	//In general
	/*
		 
		 try {
		 	Code to run;
		 	A statement or a method that may throw an exception;
		    More code to run;
		  }
		  
		 catch (type ex) {
		  	Code to process the exception;
		 }
		 
	*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
