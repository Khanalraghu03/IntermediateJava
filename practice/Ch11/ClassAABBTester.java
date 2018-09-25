package practice.Ch11;

public class ClassAABBTester {
	public static void main(String[] args) {
		ClassAA a = new ClassBB();
//		ClassBB b = new ClassAA(); //Must do (ClassBB)
		ClassAA c = new ClassAA();
		a = c;
		c = a; 
		
		
	}
}
