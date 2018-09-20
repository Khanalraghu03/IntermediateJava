package accessModifier.package1;

public class Class3 extends Class1{
	
	//This class inherits class1
		int num1 = x;
		int num2 = y;
		int num3 = z;
//		int num4 = k; //Even if you extend class1, you don't have the access to private variables
		
		
		//Can also invoke protected method
		
		@Override
		protected void method() {
			// TODO Auto-generated method stub
			super.method();
		}
}
