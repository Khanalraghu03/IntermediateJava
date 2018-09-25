package chapter11;

public class Rectangle extends GeometricObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double rectangleWidth;
	private double rectangleHeight;
	
	public Rectangle() {
		this.rectangleWidth = 2.0;
		this.rectangleHeight = 1.0;
	}
	
	public Rectangle(double rectangleWidth, double rectangleHeight) {
		this.rectangleWidth = rectangleWidth;
		this.rectangleHeight = rectangleHeight;
	}
	
	public Rectangle(String color, boolean filled, double rectangleWidth, double rectangleHeight) {
		super(color, filled);
		//setColor(color);
		//setFilled(filled);
		this.rectangleWidth = rectangleWidth;
		this.rectangleHeight = rectangleHeight;
	}

	
	public double getRectangleWidth() {
		return rectangleWidth;
	}
	
	public void setRectangleWidth(double rectangleWidth) {
		this.rectangleWidth = rectangleWidth;
	}
	
	public double getRectangleHeight() {
		return rectangleHeight;
	}
	
	public void setRectangleHeight(double rectangleHeight) {
		this.rectangleHeight = rectangleHeight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rectangle [rectangleWidth=" + rectangleWidth + ", rectangleHeight=" + rectangleHeight + "]";
	}
	
	
	//getArea
	public double getArea() {
		return Math.PI * rectangleWidth * rectangleHeight;
	}
	
	//getPerimeter
	public double getPerimeter() {
		return 2 * (rectangleWidth + rectangleHeight);
	}
	
	//getDiagonal
	public double getDiagonal() {
		double diagonal = Math.sqrt(Math.pow(rectangleWidth, 2) 
				+ Math.sqrt(Math.pow(rectangleHeight, 2))); 
		return diagonal;
	}
	//getWindowWidth: int
	
	public int getWindowWidth() {
		return (int) (this.rectangleWidth * SCREEN_RESOLUTION) + 20;
	
	}
	
	//getWindowHeight: int
	public int getWindowHeight() {
		return (int) (this.rectangleHeight * SCREEN_RESOLUTION) + 20;
	}
	
	//drawGeometricObject: GeometricObject geometricObject
	public void drawGeometricObject(GeometricObject geometricObject) {
		super.drawGeometricObject(geometricObject);
	
	//	specify the bounds for the graphics object
//		
		int boundingBoxWidth = (int) (this.getWidth() * SCREEN_RESOLUTION);
		int boundingBoxHeight = (int) (this.getHeight() * SCREEN_RESOLUTION);
		
		//Check the filled attribute defined in the superclass and use the drawOval method to draw the circle
		if(!geometricObject.isFilled()) {
			//first and second args (x,y --> respectively): specifies the upper left corner of the object bounding box.
			//Position the object at the origin
			graphics.drawRect(10, 10, boundingBoxWidth, 
					boundingBoxHeight);
		}
		else {
			graphics.drawRect(10, 10, boundingBoxWidth, 
					boundingBoxHeight);
		}
	}
}