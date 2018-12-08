package chapter18.recursionexamples;

import java.util.Arrays;

/**
 * @author Raghu Khanal
 *
 */

public class RecursiveMethods {
	private int[] computeArray;
	private int n;
	private int order;
	
	public RecursiveMethods() {
		computeArray = new int[10];
		for(int i = 0; i < computeArray.length; i++) {
			computeArray[i] = (int) Math.floor(Math.random() * 100);
		}
		
		n = (int) Math.floor(Math.random() * 10);
		order = (int) Math.floor(Math.random() * 10);
		
	}

	/**
	 * @return the computeArray
	 */
	public int[] getComputeArray() {
		return computeArray;
	}

	/**
	 * @param computeArray the computeArray to set
	 */
	public void setComputeArray(int[] computeArray) {
		this.computeArray = computeArray;
	}

	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RecursiveMethods [computeArray=" + Arrays.toString(computeArray) + ", n=" + n + ", order=" + order
				+ "]";
	}
	
	public int fibonacci(int n) {
		
		if(n <= 0) //Base Case
			return 0;
		
		
		else if(n == 1) //Base Case
			return 1;
		
		
		else //Recursive Case
			return fibonacci(n -1) * fibonacci(n -2);
		
	}

	public void fibonacciHelper() {
		System.out.println(fibonacci(n));
	}

	public int goldenRatio(int n) {
		if(n == 0) {
			return 1;
		}
		else if(n > 0) {
			return 1 + (1/(goldenRatio(n-1)));
		}
		else
			return -1;
	}
	public void goldenRatioHelper() {
		System.out.println(goldenRatio(n));
	}

	public void decimalToBinary(int decimal){
		if(decimal == 0) {
			System.out.print(0);
			return;
		}
		else if(decimal == 1) {
			System.out.print(1);
			return;
		}
		else
			decimalToBinary(decimal/2);
			System.out.print(decimal%2);
	}
	public void decimalToBinaryHelper() {
		decimalToBinary(n);
	}

	public boolean search(int[] a, int n, int key) {
		if(n == 0) {
			return false;
		}
		else if(a[n -1] == key) {
			return true;
		}
		else
			return search(a, n -1, key);
	}

	public void searchHelper() {
		System.out.println(search(computeArray,computeArray.length, this.order));
	}

}
