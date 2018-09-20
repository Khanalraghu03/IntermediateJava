package review;

import java.util.Arrays;
import java.util.Random;

public class ComputeArray {
	private int[] list;
	
	public ComputeArray() {
		list = new int[10];
		Random randomNumber = new Random();
		for(int i = 0; i < list.length; i++) {
			//Generate random int and assign the value to the array
			list[i] = randomNumber.nextInt(100);
		}
	}
	public ComputeArray(int lengthOfArray, int upperLimit) {
		list = new int[lengthOfArray];
		Random randomNumber = new Random();
		for(int i = 0; i < list.length; i++) {
			//Generates random number of the limit user provides in the main method
			//Assigns the random value to the array 
			list[i] = randomNumber.nextInt(upperLimit);
		}
		
	}
	
	//Getter
	/*public int getList() {
		//
	}*/
	
	//Setter
	public void setList() {
		
	}
	
	//Sorting
	public int getMin() {
		
		//int[] temp = list;
		int[] temp = new int[list.length];
		System.arraycopy(list, 0, temp, 0, list.length);
		Arrays.sort(temp);
//		Arrays.sort(list);
//		return list[0];
		return temp[0];
	}
	
	public int getMax() {
		int[] temp = new int[list.length];
		System.arraycopy(list, 0, temp, 0, list.length);
		Arrays.sort(temp);
		return(temp[list.length - 1]);
	}
	
	public double getAvg() {
		int total = 0;
		int n = list.length;
		for(int i = 0; i < n; i++) {
			total += list[i];
		}
		double avg = total/n;
		return avg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComputeArray [list=" + Arrays.toString(list) + "]";
	}
}
