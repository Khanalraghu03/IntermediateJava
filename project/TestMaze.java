package project;

import java.util.Scanner;

/**
 * @author Raghu Khanal
 *
 */

public class TestMaze {
    public static void main(String[] args) {

        //•	Create a Scanner (input) to get user input from the keyboard.
        Scanner input = new Scanner(System.in);
        //•	Prompt the user for the filename for the maze and store it in a String (filename).
        System.out.print("Enter the filename for the maze(WITH the extensions): ");
        String filename = input.next();
        //Prompt the user for the width of the maze in pixels and store it in an int (width).
        System.out.print("Enter the maze width in pixels: ");
        int width = input.nextInt();
        //•	Prompt the user for the height of the maze in pixels and store it in an int (height).
        System.out.print("Enter the maze height in pixels: ");
        int height = input.nextInt();
        //•	Create an object of class Maze and pass filename, height and width by
        Maze mazeObject = new Maze(filename,width,height);

        input.close();



    }




}
