/**
 * 
 */
package chapter20;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author apereira
 *
 */
public class MakeMaze extends JPanel implements ActionListener {
	//A MyLinkedList object to store Integer objects. 
	//A MyLinkedList will store Integers (1s and 0s).
	private MyLinkedList<Integer> list;
	//A stack to store Rectangle objects.
	private Stack<Rectangle> stack;
	//A PriorityQueue to store MyLinkedLists of Integer.
	private PriorityQueue<MyLinkedList<Integer>> priorityQueue;
	private String fileName;
	private int mazeWidth;
	private int mazeHeight;
	private int numberOfMazes;
	private Random random;
	private volatile boolean wait;
	//Two dimensional (2D) array to store the 1s and 0s. 
	//A 2D array is an array in which elements are 
	//logically stored and accessed in rows and columns similar 
	//to a 2D matrix or grid.
	private int [][] maze;
	//Variables to store the coordinates for the entrance to the 
	//maze
	private int x;
	private int y;
	//A constant for the milliseconds to be delayed
	public final static long MSECS=10;
	//The following instance variables are also required:
	private JFrame frame;
	private JPanel panel;
	private JPanel panel1;
	private JButton button;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MakeMaze(String fileName, int mazeWidth, int mazeHeight,
			int numberOfMazes) {
		this.fileName= fileName;
		this.mazeWidth= mazeWidth;
		this.mazeHeight= mazeHeight;
		this.numberOfMazes= numberOfMazes;
//		•	It creates a Stack and assigns it to the instance 
		//variable.
		stack = new Stack<>();
		//		•	It creates a PriorityQueue and assigns it to 
		//the instance variable.
		priorityQueue = new PriorityQueue<>();
//		•	It creates a default Random object and assigns it to 
		//the instance variable.
		random = new Random();
//		•	 It assigns true to the instance variable wait
		wait = true;
//		•	It calls the readMazeFromFile() method. This method 
		//will be implemented later. Comment out the method call 
		//for now.
		readMazeFromFile();
		
		//		•	Creates the GUI (see the screenshot on page 5. At this point, create only the window and the button. The maze will be drawn later). The frame size should be mazeWidth+100 X mazeHeight+100.
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel();
		button = new JButton("Make Maze");
		panel1.add(button);
		panel.add(this);
		panel.add(panel1, BorderLayout.SOUTH);
		frame = new JFrame("Maze");
		frame.add(panel);
		frame.setSize(mazeWidth+100, mazeHeight+100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		//		•	Handles the button click event.
		button.addActionListener(this);
//		•	Add a while-loop that continuously iterates to stall
		//the program until wait is set to true.
		while(wait);
		for(int i = 0; i < numberOfMazes; i++) {
			reset();
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			makePath(stack, maze, x, y);
			makeMultiplePaths(); 
			makeOpenings();
			enqueue();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		•	Calls dequeue().This method will be implemented later. Comment out the method call for now.
		dequeue();
		repaint();
		writeMazeToFile();
	}

	/**
	 * @return the list
	 */
	public MyLinkedList<Integer> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(MyLinkedList<Integer> list) {
		this.list = list;
	}

	/**
	 * @return the stack
	 */
	public Stack<Rectangle> getStack() {
		return stack;
	}

	/**
	 * @param stack the stack to set
	 */
	public void setStack(Stack<Rectangle> stack) {
		this.stack = stack;
	}

	/**
	 * @return the priorityQueue
	 */
	public PriorityQueue<MyLinkedList<Integer>> getPriorityQueue() {
		return priorityQueue;
	}

	/**
	 * @param priorityQueue the priorityQueue to set
	 */
	public void setPriorityQueue(PriorityQueue<MyLinkedList<Integer>> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the mazeWidth
	 */
	public int getMazeWidth() {
		return mazeWidth;
	}

	/**
	 * @param mazeWidth the mazeWidth to set
	 */
	public void setMazeWidth(int mazeWidth) {
		this.mazeWidth = mazeWidth;
	}

	/**
	 * @return the mazeHeight
	 */
	public int getMazeHeight() {
		return mazeHeight;
	}

	/**
	 * @param mazeHeight the mazeHeight to set
	 */
	public void setMazeHeight(int mazeHeight) {
		this.mazeHeight = mazeHeight;
	}

	/**
	 * @return the numberOfMazes
	 */
	public int getNumberOfMazes() {
		return numberOfMazes;
	}

	/**
	 * @param numberOfMazes the numberOfMazes to set
	 */
	public void setNumberOfMazes(int numberOfMazes) {
		this.numberOfMazes = numberOfMazes;
	}

	/**
	 * @return the maze
	 */
	public int[][] getMaze() {
		return maze;
	}

	/**
	 * @param maze the maze to set
	 */
	public void setMaze(int[][] maze) {
		this.maze = maze;
	}

	/**
	 * @return the x
	 */
//	public int getX() {
//		return x;
//	}
//
//	/**
//	 * @param x the x to set
//	 */
//	public void setX(int x) {
//		this.x = x;
//	}
//
//	/**
//	 * @return the y
//	 */
//	public int getY() {
//		return y;
//	}
//
//	/**
//	 * @param y the y to set
//	 */
//	public void setY(int y) {
//		this.y = y;
//	}
	
/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MakeMaze [list=" + list + ", stack=" + stack 
				+ ", priorityQueue=" + priorityQueue 
				+ ", fileName="
				+ fileName + ", mazeWidth=" + mazeWidth 
				+ ", mazeHeight=" + mazeHeight 
				+ ", numberOfMazes=" + numberOfMazes 
				+ ", maze=" + Arrays.toString(maze) 
				+ ", x=" + x + ", y=" + y + "]";
	}
//	Implement method +readMazeFromFile(): void
	public void readMazeFromFile() {
		File filePath = new File(System.getProperty("user.home")
			+File.separatorChar+"Desktop"
			+File.separatorChar+"Maze_Data"
			+File.separatorChar+fileName);
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = "";
		int countRows = 0; 
		while(fileIn.hasNextLine()){
			line = fileIn.nextLine();
			countRows++;
		}
		if(fileIn!=null)
			fileIn.close();
		int countColumns = (line.length()+1)/2;
		maze = new int[countRows][countColumns];
		Scanner readMaze = null;
		try {
			readMaze = new Scanner(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				maze[i][j]= readMaze.nextInt();
			}
		}
		if(readMaze!=null)
			readMaze.close();
		for(int i = 0; i < maze.length; i++){
				System.out.println(Arrays.toString(maze[i]));
		}
	}
	
//	Implement method +paintComponent(g: Graphics): void
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				//Write if-else to set the color
				if(maze[i][j]==0)
					g.setColor(Color.BLACK);
				else if(maze[i][j]==4)
					g.setColor(Color.LIGHT_GRAY);
				else
					g.setColor(Color.WHITE);
				//The first parameter is the x coordinate of the
				//top left corner of the rectangle to be drawn
				//The second parameter is the y coordinate of the
				//rectangle
				//The third and fourth coordinates are the width
				//and height of the rectangle respectively
				g.fillRect(j*(mazeWidth/maze[0].length)+40,
						i*(mazeHeight/maze.length)+30,
						mazeWidth/maze[0].length, 
						mazeHeight/maze.length);
				
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		wait = false;
	}

//	Implement method +reset(): void
//	Assign a random int between 1 and maze[0].length-2 
	//(both inclusive) to x
//	Assign a random int between 1 and maze.length-2 
	//(both inclusive) to y
//	Nested loops for (i,j) until all ints in the maze are 
	//assigned 0
	public void reset() {
		x = random.nextInt(maze[0].length-2)+1;
		y = random.nextInt(maze.length-2)+1;
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				maze[i][j]=0;
			}
		}
	}
	
	public void makePath(Stack<Rectangle> stack, int [][] maze,
			int j, int i) {
		if(i<=0 || j <= 0 || i >= maze.length-1 || 
				j>=maze[i].length-1)
			return;
		if(maze[i][j]==1 || maze[i][j]==4)
			return;
		maze[i][j]=4;
		stack.push(new Rectangle(i, j, mazeWidth/maze[0].length, 
				mazeHeight/maze.length));
		this.repaintAndDelay();
		int random1 = random.nextInt(4);
		if(random1==0) {
			moveLeft(i,j);
			moveUp(i,j);
			moveRight(i,j);
			moveDown(i,j);
		}
		else if(random1 == 1){
			moveUp(i,j);
			moveRight(i,j);
			moveDown(i,j);
			moveLeft(i,j);
		}
		else if(random1 == 2){
			moveRight(i,j);
			moveDown(i,j);
			moveLeft(i,j);
			moveUp(i,j);
		}
		else {
			moveDown(i,j);
			moveLeft(i,j);
			moveUp(i,j);
			moveRight(i,j);
		}
		if(!stack.isEmpty()){
			Rectangle rWall = stack.pop();
			maze[rWall.getX()][rWall.getY()] = 1;
			repaintAndDelay();
			if(!stack.isEmpty()){
				Rectangle rPath = stack.pop();
				maze[rPath.getX()][rPath.getY()] = 1;
				repaintAndDelay();
			}
		}	
//		If random1 is equal to 1
//			In the following order call moveUp, moveRight, moveDown and moveLeft, and pass i and j
//		If random1 is equal to 2
//			In the following order call moveRight, moveDown, moveLeft and moveUp, and pass i and j
//		If random1 is equal to 3

	}
	public void moveLeft(int i, int j){
		if(!(i<=0||i>=maze.length-1||j-2<=0||j-2>=maze[0].length-1||maze[i][j-2]==4||maze[i][j-2]==1)){
			maze[i][j-1]=4;
			stack.push(new Rectangle(i,j-1, mazeWidth/maze[0].length,mazeHeight/maze.length));
			repaintAndDelay();
			makePath(stack, maze, j-2, i);
		}
	}
	public void moveUp(int i, int j){
		if(!(i-2<=0||i-2>=maze.length-1||j<=0||j>=maze[0].length-1||maze[i-2][j]==4||maze[i-2][j]==1)){
			maze[i-1][j]=4;
			stack.push(new Rectangle(i-1,j, mazeWidth/maze[0].length,mazeHeight/maze.length));
			repaintAndDelay();
			makePath(stack, maze, j, i-2);
		}
	}
	public void moveRight(int i, int j){
		if(!(i<=0||i>=maze.length-1||j+2<=0||j+2>=maze[0].length-1||maze[i][j+2]==4||maze[i][j+2]==1)){
			maze[i][j+1]=4;
			stack.push(new Rectangle(i,j+1, mazeWidth/maze[0].length,mazeHeight/maze.length));
			repaintAndDelay();
			makePath(stack, maze, j+2, i);
		}
	}
	public void moveDown(int i, int j){
		if(!(i+2<=0||i+2>=maze.length-1||j<=0||j>=maze[0].length-1||maze[i+2][j]==4||maze[i+2][j]==1)){
			maze[i+1][j]=4;
			stack.push(new Rectangle(i+1,j, mazeWidth/maze[0].length,mazeHeight/maze.length));
			repaintAndDelay();
			makePath(stack, maze, j, i+2);
		}
	}

	public void repaintAndDelay(){
		repaint();
		try {
			Thread.sleep(MSECS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enqueue(){
		list=new MyLinkedList<>();
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				list.add(maze[i][j]);
			}
		}
		priorityQueue.add(list);
	}

	public void dequeue(){
		if(!priorityQueue.isEmpty())
			list = priorityQueue.remove();
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				maze[i][j]=list.removeFirst();			
			}
		}
	}

	public void makeOpenings(){
		if(random.nextInt(2)==0){
			int i1 = random.nextInt(maze.length-8)+4;
			int j1 = 0;
			int i2 = random.nextInt(maze.length-8)+4;
			int j2 = maze[0].length-1;
			while(maze[i1][j1]!=1){
				maze[i1][j1++]=1;
			}
			while(maze[i2][j2]!=1){
				maze[i2][j2--]=1;
			}
		}
		else{
			int i1 = 0;
			int j1 = random.nextInt(maze[0].length-8)+4;
			int i2 = maze.length-1;
			int j2 = random.nextInt(maze[0].length-8)+4;
			while(maze[i1][j1]!=1){
				maze[i1++][j1]=1;
			}
			while(maze[i2][j2]!=1){
				maze[i2--][j2]=1;
			}
		}
	}
	public void makeMultiplePaths(){
		//boolean done = false;
		for(int i = 0; i < maze.length /*&& !done*/; i++){
			for(int j = 0; j < maze[i].length /*&& !done*/; j++){
				if(!(i<=1||i>=maze.length-2||j<=1||j>=maze[i].length-2)){
					if(random.nextInt(100)==50){
						maze[i][j]=1;
					}
				}
			}
		}
	}
	public void writeMazeToFile(){
		File f = new File(System.getProperty("user.home")+File.separatorChar+"Desktop"
				+File.separatorChar+"maze_data"+File.separatorChar + fileName);
		PrintWriter output = null;
		try {
			output = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(maze.length);
		System.out.println(maze[0].length);
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				if(j<maze[i].length-1)
					output.print(maze[i][j]+" ");
				else
					output.print(maze[i][j]);
			}
			output.println();
		}
		if(output!=null)
			output.close();
		for(int i = 0; i < maze.length; i++){
			for(int j = 0; j < maze[i].length; j++){
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}



}
