package practice.Ch11;

import java.util.ArrayList;

public class ArrayvsArrayList {
	/*
	 * String[] list = new String[10]; 
	 * 		==> ArrayList<String> list = new ArrayList<>(5); //putting 5 in the parameter is not necessary
	 * 
	 * list[index] ==> list.get(index);
	 * list[index] = "London"; ==> list.set(index, "London");
	 * list.length ==> list.size()
	 * 
	 * Thats mostly what you get with arrays
	 * 		But with ArrayList you get so much more:
	 * list.add("London");
	 * list.add(index,"London");
	 * list.remove(index);
	 * list.remove(Object);
	 * list.clear();
	*/

	//To get() and set() is not usable if there is no element in the list.
	
	//To sort an array use Array.sort(array)
	//In ArrayList use Collections.sort(arrayList) method
	
//	ArrayList<int> num1= new ArrayList<>(); //Syntax error
		//ArrayList must be a of an Object type
			//primitive data type is not allowed to replace a generic type.
	//However:
	ArrayList<Integer> num= new ArrayList<>(); //this will work because Integer is a Class
}
