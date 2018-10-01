package practice.Ch12;

import java.util.*;

public class InputMismatchExceptionDemo 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean continueInput = true;
		
		do {
		 try {
			System.out.print("Enter an integer: ");
			int number = input.nextInt();
				
			System.out.println("The number entered is " + number);
			continueInput = false;
		 }
		catch(InputMismatchException ex) {
			
			System.out.println("Try again. ("
				+ "Incorrect input: an integer is required)");
			input.nextLine(); //Discard input
			}
			
		} while(continueInput);
	
		input.close();
		
//		System.out.println(1 / 0);
		System.out.println(1.0 / 0); //Infinity
		System.out.println(-1.0 / 0); //-Infinity
		
	}

}
