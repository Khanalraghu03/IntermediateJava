package practice.Ch11;

class A {
	public A(int x) {
		
	}
	
	//This solves the problem
	public A() {
		
	}
}

class B extends A {
	public B() { //requires an argument 
		//super(); is given by java for free so
//			it look for default constructor in class A
//					since there is no default constructor, the program 
//				cannot be compiled
	}
	
}

class C {
	public static void main(String[] args) {
		new B();
	}
}