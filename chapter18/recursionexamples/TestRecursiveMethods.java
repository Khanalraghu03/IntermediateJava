package chapter18.recursionexamples;

/**
 * @author Raghu Khanal
 *
 */

public class TestRecursiveMethods {
	public static void main(String[] args) {
		RecursiveMethods obj = new RecursiveMethods();
//		System.out.println(obj.fibonacci(9));
		System.out.println(obj.toString());
		obj.goldenRatioHelper();
		obj.decimalToBinaryHelper(); //Binary
		System.out.println();
		obj.fibonacciHelper();
		obj.searchHelper(); //false
	}

}
