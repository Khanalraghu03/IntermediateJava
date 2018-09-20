package practice.Ch10;

public class ConvertingPrimitiveAndWrapper {
	/* Primitive type can automatically be converted to an object
	 * using wrapper class and vice versa, depending on the context*/
	
	//Boxing: converting a primitive type to wrapper object
	//Unboxing: reverse conversion
	//Compiler automatically box a primitive type an unbox an object that appears in a context requiring a primitive value.
		//this is called autoboxing and autounboxing
	
	public static void main(String[] args) {
		
	//Example
	Integer intObj = new Integer(2);
	
	//Simplified version of intObj would be:
	Integer intObjet = 2;  //Autoboxing
	
	//They are equivalent
	System.out.println(intObj.compareTo(intObjet)); //Returns 0
	
	
	
	Integer[] intArray = {1 ,2 ,3}; //autoboxing
	System.out.println(intArray[0] +intArray[1]+intArray[2]); //autounboxing
	
	Integer[] intArray1 = {new Integer(1), new Integer(2) , new Integer(3)}; //boxing
	System.out.println(intArray1[0] +intArray1[1]+intArray1[2]); //autounboxing
	
	//intArray and intArray1 are equivalent
	
	
	//autoboxing is compiler box primitive value as object automatically
	//autounboxing is when compiler unbox an object automatically
	
	
	//Quick Check
	Integer x = 3 + new Integer(5); //3 will be boxed automatically by the compiler while 5 does not since it is already boxed
	System.out.println(x); //outputs 8
	
//	Integer x2 = 3; //Three is automatically boxed by the compiler
	
	Integer y = new Integer(3); //Three is not boxed by the compiler, it has already been done by the user.
	System.out.println(y);
	
	int y2 = new Integer(3); //int is automitically boxed by the compiler as Integer, rest is just the way it should be
	System.out.println(y2); //outputs 3
	
	int y3 = new Integer(3) + new Integer(4); //same story as above, just adds 3 + 7
	System.out.println(y3); //Outputs 3+4 = 7
	
	Double d = 3.5;
	System.out.println(d.intValue()); //outputs 3
	System.out.println(d.compareTo(4.5)); //Outputs -1 because 3.5 is less than 4.5: make sure to compare same primitive values (double w/ double ...)
	
	}
}
