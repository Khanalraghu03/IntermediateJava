package practice.ch19;

import java.util.ArrayList;

import chapter11.Circle;
import chapter11.GeometricObject;
import chapter11.Rectangle;

public class ErasureANDRestrictions {
	public static void main(String[] args) {
		//19.8 a: Uses generics correctly then 
			//translates it into the equivalent
			//code in b for runtime use.
		ArrayList<String> list = new ArrayList<>();
		list.add("Oklahoma");
		String state = list.get(0);
		System.out.println(state);
		
		
		//b
//		ArrayList list = new ArrayList();
//		list.add("Oklahoma");
//		String state = (String)list.get(0);
//		System.out.println(state);
		
		/**********************************************/
		Object obj[] = {"Raghu", 5};
		printA(obj); //Compiler converts this
		printB(obj); 	//to this
		
		/**********************************************/
		
		Circle circle1 = new Circle(2);
		Rectangle rectangle1 = new Rectangle(2,2);
		
		System.out.println(equalArea(circle1, rectangle1));
		
		/**********************************************/
	}
	//Compiler replaces the generic type with the Object type.
	//"" converts the following method in (a) to (b)
	
	//a
	public static <E> void printA(E[] list) {
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i] + " ");
		}
		System.out.println();
	}
	
	//b
	public static void printB(Object[] list) {
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i] + " ");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	//If(generic => bounded) compiler replaces it with the bounded type
		//Compiler would convert method in (a) to (b)
	//a
//	public static <E extends GeometricObject>
//		boolean equalArea(E object1, E object2) {
//		return (object1.getArea() == object2.getArea());
//	}
	
	//b
	public static boolean equalArea(GeometricObject object1,
			GeometricObject object2) {
	return (object1.getArea() == object2.getArea());
}
	
	
}
