package practice.ch19;




import chapter11.Circle;
import chapter11.GeometricObject;
import chapter11.Rectangle;

public class BoundedTypeDemo {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(2,2);
		
		Circle circle = new Circle(2);
		
		System.out.println("Same area? " + equalArea(rectangle, circle));
		
	}

	private static <E extends GeometricObject> boolean equalArea(E obj1, E obj2) {
		// TODO Auto-generated method stub
		return obj1.getArea() == obj2.getArea();
	}

}
