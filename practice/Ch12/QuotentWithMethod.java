package practice.Ch12;

import java.util.Scanner;

public class QuotentWithMethod 
{
	public static int quotent(int number1, int number2) 
	{
		if(number2 == 0)
		{
			System.out.println("Divisior cannot be zero");
			System.exit(0); //This is clearly 
			/* A method should not be able to terminate the program
			 * The caller{the main method} should decide whether to 
			 * 	terminate the program. 
			 * Java enables a method to throw an exception that 
			 * 	can be caught and handled by the caller.
			 * 	Check out the class-- QuotentWithException for the demo*/
		}
		
		return number1/number2;
	}
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
		int result = quotent(number1, number2);
		System.out.println(number1 + "/" + number2 + 
				"is " + result);
		
		
		input.close();
	}
}