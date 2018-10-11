package practice.Ch12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WaysToWriteFilePath {
	public static void main(String[] args) {
		/*All three are ways to write the path for File*/
		
		
		//I can use two back slash, \\, in a path
			//Two \\ because one \ is special in java, i.e. \n, which means a new line
		File filePath = new File("c:\\users\\Khana\\Desktop\\TestIO\\text_file.txt"); //This will work on windows but not on other platforms
		
		File filePath2 = new File("c:/users/Khana/Desktop/TestIO/text_file.txt"); //This is preferred because it works in all the platforms
		
		// The java directory seperator is /
		
		//The best way is to use filePath2 OR filePath3 because if this file is sent to one someone else
			//and they also have text_file.txt in their desktop inside the TestIO folder
			//They are not the user Khana, and so using System.getProperty : that;s the advantage of filePath3 over 2
						//But filePath2 is faster to write, so it beats 3 on speed.
				//allows the flexibility of sharing/using the file and code
			//Also the orientation of path separator is different in Windows and Mac/Linux and other operating systems
			//File.separatorChar is universal and works with all the operating systems
		
		//System.getProperty("user.home") = " c:/users/Khana"
		//File.separatorChar = / or \\
		
		File filePath3 = new File(System.getProperty("user.home") + File.separatorChar 
				+ "desktop" + File.separatorChar + "TestIO" + File.separatorChar 
				+ "text_file.txt");
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Scanner readFile = null;
		String storeIt;
		try {
			readFile = new Scanner(filePath);
			while(readFile.hasNextLine()) {
				storeIt = readFile.nextLine();
				System.out.println(storeIt);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}

}
