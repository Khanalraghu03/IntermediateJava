package chapter11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GeometricObject extends JPanel{
	/**
	 * 
	 */
	
	private String color;
	private boolean filled;
	private Date dateCreated;
	private JFrame frame;
	//Object reference to the window
		//Class members with protected modifier can be accessed from
		//classes within the same package and all subclasses even if
		//if they exist outside the package
	
	protected Graphics graphics;
	
	public static final int SCREEN_RESOLUTION = Toolkit.getDefaultToolkit().getScreenResolution();
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

	private static final long serialVersionUID = 1L;
	
	public GeometricObject() {
		this("white", false);
	}


	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
		this.dateCreated = new Date();
		//This will create a window with the class name as the title in the window
		this.frame = new JFrame(this.getClass().getSimpleName());
		/*We are adding this object to the frame because this object is an extension of JPanel
		* 		It will form the drawing canvas*/
		this.frame.add(this);
		this.frame.setSize(100,100);
		this.frame.setVisible(true);
		//Also the program should terminate when the window is closed
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
//	public Date getDateCreated() {
//		Date date = new Date();
//		return date;
//	}

	/**
	 * @return the filled
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * @param filled the filled to set
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GeometricObject [color=" + color 
				+ ", filled=" + filled 
				+ ", dateCreated=" 
				+ dateCreated 
				+ "]";
	}
	
	public void paintComponent(Graphics graphics) {
		/*
		 * awt: Abstract Window Toolkit, contains Java API for
		 * 		graphics and event handling such as button clicks, 
		 * 		mouse clicks are handled
		 * The paintComponent method is called when the Window is 
		 * 		created and by a background process that runs for any graphics component
		 * When this method is called it get passed a reference 
		 * 		to an object of java.awt.Graphics
		 * First step is to call the paintComponent method from the super class to clear any graphics objects.
		*/
		super.paintComponent(graphics);
		
		
		/* Assign the graphics object to the protected instance variable,
		 * 		so that it can be accessed in the subclasses */
		this.graphics = graphics;
		
		this.drawGeometricObject(this);
	}
	/* At this point the method is implemented to return a default value.
	 * The subclass will override this method with its own 
	 * 			implementation based on the dimensions of the graphics object */
	public int getWindowWidth() {
		return 100;
	}
	public int getWindowHeight() {
		return 100;
	}
	
	/* This method will provide general behaviors as setting up the graphics color and dimensions.
	 * It will be used by the overriding method in the subclass, which in turn will draw the object. */
	public void drawGeometricObject(GeometricObject geometricObject) {
		/*The compiler will bind the methods from this class but at run time 
		 * 		the method call will be bound to the overriding methods in the subclass
		 * 		that will provide the actual dimensions for the Window*/
		
		int windowWidth = this.getWindowWidth() + geometricObject.frame.getInsets().left
				+  geometricObject.frame.getInsets().right;
		int windowHeight = this.getWindowHeight() + geometricObject.frame.getInsets().top
				+  geometricObject.frame.getInsets().bottom;
		
		/* We need to check if the Window width and height is greater than the screen width and height.
		 * The default operation will be to terminate the program if the dimensions 
		 * 		(either width or height of the Window is greater than the screen width or height) */
		if(windowWidth > SCREEN_WIDTH || windowHeight > SCREEN_HEIGHT) {
			System.out.println("Window width or height is greater than " + "the screen width or height."
			+ "Terminating program...");
			System.exit(0);
		}
		geometricObject.frame.setSize(windowWidth, windowHeight);
		
		//Set the color on the graphics object as per the color attributes specified in the instance variable color.
		if(geometricObject.color.equalsIgnoreCase("white")) {
			geometricObject.graphics.setColor(Color.WHITE);
		}
		else if(geometricObject.color.equalsIgnoreCase("blue")) {
			geometricObject.graphics.setColor(Color.BLUE);
		}
		else if(geometricObject.color.equalsIgnoreCase("red")) {
			geometricObject.graphics.setColor(Color.RED);
		}
		else {
			geometricObject.graphics.setColor(Color.YELLOW);
		}
		
		
		
		
		
		
	}
	 
}
