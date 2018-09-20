package practice.Ch11;

import chapter11.Circle;

public class ObjectEqualMethod {
	private double radius;
	//just as toString method is useful, there is another method in java: equals()
	
	//public boolean equals(Object o)
		//Checks whether two object are the equal
		//object1.equals(object2);
	
	/*
	 * The default implementation of the equals method in the Object class is:
	 * public boolean equals(Object obj) {
	 * return (this == obj);}
	 * 
	 * The equals method is overridden in many classes in the Java API, such as java.lang.String
	 *  and java.util.Date, to compare whether the contents of two objects are equal.
	 *  
	 *  The equals method in the String class is inherited from the Object class
	 *  and is overridden in the String class to test whether two strings are identical in content.
	*/

	public boolean equals(Object o) {
		if (o instanceof Circle)
		return this.radius == ((Circle)o).getRadius();
		else
		return this == o;
		}
}


