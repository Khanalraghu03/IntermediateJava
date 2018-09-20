package accessModifier.package1;

//This class creates an object of Class1 to see the access it has
public class Class2 {
	public static void main(String[] args) {
	//creates a class object
	Class1 obj = new Class1();
	
	int num1 = obj.x; //Can access x: it is public
	int num2 = obj.y; //Can access y: it is protected
	int num3 = obj.z; //can access z: it has no modifier
//	int num4 = 4 * obj.k; //cannot access k: it is private (only class1 has access to it)
	
	//Note: Class1 is in the same package
		//Thus public,private, and no modifier can be accessed
	
	obj.method(); //can even invoke the protected method ==> prints "Hello"
	
	System.out.println(num1 + " " + num2 + " " + num3);
	
	}
}