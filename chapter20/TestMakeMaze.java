/**
 * 
 */
package chapter20;

import java.util.Scanner;

/**
 * @author apereira
 *
 */
public class TestMakeMaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the filename: ");
		String filename = input.nextLine();
		System.out.println("Enter the maze width: ");
		int width = Integer.parseInt(input.nextLine());
		System.out.println("Enter the maze height: ");
		int height = Integer.parseInt(input.nextLine());
		System.out.println("Enter the number of mazes to be "
			+ "created: ");
		int numberOfMazes = Integer.parseInt(input.nextLine());
		new MakeMaze(filename, width, height, numberOfMazes);
		input.close();
		
//		�	Prompt the user for the filename for the maze and 
		//store it in a String (filename).
//		�	Prompt the user for the width of the maze in pixels and store it in an int (width).
//		�	Prompt the user for the height of the maze in pixels and store it in an int (height).
//		�	Prompt the user for the numberOfMazes in pixels and store it in an int (numberOFMazes).
//		�	Create an object of class Maze and pass filename, height and width by adding the following code: new Maze(filename,width,height,numberOfMazes);
//		�	Close input.


	}

}
