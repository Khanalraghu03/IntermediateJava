/**
 * 
 */

package test1;


/**
 * @author: Raghu Khanal
 *
 */

public class Pentagon extends GeometricObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x1,x2,x3,x4,x5;
	private double y1,y2,y3,y4,y5;
	private int windowWidth;
	private int windowHeight;
	
	public Pentagon() {
		this(170,70,120,220,270,30,150,250,250,150,4,4);
	}
	public Pentagon(double x1,double x2, double x3, double x4, double x5, double y1,
			double y2,double y3,double y4, double y5, int windowWidth, int windowHeight) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.x5 = x5;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
		this.y5 = y5;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}
	public Pentagon(String color, boolean filled, double x1,double x2, double x3, double x4, double x5, double y1,
			double y2,double y3,double y4, double y5, int windowWidth, int windowHeight) {
		super(color,filled);
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.x4 = x4;
		this.x5 = x5;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.y4 = y4;
		this.y5 = y5;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}
	/**
	 * @return the x1
	 */
	public double getX1() {
		return x1;
	}
	/**
	 * @param x1 the x1 to set
	 */
	public void setX1(double x1) {
		this.x1 = x1;
	}
	/**
	 * @return the x2
	 */
	public double getX2() {
		return x2;
	}
	/**
	 * @param x2 the x2 to set
	 */
	public void setX2(double x2) {
		this.x2 = x2;
	}
	/**
	 * @return the x3
	 */
	public double getX3() {
		return x3;
	}
	/**
	 * @param x3 the x3 to set
	 */
	public void setX3(double x3) {
		this.x3 = x3;
	}
	/**
	 * @return the x4
	 */
	public double getX4() {
		return x4;
	}
	/**
	 * @param x4 the x4 to set
	 */
	public void setX4(double x4) {
		this.x4 = x4;
	}
	/**
	 * @return the x5
	 */
	public double getX5() {
		return x5;
	}
	/**
	 * @param x5 the x5 to set
	 */
	public void setX5(double x5) {
		this.x5 = x5;
	}
	/**
	 * @return the y1
	 */
	public double getY1() {
		return y1;
	}
	/**
	 * @param y1 the y1 to set
	 */
	public void setY1(double y1) {
		this.y1 = y1;
	}
	/**
	 * @return the y2
	 */
	public double getY2() {
		return y2;
	}
	/**
	 * @param y2 the y2 to set
	 */
	public void setY2(double y2) {
		this.y2 = y2;
	}
	/**
	 * @return the y3
	 */
	public double getY3() {
		return y3;
	}
	/**
	 * @param y3 the y3 to set
	 */
	public void setY3(double y3) {
		this.y3 = y3;
	}
	/**
	 * @return the y4
	 */
	public double getY4() {
		return y4;
	}
	/**
	 * @param y4 the y4 to set
	 */
	public void setY4(double y4) {
		this.y4 = y4;
	}
	/**
	 * @return the y5
	 */
	public double getY5() {
		return y5;
	}
	/**
	 * @param y5 the y5 to set
	 */
	public void setY5(double y5) {
		this.y5 = y5;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "Pentagon [x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4 + ", x5=" + x5 + ", y1=" + y1 + ", y2="
				+ y2 + ", y3=" + y3 + ", y4=" + y4 + ", y5=" + y5 + ", windowWidth=" + windowWidth + ", windowHeight="
				+ windowHeight + "]";
	}

	public int getWindowWidth() {
		return SCREEN_RESOLUTION * windowWidth;
	}
	
	public int getWindowHeight() {
		return SCREEN_RESOLUTION * windowHeight;
	}
	
	
	@Override
	public void drawGeometricObject(GeometricObject geometricObject) {
		super.drawGeometricObject(geometricObject);
	
	//	specify the bounds for the graphics object	
		int boundingBoxWidth = (int) (this.getWidth() * SCREEN_RESOLUTION);
		int boundingBoxHeight = (int) (this.getHeight() * SCREEN_RESOLUTION);
		
		
		int[] x = new int[5];
		x[0] = (int)x1;
		x[1] = (int)x2;
		x[2] = (int)x3;
		x[3] = (int)x4;
		x[4] = (int)x5;
		
		int[] y = new int[5];
		y[0] = (int)y1;
		y[1] = (int)y2;
		y[2] = (int)y3;
		y[3] = (int)y4;
		y[4] = (int)y5;
		//Check the filled attribute defined in the superclass and use the drawOval method to draw the circle
		if(!geometricObject.isFilled()) {
			//first and second args (x,y --> respectively): specifies the upper left corner of the object bounding box.
			//Position the object at the origin
			graphics.drawPolygon(x,y,5);
		}
		else {
			graphics.drawPolygon(x,y,5);
		}
		
	}
	
	public int getWindowAreaDifference(GeometricObject geometricObject) {
		return   this.getWindowArea() - geometricObject.getWindowArea();
	}

}