package practice.Ch10;

import java.math.BigInteger;
import java.math.BigDecimal;


public class BigIntegerANDDecimal {
	//java.math package
	//Use this class(es) for the purpose for any size and precision
	
	//Both classes are -->Immutable: it cannot be changed once it's created
	//use new BigInteger(String) || new BigDecimal(String)
	public static void main(String[] args) {
		//Big Integers
		BigInteger x = new BigInteger("99999999999");
		BigInteger y = new BigInteger("2");
//		BigInteger z = x * y; //Cannot do this
		BigInteger z = x.multiply(y); //must do this: multiplies x times y
		System.out.println(z); //prints the value of x * y: 199999999998
		
//		BigInteger x2 = new BigInteger(999999999); //Cannot do this: must be a string
	
		//Big Decimals
		BigDecimal a = new BigDecimal(1.0); //Can be double
		BigDecimal b = new BigDecimal("3.0"); //Can use string
		
		//divide a by b, give me 20 decimal value- when you get to the end round the last value up.
		BigDecimal c = a.divide(b, 20, BigDecimal.ROUND_UP);
		System.out.println("The 20 decimal values " + c);
		
	}
}
