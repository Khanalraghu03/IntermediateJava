package practice.ch18;

import java.util.Scanner;

public class ComputeFibonacci {
	public static void main(String[] agrs)  {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an index for a fibonacci number: ");
		
		int index  = input.nextInt();
		
		input.close();
		
		System.out.println("The Fibonacci number at index "
				+ index + " is " + fib(index));
		
	}
	
	public static long fib(long index) {
		if(index == 0) { //Base case
			return 0;
		}
		else if(index == 1) { //Base case
			return 1;
		}
		else 
			return fib(index - 1) + fib(index -2);
	}
	
	
	/*
	 * For case of index == 4
	 * we have fib(4 -1) + fib(4-2) ==> fib(3) + fib(2)
	 * 		fib(3) ==> fib(3-1) + fib(3-2) ==> fib(2) + fib(1) = fib(3)
	 * 			fib(2) ==> fib(2-1) + fib(2-2) ==> fib(1) + fib(0)
	 * 				fib(1) = 1
	 * 				fib(0) = 0
	 * 				fib(2) = 1 + 0
	 * 			fib(2) = 1
	 *			fib(1) = 1
	 *				fib(3) = fib(2) + fib(1) = 1 + 1 = 2
	 *
	 *	fib(3) = 2;
	 *
	 * 		fib(2) ==> fib(2-1) + fib(2-2) ==> fib(1) + fib(0)
	 * 				fib(1) = 1
	 * 				fib(0) = 0
	 * 			fib(2) = fib(1) + fib(0) = 1 + 0 = 1
	 * 
	 * 	fib(2) = 1;
	 * 
	 * fib(4) = fib(3) + fib(2) = 2 + 1 = 3
	 * 		fib(4) = 3;
	 * */

}
