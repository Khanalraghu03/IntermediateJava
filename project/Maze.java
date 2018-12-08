package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Raghu Khanal
 *
 */

public class Maze extends JPanel implements ActionListener {
    private ArrayList<Rectangle> list1;
    private ArrayList<ArrayList<Rectangle>> list2;

    private String fileName;
    private int mazeWidth;
    private int mazeHeight;
    private volatile boolean wait;
    private int[][] maze;
    private int x;
    private int y;

    private JFrame frame;
    private JPanel panel;
    private JPanel panel1;
    private JButton button;

    public Maze(String fileName, int mazeWidth, int mazeHeight) {
        super();
        this.fileName = fileName;
        this.mazeWidth = mazeWidth;
        this.mazeHeight = mazeHeight;

        this.list1 = new ArrayList<>();
        this.list2 = new ArrayList<>();
        this.wait = true;
        readMazeFromFile();
//		Creates the GUI (see the screenshot on page 4 of this document).

        this.panel = new JPanel(new BorderLayout());
        this.panel1 = new JPanel();
        this.button = new JButton("Find Shortest Path");
        this.panel1.add(button);
        this.panel.add(this);
        this.frame = new JFrame("Maze");
        this.frame.setSize(mazeWidth + 100, mazeHeight + 100);
        this.frame.add(panel);

        this.panel.add(panel1, BorderLayout.SOUTH);

//      The frame size should be mazeWidth+100 X mazeHeight+100.

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setResizable(false);


        button.addActionListener(this);


//		Add a loop. Include the following code as it is:
        while (wait);
        findPath(list1, maze, x, y); // This method will be implemented later.

        findShortestPath(); //This method will be implemented later.
        repaint();


    }



    //Setters and Getters
    public ArrayList<Rectangle> getList1() {
        return list1;
    }

    public void setList1(ArrayList<Rectangle> list1) {
        this.list1 = list1;
    }

    public ArrayList<ArrayList<Rectangle>> getList2() {
        return list2;
    }

    public void setList2(ArrayList<ArrayList<Rectangle>> list2) {
        this.list2 = list2;
    }

    public String getFilename() {
        return fileName;
    }


    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public int getMazeWidth() {
        return mazeWidth;
    }


    public void setMazeWidth(int mazeWidth) {
        this.mazeWidth = mazeWidth;
    }


    public int getMazeHeight() {
        return mazeHeight;
    }


    public void setMazeHeight(int mazeHeight) {
        this.mazeHeight = mazeHeight;
    }


    public int[][] getMaze() {
        return maze;
    }


    public void setMaze(int[][] maze) {
        this.maze = maze;
    }


//    public int getX() {
//        return x;
//    }
//
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//
//    public int getY() {
//        return y;
//    }
//
//
//    public void setY(int y) {
//        this.y = y;
//    }

    //toString
    @Override
    public String toString() {
        return "Maze [list1=" + list1 + ", list2=" + list2 + ", filename=" + fileName + ", mazeWidth=" + mazeWidth
                + ", mazeHeight=" + mazeHeight + ", maze=" + Arrays.toString(maze) + ", x=" + x + ", y=" + y + "]";
    }


    public void readMazeFromFile() {
        //	It creates a File object (file) with the filePath and filename (use the instance variable fileName)
        //      to read a maze from a text file in the folder Maze-Data on the Desktop.
        File path = new File(System.getProperty("user.home") + File.separatorChar
                + "desktop" + File.separatorChar + "Maze_Data" + File.separatorChar
                + fileName);


        //Create a Scanner (fileIn) to read the file.
        Scanner fileIn = null;
        String line = "";
        int countRows = 0; //store rows of the binary maze

        //Handle any Exceptions by printing the stack trace.
        try {
            fileIn = new Scanner(path);
            //Count the number of rows
            while (fileIn.hasNextLine()) {
                line = fileIn.nextLine();
                countRows++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: File Not Found @ line 146");
        }


        fileIn.close();


        //	Declare an int countColumns and initialize it to (line.length()+1)/2. This expression computes the number
        //      of columns by taking into account that there are spaces in each row of the file.
        int countColumns = (line.length() + 1) / 2;

        //	Create a 2D Array
        this.maze = new int[countRows][countColumns];


        //	Create a Scanner (readMaze) to read the file.
        Scanner readMaze = null;
        //Handle any Exceptions by printing the stack trace.
        try {
            readMaze = new Scanner(path);
            //	Read the data from the file into maze
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    maze[i][j] = readMaze.nextInt();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error: File Not Found @ Line 174");
        }


        readMaze.close();
        //	Display the maze using the following code:
        for (int i = 0; i < maze.length; i++) {
            System.out.println(Arrays.toString(maze[i]));
        }

    }


    //Implement method +paintComponent(g: Graphics): void
    public void paintComponenet(Graphics g) {

        //Call the paintComponent(g) from the super class
        super.paintComponent(g);
        //Use the following algorithm to draw the maze
        //Nested loops for (i,j) until all ints in the maze are visited
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                //	If the int is zero
                if (maze[i][j] == 0) {
                    ////This color coding is used to identify the walls in the maze
                    //		setColor to black
                    g.setColor(Color.BLACK);
                }

                //	else if the int is 2
                else if (maze[i][j] == 2) {
                    ////This color coding is used to identify the shortest path that leads out of the maze
                    //		setColor to blue
                    g.setColor(Color.BLUE);
                }

                //	else if the int is 3
                else if (maze[i][j] == 3) {
                    ////This color coding is used to temporarily identify a path that leads out of the maze as //soon as it is found
                    //		setColor to orange
                    g.setColor(Color.ORANGE);
                }

                //	else if the int is 4
                else if (maze[i][j] == 4) {
                    ////This color coding is used to identify the path currently being traversed
                    //		setColor to light grey
                    g.setColor(Color.lightGray);

                } else {
                    //int is 1. This color coding is used to identify all the paths in the maze
                    //setColor to white
                    g.setColor(Color.WHITE);

                }
                //Draw the rectangle with computed x-coordinate, y-coordinate, width and height
                g.drawRect(x, y, mazeWidth, mazeHeight);

                g.fillRect(j * (mazeWidth / maze[0].length) + 40, i * (mazeHeight / maze.length) + 30,
                        mazeWidth / maze[0].length, mazeHeight / maze.length);

            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //Declare a boolean (foundOpening) and initialize it to false.
        boolean foundOpening = false;
        //Nested loops for (i,j) until all ints in the maze are visited && foundOpening==false
        for(int i = 0; i < maze.length && !foundOpening; i++) {
            for(int j = 0; j < maze[i].length &&!foundOpening; j++) {
                //	If i or j fall in a boundary cell of the 2D Array
                if(i >= 0 || i <= maze.length -1 || j >= 0 || j <= maze[i].length -1) {
                    //		If maze[i][j] is equal to 1
                    if(maze[i][j] == 1) {
                        //Assign j to x
                        x = j;
                        //Assign i to y
                        y = i;
                        //Assign true to foundOpening
                        foundOpening = true;
                        //		End if
                    }

                }

            }

        }

        //Assign false to wait
        wait = false;
        //SOP x and y
        System.out.println("x is " + x + " and y is " + y);
    }


    ////Implement the following method to find a path through the maze
    //Implement recursive method +findPath(l: ArrayList<Rectangle>, maze: int [][], j: int, i: int): void
    public void findPath(ArrayList<Rectangle> l, int[][] maze, int j, int i) {
        //Declare a long (msecs) and initialize it to 10
        long msecs = 10;
        //If i or j fall outside the boundaries of the 2D Array
        if(i <= 0 || i >= maze.length -1 || j <= 0 || j >= maze[i].length -1) {
            //Declare a variable list of type ArrayList <Rectangle> and create the ArrayList
            ArrayList<Rectangle> list = new ArrayList<>();
            /****************************************************************************************************/
            //	For loop to iterate as many times as the size of l
            for (int k = 0; i < l.size(); i++) {
                //Declare a variable rectangle of type Rectangle and get (not remove) a Rectangle from l and assign it to rectangle
                Rectangle rectangle = l.get(k);
                //If l size is greater than 2
                if (l.size() > 2) {
                    //Explanation for following pseudocode statement: A path is found. Code it with
                    //integer 3, so that it will be colored orange in the graphical maze
                    //Assign 3 to maze[value of x from rectangle][value of y from rectangle]
                    maze[x][y] = 3;
                }

                //	Add rectangle to list
                list.add(rectangle);
                //	End loop
            }
            /****************************************************************************************************/
            //Call the repaint method
            repaint();
            //If l size is greater than 2
            if (l.size() > 2) {
                ////Explanation for following try-catch statement: Delay for 1 second so that the user
                ////has time to clearly observe the path highlighted in orange. The number passed to the
                ////sleep method is interpreted as milliseconds. Include the try-catch in the code
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //	End if
            }

            //	For loop to iterate as many times as the size of l
            for (int k = 0; k < l.size(); k++) {
                //	Declare a variable rectangle of type Rectangle and get (not remove) a Rectangle from l and assign it to rectangle
                Rectangle rectangle = l.get(k);
                //Explanation for following pseudocode statement: Code the path with integer 4, so that
                ////it will be colored light grey in the graphical maze and no longer be highlighted in
                ////orange since the next path is to be searched, for an opening out of the maze
                //Assign 4 to maze[value of x from rectangle][value of y from rectangle]
                maze[x][y] = 4;
                //	End loop
            }
            //	Add list to list2
            //	Return
            //End if
            list2.add(list);
            return;

        }
        ////Explanation for following pseudocode statement: If a wall is encountered or an Array slot in the path is
        ////already visited, return from the method
        //If maze[i][j] is equal to 0 or 4
        if (maze[i][j] == 4) {
            //	Return;
            //End if
            return;
        }

        ////Explanation for following pseudocode statement: Mark the current Array slot as visited
        //Assign 4 to maze[i][j]
        //
        maze[i][j] = 4;

        ////Explanation for following pseudocode statement: Continue storing the current path being searched by
        ////adding a Rectangle corresponding to the current Array slot onto l
        //Add new Rectangle(i, j, mazeWidth/maze[0].length, mazeHeight/maze.length) to l
        l.add(new Rectangle(i, j, mazeWidth/maze[0].length, mazeHeight/maze.length));
        //
        //Call the repaint method
        repaint();
        //
        ////Explanation for following try-catch statement: Delay for msecs so the user can clearly
        ////observe how the search progresses to the next slot. Include the try-catch in the code
        try {
            Thread.sleep(msecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        ////Explanation for following pseudocode statement: Allow the search to progress in all four directions
        //Call findPath recursively on the Array cells to the left, above, to the right and below the current Array cell at i, j.
        //
        //If l is not empty
        if(!l.isEmpty()) {
            //	Declare a variable rectangle of type Rectangle and remove (not get) the last Rectangle from l and assign it to rectangle
            Rectangle rectangle = l.remove(l.size() -1);

            ////Explanation for following pseudocode statement: Code the path with integer 1, so that it will
            ////be colored white in the graphical maze as the search backtracks after encountering a wall or
            ////an Array slot in the path that is already visited or an opening that leads out of the maze
            //Assign 1 to maze[value of x from rectangle][value of y from rectangle]
            maze[x][y] = 1;
            //
            //Call the repaint method
            repaint();
            //
            ////Explanation for following try-catch statement: Delay for msecs so the user can
            ////clearly observe how the search backtracks to the previous slot
            try {
                Thread.sleep(msecs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //End if

        }

    }

    ////Implement the following method to find the shortest path from the stored paths
    //Implement method +findShortestPath(): void
    public void findShortestPath() {
        //Declare a variable tempList of type ArrayList <Rectangle>. Initialize it to null
        ArrayList<Rectangle> tempList = null;
        //Declare a variable shortestList of type ArrayList <Rectangle>. Initialize it to null
        ArrayList<Rectangle> shortestList = null;
        //Declare a variable min of type long. Initialize it to the maximum value of type long
        long min = (long)(Math.pow(2,64) - 1);
        ////Explanation for following pseudocode: Loop to find the shortest list in the queue
        //Loop until list2 is empty

        while(!list2.isEmpty()) {
            //Remove a list from list2 and assign it to tempList
            /************************************************************/
            tempList = (list2.remove(0));
            //If tempList size is greater than 1 and less than min
            if (tempList.size() > 1 && tempList.size() < min) {
                //	Assign tempList size to min
                min = tempList.size();
                //	Assign tempList to shortestList
                shortestList = tempList;
                //End if
            }
            //End loop
        }

        ////Explanation for following pseudocode: Loop to code the shortest path using the integer 2, so
        ////that it will be colored blue in the graphical maze
        //Loop until shortestList is empty
        while(!shortestList.isEmpty()) {
            //Declare a variable rectangle of type Rectangle and remove a Rectangle from shortestList and assign it to rectangle
            /************************************************************/
            Rectangle rectangle = shortestList.remove(0);
            //	Assign 2 to maze[value of x from rectangle][value of y from rectangle]
            maze[x][y] = 2;
            //End loop
        }


    }

}
