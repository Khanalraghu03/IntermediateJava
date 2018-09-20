package practice.Ch10;

public class StringBuilderANDStringBuffer {
	//StringBuilder and StringBuffer Class are both similar to string
		//string is immutable but the two classes are not.
	public static void  main(String[] agrs) {
		/* StringBuilder and StringBuffer are more flexible than String. You can add,
		 * insert, or append new contents into StringBuilder and StringBuffer objects, whereas
		 * the value of a String object is fixed once the string is created. */
	
	
			//StringBuilder class is similar to StringBufffer except that the methods for modifying the buffer in 
					//StringBuffer are synchronized(only one task is allowed to execute the methods.
		//Use StringBuffer if the class might be accessed by multiple tasks concurrently because synchronization in this case to 
			//prevent corruption to StringBuffer.
		
		//Using String-Builder is more efficient if it is accessed by just a single tasks,
			//because no synchronization is needed.
		
		//Constructor for Both classes are almost same.
		
		//Modifying Strings in the StringBuilder page 393
	/*
	 * You can append new contents at the end of string builder
	 * insert new contents at a specified position in a string builder
	 * and delete or replace characters in a string builder using the methods.
	 * 
	 * */
		
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Welcome");
		stringBuilder.append(' ');
		stringBuilder.append("to");
		stringBuilder.append(' ');
		stringBuilder.append("Java");
		
		System.out.println(stringBuilder);
		
		stringBuilder.insert(11, "HTML and ");
		
		System.out.println(stringBuilder);
		
		stringBuilder.delete(8, 11);
		System.out.println(stringBuilder);
		
		stringBuilder.deleteCharAt(11);
		System.out.println(stringBuilder);
		
		stringBuilder.reverse();
		System.out.println(stringBuilder);
		
		stringBuilder.reverse();
		
		stringBuilder.replace(11, 15, "HTML");
		System.out.println(stringBuilder);
		
		
		stringBuilder.setCharAt(0, 'R');
		System.out.println(stringBuilder);
		
		
		
		
		
	}
}
