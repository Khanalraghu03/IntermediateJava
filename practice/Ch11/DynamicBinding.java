package practice.Ch11;

public class DynamicBinding {
	public static void main(String[] agrs) {
		//Creates a new Object w/out using a variable
		m(new GraduateStudent());
		m(new Student());
		m(new Perrson());
		m(new Object());
	}
	
	//Create a method m that holds Object x
	public static void m(Object x) {
		//Print the objects toString() method
		System.out.println(x.toString());
	}
}






	class GraduateStudent extends Student {
		//super() free-bee given by java, which goes to the Student constructor if any
		
	}
	class Student extends Perrson {
		
		@Override
		public String toString() {
			return "Student";
		}
	}
	class Perrson extends Object{
		@Override
		public String toString() {
		return "Person";
		}
	}

