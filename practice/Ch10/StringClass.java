package practice.Ch10;

//import java.math.BigInteger;

public class StringClass {
	//String object is immutable: it's content cannot be changed one the string is created.
	
		public static void main(String[] arga) {
			//You can create a string object from string literal or from an array of characters
			//To create a string literal, use the syntax:
			String message = new String("Welcome to Java"); 
			System.out.println(message);
			
			//OR you could create an array like this
			char[] charArray = {'H','E','L','L','O'};
			String message1 = new String(charArray); //The parameter is able to combine all the char[] together and stick it into one message1.
			System.out.println(message1);
			
//			String message2 = charArray; //This won't work
//			String message2 = "" + charArray; //Error on purpose
//			System.out.println("This is message 2: " + message2); //Prints location
			
			String message3 = charArray.toString(); 
			System.out.println("This is message 3: " + message3); //Even this prints location as well
			
			//Which brings us to
			char[] hWorld = "Hello World".toCharArray(); //Breaks down "Hello World" to array of letters
			System.out.println(hWorld[0]); //This prints the First letter, which is H in this case.
			
			/////////////////////////////     More on this? skip to line  114     /////////////////////////////
			
//Immutable and Interned Strings
			String s = "Java";
			s = "HTML";
			System.out.println(s);
			
			//First statement created s and assigned "Java"
			//Second statement created s and assigned "HTML"
			//The "Java" still exist but is no longer 
				//accessible since the reference for s has been changed.
			//Thus String object is immutable
			
//Interned Strings: a way for JVM to save memory and provide efficiency 
			String s1 = "Welcome to Java";
			String s2 = new String("Welcome to Java");
			String s3 = "Welcome to Java";
			String s4 = new String("Welcome to Java");
			
			System.out.println("s1 == s2 " + (s1 == s2)); //false
			System.out.println("s1 == s2 " + (s1 == s3)); //true
			System.out.println("s2 == s4 " + (s2 == s4)); //false
			
			//false: s2 is a string object and has a different reference than s1 which is a Interned string object
			//true: s1 and s3 are both Interned string objects and JVM gives it the same reference for s1 and s3.
			//false: even though are both string object, they are two different object with two different reference
			
			Integer n = 4;
			Integer n2 = new Integer(4);
			System.out.println();
			System.out.println(n == n2); //This is also false
			
			String a = "Welcome".replace('e', 'A');
			System.out.println(a);
			
			String b = "Welcome".replaceFirst("e", "AB");
			System.out.println(b);
			
			String c = "Welcome".replace("e", "AB");
			System.out.println(c);
			
			String d = "Welcome".replace("el", "AB");
			System.out.println(d);
		
			//Split: splits strings from the specified value(s)
			String[] tokens = "Java#HTML#Perl".split("#");
			for(int i = 0; i < tokens.length; i++) {
				System.out.print(tokens[i] + " ");
			} 
			
			//To validate users input: use a regular expression(regex)
				//Regular Expression(regex): string that describes a pattern for matching a set of strings.
			//You can match, replace, or split a string by specifying a pattern.
			
//Matches method
				//very similar to equals method
			System.out.println();
			System.out.println("Java".matches("Java")); //true
			System.out.println("Java".equals("Java"));  //true
			
			//Matches is more powerful: it not only matches a fixed string, also a 
					//set of string that follow a pattern.
			System.out.println();
			System.out.println("Java is fun".matches("Java.*")); //true
			System.out.println("Java is cool".matches("Java.*")); //true
			System.out.println("Java is powerful".matches("Java.*")); //true
			//"Java.*" means match the statement that start with Java followed by any zero or more characters.
			
			System.out.println();
			//To validate a social security number
			System.out.println("440-02-4534".matches("\\d{3}-\\d{2}-\\d{4}")); //true
			// Here \\d represents a single digit and \\d{3} represents three digits
			
			String z = "a+b$#c".replaceAll("[$+#]", "NNN");
			System.out.println(z); //returns aNNNbNNNNNNc
			
			String[] token = "Java,C.?C#;,C++".split("[.,:;?]");
			for(int i = 0; i < token.length; i++) {
				System.out.print(token[i] + " ");
			}
			
//Conversion between Strings and Arrays
			//Strings are not arrays, but a string can be converted into an array, and vice versa.
				//To convert a string into an array of characters:
						//Use the toCharArray() method
			
			char[] chars = "Java".toCharArray();
			System.out.println("\n");
			System.out.println(chars[0] + " " + chars[1] 
					+ " " + chars[2] + " " + chars[3] );
			
			String st1 = new String(chars);
			System.out.println(st1);  //Returns the good old "Java" back
			
//			String st2 = new String(new char[] {"Raghu"}); //Can't work
			
			//Create new String object with array of chars to convert from char to String
			String st2 = new String(new char[] {'R', 'A','G','H','U'});
			System.out.println(st2); //Prints RAGHU
			
			//You could also use valueOf method
			String st3 = String.valueOf(new char[] {'R', 'A','G','H','U'});
			System.out.println(st3);
			
			
			
			
//Converting numeric value to string
			int num1 = 5;
			String stringNum1 = "" + num1; //I can not only do this with int but also double, char, etc.
			System.out.println(stringNum1);
			
			//
			
	//Converting String to Numeric value	
			double dNum= Double.parseDouble("33.77"); 
			System.out.println(dNum);
			
			//Gives NumberFormatException error
//			Double dNum2 = new Double("ONE"); 
//			Integer intNu4 = Integer.parseInt("3333.5"); //Doesn't round up or round down

			
	//Converting Numeric value to String	
			String strr = String.valueOf(444.0);
			System.out.println(strr);
			
//			String strrr = String.valueOf(new BigInteger(483933333333333333333333333333333333333333333333333)); //Literal Out of Bound Execption
			
			String strrrr = String.valueOf(5555);
			System.out.println(strrrr);
			
//Formatting String			
	//String.format(format, item1, item 2, ..., itemN)
	//String("%d", 3.3)
			//Similar to printf
				//format() returns a formatted string whereas printf prints a formatted string
			String fString = String.format("%7.2f%6d%-4s", 45.556,14,"AB");
			System.out.println(fString);
			
	//.printf() == .print(String.format()) 
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			String sss = "Welcome to the good old Java  co co co ".replaceAll("co", "Ho");
			System.out.println(sss);
			
			String ssss = "Welcome ho".replace("ho", "hoooooo"); 
			System.out.println(ssss);
			
		}
		
}
