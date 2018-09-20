package accessModifier.package2;

import accessModifier.package1.Class1;

public class Class4 extends Class1{
	//To extend an class from different package you must import it
	
	//This class inherits class1
			int num1 = x;
			int num2 = y;
			
//			int num3 = z; cannot access the no modifier class even if you extend it. It is package protected
			
//			int num4 = k; //Even if you extend class1, you don't have the access to private variables
			
			
//			Can also invoke protected method because it is a subclass of class1
			@Override
			protected void method() {
				// TODO Auto-generated method stub
				super.method();
			}
			
			
//			Cannot access the no modifier method as well: only package1 has the access to it
//			void method2() {
//				super.method2();
//			}

}