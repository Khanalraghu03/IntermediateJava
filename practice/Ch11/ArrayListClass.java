

import java.util.ArrayList;
import java.util.Date;

public class ArrayListClass {
	//An arrayList object can be used to store a list of objects
		//You can use array to store objects!
	//array[] size is fixed
	//Java provides the ArrayList class, which is used to store an unlimited objects.
			
			//public ArrayList() ==> creates an empty list
			
			//Methods
				//add(o: E) ==> new element o at the end of this list
				//add(index, o)
				//clear()
				//contains
				//get
				//indexOf
				//isEmpty()
				//lastIndexOf(o)
				//remove()
				
			//public size() : int
			//public remove(index): boolean
			//public set()
			
	//ArrayList is known as a generic class with a generic type E.
	
	ArrayList<String> city1 = new ArrayList<String>(); //simplifies to:
	ArrayList<String> city = new ArrayList<>(); //Store Strings
	//Thanks to the feature called interface: the String is no longer required in the constructor
		//Interface introduces to the concept of Generics: which is discussed more in ch. 19
	
	ArrayList<Date> dates = new ArrayList<>(); //Stores dates
	
	

}
