/**
 * 
 */
package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Raghu Khanal
 *
 */
public class FileReadWrite {
	File filePath;
	File filePathCopy;
	File dataFilePath;
	Scanner dataInput;
	Scanner readFile;
	/**
	 * 
	 */
	public FileReadWrite() 
	{
		//user.home obtains the path up to C:\Users\Khana\
		filePath= new File(System.getProperty("user.home") + File.separatorChar 
				+ "desktop" + File.separatorChar + "TestIO" + File.separatorChar 
				+ "text_file.txt");
		
		filePathCopy = new File(System.getProperty("user.home") + File.separatorChar 
				+ "desktop" + File.separatorChar + "TestIOCopy" + File.separatorChar 
				+ "text_file_copy.txt");
		dataFilePath = new File(System.getProperty("user.home") + File.separatorChar 
				+ "desktop" + File.separatorChar + "DataFileFolder" + File.separatorChar 
				+ "datafile.dat");
	}

	public void createFile() 
	{ 
		//Throws IOExecption
		//If this method is called in the tester{with the throws IOExecption} by creating an object, it will result in an error
		//You want to handle it so the program doesn't terminate
		/*
		 * If there is an incorrect path or if a folder or file 
		 * 		does not exist in the path as specified an IOExecption
		 * 		object will be passed by the method at runtime
		 * To correct the error, we have to pass the Exception to 
		 * 		the calling method or handle the Exception to resolve
		 * 		the runtime error
		 * */

		//Create a condition to stop execution of the loop
		boolean fileCreated = false;
		while(!fileCreated)
		{
			try 
			{
				if(filePath.createNewFile()) {
					System.out.println("File created in folder "+ "TextIO");
				}
				else {
					//Returns false if the file already exists
					System.out.println("The file already exists");
				}
				fileCreated = true;
			} 
			catch (IOException e) 
			{
				/* Write error handling code in the catch block.
				 * The catch block will execute if there is a runtime
				 * 		error and an Exception is thrown in the try-block
				 * 		this method will give information about the error 
				 */
				e.printStackTrace();
				/*We will handle the error by creating the folder TextIO
				 * 	in the catch block and then looping back to the 
				 * 	try block to create the file*/
				filePath.getParentFile().mkdir(); 	//obtain the path up to the folder, and will not include the file
				System.out.println("Folder TextIO created");
			} 
		}	
	}

	public void writeFile() 
	{
		PrintWriter fileWrite = null;
		try {
			fileWrite = new PrintWriter(new FileWriter(filePathCopy, true));
			for(int i = 0; i < 10; i++) {
				fileWrite.println("Test line written to file: line " + i);
			}
			System.out.println("Wrote to the File");
		} catch (FileNotFoundException e) {
			System.out.println("Unable to write to the file due to");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (fileWrite != null) 
		{
			fileWrite.close();
		}

	}
	public void readFile()
	{
		Scanner fileRead = null;
		try 
		{
			fileRead = new Scanner(filePath);
			//Use a loop. Check to see if there is a line to read
			//If there is a line to read, store it as a String
			//And display the screen on the console
			//When there are no lines to read, the loop should 
			//terminate.
			String line = "";
			while(fileRead.hasNextLine())
			{
				line = fileRead.nextLine();
				System.out.println(line);
			}

			System.out.println("File read complete");

		} 

		catch (FileNotFoundException e) 
		{
			System.out.println("Failed to read file");
		}

		if(fileRead != null)
		{
			fileRead.close();
		}

	}


	public void typeLinesToFile()
	{
		Scanner input = new Scanner(System.in);
		PrintWriter writeToFile = null;
		System.out.print("Please enter a line of texts {enter 'q' or 'quit' to quit}: ");
		String lineOfTexts = input.nextLine();

		try 
		{
			writeToFile = new PrintWriter(filePath);
			while(!(lineOfTexts.equalsIgnoreCase("q") || lineOfTexts.equalsIgnoreCase("quit")))
			{
				writeToFile.println(lineOfTexts);
				lineOfTexts = input.nextLine();

			}
			System.out.println("Wrote to file");

		} 
		catch (FileNotFoundException e1) 
		{
			System.out.println("Cannot write to the file");
		} 

		//I want to close the Scanner input and the PrintWriter
			//so that it doesn't take any storage or cause an error
		if(input != null)
		{
			input.close();
		}

		if(writeToFile != null)
		{
			writeToFile.close();
		}
	}

	public void parseFile()
	{	
		//Loop to calculate the number of line by using the lineOfTexts, 
//		for()
		
		//Display the number of lines
		
			//if "\n" then count++
		
		String line;
		int countLines = 0;
		int countWords = 0;
		int countChars = 0;
		try {readFile = new Scanner(filePath);
			while(readFile.hasNextLine()) {
				line = readFile.nextLine();
				countLines++;
				
				String[] words = line.split(" ");
				countWords += words.length;
				
				for(int i = 0; i < words.length; i++)
				{
					countChars += words[i].length();
				}
	
			}

			System.out.println("The number of line are " + countLines);
			System.out.println("The number of words are " + countWords);
			System.out.println("The number of characters are " + countChars);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void copyFile()
	{
		
		 boolean fileCreated = false;
			while(!fileCreated)
			{
				try 
				{
					if(filePathCopy.createNewFile()) {
						System.out.println("File created in folder "+ "TextIOCopy");
					}
					else {
						//Returns false if the file already exists
						System.out.println("The file already exists 1");
					}
					fileCreated = true;
				} 
				catch (IOException e) 
				{
					/*Write error handling code in the catch block.
					 * The catch block will execute if there is a runtime
					 * 		error and an Exception is thrown in the try-block
				 		this method will give information about the error */
					 
					e.printStackTrace();
					/*We will handle the error by creating the folder TextIO
					 * 	in the catch block and then looping back to the 
					 * 	try block to create the file */
					filePathCopy.getParentFile().mkdir(); 	//obtain the path up to the folder, and will not include the file
					System.out.println("Folder TextIOCopy created");
				}
			}
			
		Scanner readFilePath;
		String line;
		PrintWriter fileWrite = null;
		try {
			readFilePath = new Scanner(filePath);
			fileWrite = new PrintWriter(new FileWriter(filePathCopy, true));
			while(readFilePath.hasNextLine())
			{
				line = readFilePath.nextLine();
				fileWrite.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to write to the file due to");
		} catch (IOException e) {
			e.printStackTrace(); //printStackTrace is a method in the Class: IOException
		}
		if (fileWrite != null) 
		{
			fileWrite.close();
		}
			
	}
	
	
	public void parseDataFile() throws IOException {
		
		//Create a folder and the file first
		 boolean fileCreated = false;
			while(!fileCreated)
			{
				try 
				{
					if(dataFilePath.createNewFile()) {
						System.out.println("File created in folder "+ "DataFile" + " with the name datafile.dat");
					}
					else {
						//Returns false if the file already exists
						System.out.println("The file already exists");
					}
					fileCreated = true;
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
					
					dataFilePath.getParentFile().mkdir();
					System.out.println("Folder DataFile created");
				}
				
			}
			
			//After creating the file, now write in it

		
		//Loop to calculate the number of line by using the lineOfTexts, 
//		for()
		
		//Display the number of lines
		
			//if "\n" then count++
	
			
		PrintWriter writeToLine = new PrintWriter(new FileWriter(dataFilePath, true)); //Writes to the data file
		
		System.out.print("Please enter the data {enter 'q' to quit}: "); //Alerts user to input data
		//		String datas = "";
		dataInput = new Scanner(System.in); //Saves the input the user inputed into the variable dataInput
		String datas = dataInput.next();  //Save what is stored in dataInput to the string datas
		
		
		while(!(datas.equalsIgnoreCase("q") || datas.equalsIgnoreCase("quit"))) {
			System.out.print("Please enter the data {enter 'q' to quit}: ");
			datas = dataInput.next();
			writeToLine.println(datas);
		}
		
		System.out.println("Done entering data to the file");
		writeToLine.close();
		dataInput.close();
		
		
		//Parse the string in to the double
		Scanner readFile = null;
		String readedLine = null;
		
		ArrayList<Double> theDoubleList = new ArrayList<>();
		try {
//			System.out.println(“Reading and displaying data from file”);
			readFile = new Scanner(dataFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("The file doesn't exist");
			
		}
	
		//Compute Sum and Average
		Double num;
		double sum = 0;
		double avg = 0;
		while(readFile.hasNext()) {
			
			readedLine= readFile.next();
			
			try {
			num = Double.parseDouble(readedLine);
			theDoubleList.add(num);
			
			}catch(NumberFormatException e) 
			{
//				System.out.println(readedLine + " has been assigned to 1.0");

				theDoubleList.add(1.0);
//				System.out.println("The array list " + theDoubleList);
				for (int i = 0; i < theDoubleList.size(); i++)
				{
					sum += theDoubleList.get(i);
				}
				avg = sum / theDoubleList.size();
			}
	
		}
		
		//Print Sum and Average
		System.out.println("The sum of the arrayList is " + sum);
		System.out.println("The avg of the arrayList is " + avg);
			
	}
	
}
