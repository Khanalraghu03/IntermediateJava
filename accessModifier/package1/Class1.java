package accessModifier.package1;

public class Class1 {
	//Access Modifiers:
	//Public, Protected, No-modifier(Package-Protected), Private
	
	//Types of Modifiers in action
	public int x = 4;
	protected int y = 6;
	int z = 9;
	private int k = 1997;
	
	protected void method() {
		System.out.println("I am a Protected Method");
	}
	
	void method2() {
		System.out.println("I am a No modifier Method");
	}
}

//Class1 has all the ingredients
	//Has access to all the modifiers: Public, Protected, no-modifier(package-protected), and even Private (Duh! right?)
	//Only this class has access to private data and methods

//Class2 : Creates an instance of Class1 from the same package (package1)
	//uses Class1 to it's advantage by creating object(it is not changing stuff or adding to Class1)
	//is creating an object of Class1 to get the ingredients
	//Class2 is in the same package but not in the same class
	//Class2 has the access to all the public,protected, and package-protected(no modifier)
	//Class2 cannot access the private data, and methods

//Class3 defines Class1 by extending it from the same package (package1)
	//extending the Class1 to change or add stuff around
	//Class3 doesn't have the access to the private data nor methods only class1 has the access to it.
	//Class3 has the access to Public,Protected, and Package-Protected(no modifier)
		//because it is in the same package and it is a subclass.

//Class4 defines Class1 by extending it from a different package (package2)
	//is also extending the Class1 to change or add stuff around
	//The difference between Class3 and Class4 is that
		//Class4 is in a different package
	//Thus:
		//Class4 has the access to the Public
		//And Protected: because it is the subclass of Class1
	//It doesn't have't have the access to the no modifier because it is package-protected
		//Which means only the package 1 has the access to Class1

//Class5 creates an Instance of Class1 from a different package (package2)
	//uses Class1 to it's advantage by creating object(it is not changing stuff or adding to Class1)
	//Because Class5 is not extending Class1: it is no a subclass of Class1
		//Thus it doesn't have the access to the class1 protected variables
			//Class5 definitely doesn't have the access to no modifier because it is in different package from Class1
				//Do I have to talk about the private..?
	//So class5 only has the access to the public data and methods





