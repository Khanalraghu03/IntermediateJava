package practice.Ch13;

public class Ch13CheckPoints {

	
		public static void main(String[] args) {
//		Number num = new Integer(1);
		int num1 = 6;
		
		//Can cast primitive type into primitive type

		double dob2 = (double) num1;
		
		//Cannot cast Wrapper Class nor primitive type
			//into a Wrapper Class nor primitive type
			//Causes a runtime error: Integer cannot be cast to ...
//		Double doubleNum1 = (Double) num1;
//		Double doubleNum2 = (Double) num1; 
//		double dob = (double) num;
		
//		System.out.println(dob);
		System.out.println(dob2);
		
		/****************************************************/
		
		Integer[] numberArray = new Integer[2];
		//Type mismatch: cannot convert from Double to Integer
//		numberArray[0] = new Double(1.5); 
	
		/****************************************************/
		Number x = 3;
		System.out.println(x.intValue()); //3
		System.out.println(x.doubleValue()); //3.0
		/****************************************************/
		Number y = new Integer(3);
		System.out.println(y.intValue());
		//The method compareTo(Integer) is undefined for the type Number
			//It only exist in the Integer Class
		//And since x2 is of type Number, it only looks at what is in common between number and Integer
//		System.out.println(y.compareTo(new Integer(4))); 
		
		//	The method compareTo(Integer) is undefined for the type Number
//		System.out.println((Integer)y.compareTo(new Integer(4))); 		
		
		//This works
		System.out.println(((Integer)y).compareTo(new Integer(4))); 		
		//It worked because I am casting the type number to type Integer
	
		/****************************************************/
		
	
		
	}
	
		
	interface A {
		public void m1();
	}
	
	class B implements A {
		//cannot reduce visibility
//		void m1() {
		
		public void m1() {
			System.out.println("m1");
		}
	}

}
