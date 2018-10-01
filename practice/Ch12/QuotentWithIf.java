package practice.Ch12;

import java.util.Scanner;

public class QuotentWithIf 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter two integers
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		
//		System.out.println(number1 + " / " + number2 + " is " + (number1 / number2));    
			/*Exception in thread "main" java.lang.ArithmeticException: / by zero
			 * at practice.Ch12.Listing12dash2.main(Listing12dash2.java:16)*/
		
		
		//To fix this error Do:
		 if (number2 != 0) 
		 {
			 System.out.println(number1 + " / " + number2 + " is " + (number1 / number2));
		 }
		 else 
		 {
			 System.out.println("Divisor cannot be zero ");
		 }
		 
		 
		 //Even with this, there is still a way to you can get Exception: 
		 	//By entering a double instead of integer.
		 
		 
		 
		 input.close();
	}
}