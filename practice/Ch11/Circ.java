package practice.Ch11;

public class Circ {
	double radius;
	
	public boolean equals(Object circle) {
		return this.radius == ((Circ)circle).radius;
	}
	
	//Incorrect Way to write the equals is by using subclass:
	/*
	 * public boolean equals(Circ circle) {
	 * return this.radius == circle.radius;
	}
	*/
	
	
}
