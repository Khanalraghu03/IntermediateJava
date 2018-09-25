package chapter11;

public class Circle extends GeometricObject {
	private double radius;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Circle() {
		super();
		//provide 1.0 as the default value for the radius
		this.radius = 1.0;
	}
	
	/**
	 * @param radius
	 */
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(String color, boolean filled, double radius) {
		//Calls the two argument constructor in the super class
		super(color, filled);
		//setColor(color);
		//setFilled(filled);
		this.radius = radius;
	}

	//Getters and Setters
	
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", toString()=" 
					+ super.toString() + "]";
	}
	
	//Get Area
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	//Get Perimeter
	public double getPerimeter() {
		return (2 * Math.PI * this.radius);
	}
	
	//getDiameter
	public double getDiameter() {
		return (2 * this.radius);
	}
	
	//Compute the windowWidth (and height)based on the radius and the screen resolution.
	//Window width and height should represent the number of pixels
	public int getWindowWidth() {
		return (int) (2* this.radius * SCREEN_RESOLUTION) + 10;
	}
	
	public int getWindowHeight() {
		return (int) (2* this.radius * SCREEN_RESOLUTION) + 10;
	}
	
	public void drawGeometricObject(GeometricObject geometricObject) {
		//specify the bounds for the graphics object
		super.drawGeometricObject(geometricObject);
		int boundingBoxWidth = (int) (2* this.radius * SCREEN_RESOLUTION);
		int boundingBoxHeight = (int) (2* this.radius * SCREEN_RESOLUTION);
		
		//Check the filled attribute defined in the superclass and use the drawOval method to draw the circle
		if(!geometricObject.isFilled()) {
			//first and second args (x,y --> respectively): specifies the upper left corner of the object bounding box.
			//Position the object at the origin
			graphics.drawOval(5, 5, boundingBoxWidth, 
					boundingBoxHeight);
		}
		else {
			graphics.fillOval(5, 5, boundingBoxWidth, 
					boundingBoxHeight);
		}	
	}
}