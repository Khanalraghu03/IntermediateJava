package review;

public class TestComputeArray {
	public static void main(String[] args) {
		//Create three objects
		ComputeArray obj1 = new ComputeArray();
		ComputeArray obj2 = new ComputeArray(15,20);
		ComputeArray obj3 = new ComputeArray(25,150);
		
		//obj1.contents //DONE
		//obj1.minValue //DONE
		//obj1.maxValue
		//obj1.avgValue
		
		System.out.println(obj1);
		System.out.println("The min value of object 1 is "+obj1.getMin());
		System.out.println("The max value of object 1 is "+obj1.getMax());
		System.out.println("The avg value of object 1 is "+obj1.getAvg());
		System.out.println();
		
		System.out.println(obj2);
		System.out.println("The min value of object 2 is "+obj2.getMin());
		System.out.println("The max value of object 2 is "+obj2.getMax());
		System.out.println("The avg value of object 2 is "+obj2.getAvg());
		System.out.println();
		
		System.out.println(obj3);
		System.out.println("The min value of object 3 is "+obj3.getMin());
		System.out.println("The max value of object 3 is "+obj3.getMax());
		System.out.println("The avg value of object 3 is "+obj3.getAvg());
		System.out.println();
	}
}