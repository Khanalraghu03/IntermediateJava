package practice.Ch12;

public class ErrorCheck {
	public static void main(String[] args)
	{
		String s = "abc";
	//		System.out.println(s.charAt(3)); //StringIndexOutOfBoundsException
		
		int[] list = new int[5];
	//	System.out.println(list[5]); //ArrayIndexOutOfBoundsException
		
		Object obj = new Object();
	//	String a = (String)obj;  //ClassCastException
	
		Object o = null; 
	//	System.out.println(o.toString()); //NullPointerException
	
		
		System.out.println(1.0/0); // Infinity
		System.out.println(0.0/0); // NaN
		System.out.println(-1.0/0); // -Infinity
		
//		System.out.println(1/0); //ArithmeticException
//		System.out.println(0/0); //ArithmeticException
//		System.out.println(-1/0); //ArithmeticException

		System.out.println(1/0.0); // Infinity
		System.out.println(0/0.0); // NaN
		System.out.println(-1/0.0); // -Infinity
		
		String nnull;
//		System.out.println(nnull + "Hello"); //Error. Unresolved compilation problem
	
	
	}
}
