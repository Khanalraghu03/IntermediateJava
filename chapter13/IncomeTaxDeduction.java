package chapter13;

public interface IncomeTaxDeduction {
	//By default all the variables must be constants 
		//and all methods must be abstract
	//public final static double TAX_RATE = 3.5;
	double TAX_RATE = 3.5;
	// public abstract double deductIncomeTax();
	public double deductIncomeTax();
}
