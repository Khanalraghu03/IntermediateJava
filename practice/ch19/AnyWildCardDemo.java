package practice.ch19;

public class AnyWildCardDemo {
	public static void main(String[] args) {
		
		GenericClass<Integer> intStack = new GenericClass<>();
		intStack.push(1);
		intStack.push(2);
		intStack.push(-2);
		
		print(intStack);
	}
		public static void print(GenericClass <?> stack) {
			while(!stack.isEmpty()) 
				System.out.println(stack.pop()+ " ");
			
			
		}

}
