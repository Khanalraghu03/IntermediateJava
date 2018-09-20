package accessModifier.package2;

import accessModifier.package1.Class1;

public class Class5 {
	//To create an object from different package's class you must import it
		Class1 obj = new Class1();
		
		int num1 = obj.x; //Can access x: it is public
		
		
//		int num2 = obj.y; //Cannot access y: it is protected: only subclass has the access
		
//		int num3 = obj.z; //cannot access z: it has no modifier: it is package protected
		
//		int num4 = 4 * obj.k; //cannot access k: it is private (only class1 has access to it)
		
		//Note: Class1 is in the same package
			//Thus public,private, and no modifier can be accessed
		
		
//		obj.method(); //Only subclass has the access to it
//		obj.method2(); //Only the package1 has the access to it
	
}