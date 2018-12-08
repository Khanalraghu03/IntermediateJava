package practice.ch19;

public class SuperWildCardDemo {
	public static void main(String[] args) {
	
		GenericClass<String> stack1 = new GenericClass<>();
		GenericClass<Object> stack2 = new GenericClass<>();
	
		stack2.push("Java");
		stack2.push(2);
		stack1.push("Sun");
		add(stack1,stack2);
		AnyWildCardDemo.print(stack2);
	
	}
	public static <T> void add1(GenericClass<String> stack1,
			GenericClass<? super Object> stack2) {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	} 
	
//	public static <T> void add(GenericClass<T> stack1,
//			GenericClass<? super T> stack2) {
//		while(!stack1.isEmpty()) {
//			stack2.push(stack1.pop());
//		}
//	} 
	public static <T> void add(GenericClass<? extends T> stack1,
			GenericClass<T> stack2) {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	} 
	
}
