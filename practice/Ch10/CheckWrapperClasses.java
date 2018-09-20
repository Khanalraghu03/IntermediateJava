package practice.Ch10;

public class CheckWrapperClasses {
	public static void main(String[] args) {
		
		Integer num = new Integer("40"); 		//The parameter cannot be empty: it can be an integer or a string.
		System.out.println(num.intValue()); 	//Prints the string value into primitive type: int
		System.out.println(num.doubleValue());	//Prints the String value that was stored in Integer num and returns it as a double.
		
		Integer i = Integer.valueOf("23");   //valueOf returns a primitive value
		System.out.println("i is " + i);
		
		Integer j = Integer.parseInt("23", 8); //Converts decimal num to Octal num
		System.out.println("The octal value 23 converts to  " +j + " as a decimal.");
		
//		Double d = new Double(); //This doesn't compile because a wrapper class requires an argument.
				
		Double d2 = Double.valueOf("23.45");
		System.out.println(d2); //outputs in the double primitive type.
		
		
		int k = (Integer.valueOf("23").intValue());
		System.out.println(k); //returns 23
		
		
		
		int multipliable = k * 9;
		System.out.println(multipliable); //Returns 207
		
		int l = (Integer.valueOf("23"));
		System.out.println(l); 		//Returns 23
		int multipliable2 = l * 9;
		System.out.println(multipliable2); //Returns 207
		
		
		String s = (Double.valueOf("23.4").toString());
		System.out.println(s);
//		double val = (double )2.4 * s; cannot multiply double w/ string, even though string is a number.
		
		
		//Practice
		Integer x = new Integer(3);
		System.out.println(x.intValue()); //returns 3
		System.out.println(x.compareTo(new Integer(4))); // returns -1
	
		//Parsing 
		System.out.println("Parshing Integers\n");
		System.out.println(Integer.parseInt("10")); //Returns 10
		System.out.println(Integer.parseInt("10", 10));	//Returns 10
		
		//Convert the 10 which is in Hexa format to decimal.
		System.out.println(Integer.parseInt("10", 16)); //Returns 16+0 = 16
		
		System.out.println(Integer.parseInt("1A", 16)); //Returns 16+10 = 26
		System.out.println(Integer.parseInt("11")); //Returns 11
		System.out.println(Integer.parseInt("11",10)); //Returns 11
		System.out.println(Integer.parseInt("11", 16)); //Returns 16+1 = 17
		
	
	
	
	
	
	
	}
}
