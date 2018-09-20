package practice.Ch11;

public class Ch11Override {
	private double radius;
	//Must have a default constructor
	
	public Ch11Override() {
		this.radius = 0;
	}
	
	public Ch11Override(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}

class R extends Ch11Override {
	private double length;
	
	R(double radius, double length) {
		//super() is called -- A constructor w/ default constructor
//		Ch11Override(radius); //This needs to be super instead of the class name
		super(radius);
		this.length = length;
	}
	
	@Override
	public double getArea() {
		return getArea() * length;
	}
	
	public static void main(String[] args) {
		
	}
}

