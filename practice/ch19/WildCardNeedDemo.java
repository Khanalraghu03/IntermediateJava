package practice.ch19;

public class WildCardNeedDemo {
	public static void main(String[] args) {
		GenericClass<Integer> intStack = new GenericClass<>();
		
		intStack.push(1);
		intStack.push(2);
		intStack.push(-2);
//		max(intStack);
		
		System.out.println("The max num is " 
				+ max(intStack));
	}
	
	public static double max(GenericClass<? extends Number> stack) {
		double max = stack.pop().doubleValue();
		
		while(!stack.isEmpty()) {
			double value = stack.pop().doubleValue();
			if(value > max)
				max = value;
		}
		return max;
	}
}
