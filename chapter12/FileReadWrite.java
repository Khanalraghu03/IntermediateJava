/**
 * 
 */
package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Raghu Khanal
 *
 */
public class FileReadWrite {
	File filePath;
	
	/**
	 * 
	 */
	public FileReadWrite() 
	{
		//user.home obtains the path up to C:\Users\Khana\
		filePath= new File(System.getProperty("user.home") + File.separatorChar 
				+ "desktop" + File.separatorChar + "TestIO" + File.separatorChar + 
				"text_file.txt");
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
			fileWrite = new PrintWriter(new FileWriter(filePath, true));
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
		if (fileWrite != null) {
			fileWrite.close();
			System.out.println();
		}

	}
}