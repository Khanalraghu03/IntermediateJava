package practice.Ch12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFile {
	public static void main(String[] args) 
	{
		File file = new File("src/practice/Ch12/test.txt");
		Scanner readTest = null;
		try {
			readTest = new Scanner(file);
			
		} catch (FileNotFoundException e) {
			System.out.println(file +" not found");
		} 
		int intValue = readTest.nextInt();
		String line = readTest.nextLine();
		System.out.println(intValue);
		System.out.println(line);
		
		readTest.close();
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		int intValue2 = input.nextInt(); //Takes the first group of numbers
		String line2 = input.nextLine(); //Takes everything after the group of number, including the space
		
		//Print it
		System.out.println(intValue2);
		System.out.println(line2);
		
		input.close();
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		//Read text file that is inside the ITEC2150 directory
		Scanner read = null;
		try {
			read = new Scanner(new File("testInITEC2150.txt"));
			int intValue3 = read.nextInt();
			String line3 = read.nextLine();
			System.out.println(intValue3);
			System.out.println(line3);
		} catch (FileNotFoundException e) {
			System.out.println("Text file not found: line 52");
		}
		read.close();
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		Scanner scanAString = new Scanner("13 14");
		int sum = scanAString.nextInt() + scanAString.nextInt();
		System.out.println("sum is " + sum);
		
		scanAString.close(); //Prints sum is 27
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
	}
	
}
