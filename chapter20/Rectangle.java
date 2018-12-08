package chapter20;

public class Rectangle implements Comparable <Rectangle>{
	private int x;
	private int y;
	private int height;
	private int width;
	
	public Rectangle(int x, int y, int height, int width){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + ", height=" 
								+ height + ", width=" + width + "]";
	}
	@Override
	public int compareTo(Rectangle r) {
		if(this.height*this.width > r.height*r.width)
			return 1;
		else if(this.height*this.width == r.height*r.width)
			return 0;
		else 
			return -1;
	}
}
