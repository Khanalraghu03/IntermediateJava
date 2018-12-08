package practice.ch18;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputeFactorial 
	//Recursion: a method that calls it self
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a nonnegative integer: ");
		int n = 0;

		try 
		{
			n = input.nextInt();
			
			while (n < 0)
			{
				System.out.print("Please enter a non negative number: ");
				n = input.nextInt();
			}
			
			input.close();
		
			System.out.println(factorial(n));
		
		} catch (InputMismatchException e)
		{

			System.out.println("String not allowed");

		}
			
	}
		
	public static long factorial(int n) 
	{
		if(n == 0) //Base case: used to quit out of recursion
		{ 
			return 1;
		}
		
		else 
		{
			return n * factorial(n -1); //Recursive call
		}
	}
	
	
	//For example of n == 5 {
	
		//first 5 gets passed so  5! = 5 * (5-1)! =>  5 * 4! ==> (5 * 24) //Prints out 120
		 //then 4 gets passed so  4! = 4 * (4 -1)! =>4 * 3! ==>( 4 * 6)
			//then 3 passed so -- 3! = 3 * (3-1)! =>3 * 2! ==> (3 * 2) 
				//then 2 passed   2! = 2 * (2-1)! =>  2 * 1! ==> (2)
					//1 is passed 1! = 1 * (1-0)! ==> 1 * 0! ==> (1)
						//0 pass  0! = 0 * (0-0)! ==> (return 1) - base case {out out recursion)
						//just returns1 without recursion(calling it self)
							//Now it goes from bottom to top
		
		//Now it fills in the blank {goes from bottom to top}
			/* 0! = Base case: out of recursion = 1;
			 * 1! = 1 * 0! = 1 * (1) = 1
			 * 2! = 2 * 1! = 2 * (1) = 2
			 * 3! = 3 * 2! = 3 * (2) = 6
			 * 4! = 4 * 3! = 4 * (6) = 24
			 * 5! = 5 * 4! = 5 * (24) = 120
			 * */
	
	//}
	
}
