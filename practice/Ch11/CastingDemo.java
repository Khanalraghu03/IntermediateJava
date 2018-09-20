package practice.Ch11;

import chapter11.Circle;
import chapter11.Rectangle;

public class CastingDemo {
	public static void main(String[] args) {
		Object object1 = new Circle();
		Object object2 = new Rectangle();
		
		displayObject(object1);
		displayObject(object2);
	}
	public static void displayObject(Object object) {
		if(object instanceof Circle) {
			System.out.println("The circle area is "
					+((Circle)object).getArea());
			System.out.println("The circle diameter is "
					+ ((Circle)object).getDiameter());
		}
		else if(object instanceof Rectangle) {
			System.out.println("The rectangle area is "
					+ ((Rectangle)object).getArea());
		}
	}
}
