package chapter11;
 
import java.util.ArrayList;


public class TestGeometricObject {
	public static void main(String[] args) {
	//		GeometricObject geometricObject = new Circle("blue",true, 2.0);
	//		System.out.println(geometricObject + "\n");
			
	//		Circle circle1 = new Circle();
	//		System.out.println("The circle1 " + circle1.toString());
	//		System.out.println("The color of circle1 is " + circle1.getColor());
	//		System.out.println("The radius of circle1 is: " + circle1.getRadius());
	//		System.out.println("The Area of circle1 is " + circle1.getArea());
	//		System.out.println("The parameter of circle1 is " + circle1.getPerimeter());
	//		System.out.println("The diameter of circle1 is " + circle1.getDiameter());
	//		System.out.println("The window height of circle1 is " + circle1.getWindowHeight());
	//		System.out.println("The window width of circle1 is " + circle1.getWindowWidth());
	//		
	//		Rectangle rectangle1 = new Rectangle();
	//		System.out.println("\nThe rectangle1 " + rectangle1.toString());
	//		System.out.println("the color is " + rectangle1.getColor());
	//		System.out.println("The area is " + rectangle1.getArea());
	//		System.out.println("The parameter is " + rectangle1.getPerimeter());
	//		System.out.println("The diagonal is "+ rectangle1.getDiagonal());
	//		System.out.println("The rectangle height is "+ rectangle1.getHeight());
	//		System.out.println("The rectangle width is "+ rectangle1.getWidth());
	//		System.out.println("The window width of rectangle1 is " + rectangle1.getWindowWidth());
	//		System.out.println("The window height of rectangle1 is " + rectangle1.getWindowHeight());
			
			ArrayList<GeometricObject> objHolder = new ArrayList<GeometricObject>(5);
			//Assign object to the objectHolder array
			//3 circle
			for(int i = 0; i < 3; i++) {
				objHolder.add(new Circle("blue",true,2.0));
			}
			//2 rectangle
			for(int i = 3; i < 5; i++) {
				objHolder.add(new Rectangle("red",true,3.0,2.0));
			}
			
			//Print all the object
			for(int i = 0; i< objHolder.size(); i++) {
				System.out.println(objHolder.get(i).toString());	
				
				
			objHolder.get(i).setColor("RED");
			objHolder.get(i).repaint();
			try {
				Thread.sleep(1000);  //1000milli second = 1 sec
			}
			 catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}	
	}	
}