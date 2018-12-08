package chapter20;

//import java.util.Comparator;
import java.util.LinkedList;

public class MyLinkedList<E> extends LinkedList<E> implements Comparable<MyLinkedList<E>> {
	private static final long serialVersionUID = 1L;
//	int id = 0;
//	private static int num;
//	private int count;
//	public MyLinkedList(){
//		id=num++;
//	}
	/**
	 * @return the count
	 */
//	public int getCount() {
//		return count;
//	}

	/**
	 * @param count the count to set
	 */
//	public void setCount(int count) {
//		//this.count = count;
//		for(int i=0; i<this.size();i++){
//			if((int)this.get(i)==1)
//				this.count++;
//		}
//		//this.count=count;
//	}
	@Override
	public int compareTo(MyLinkedList<E> arg0) {
//		for(int i = 0; i < maze.length; i++){
//			for(int j = 0; j < maze[i].length; j++){
//				maze[i][j]=list.removeFirst();			}
//		}
		int count1=0;
		int count2=0;
		for(int i=0; i<this.size();i++){
			if((int)this.get(i)==1)
				count1++;
		}
		for(int i=0; i<arg0.size();i++){
			if((int)arg0.get(i)==1)
				count2++;
		}
		if(count1 > count2){
			//count=count1;
			return -1;
		}
		else if(count1 == count2)
		{
			//count=count1;
			return 0;
		}
		else {
			//count=count2;
			return 1;
		}

	}
//	@Override
//	public int compareTo(MyLinkedList<E> arg0) {
//		int count1=0;
//		int count2=0;
//		for(int i=0; i<this.size();i++){
//			if((int)this.get(i)==1)
//				count1++;
//		}
//		for(int i=0; i<arg0.size();i++){
//			if((int)arg0.get(i)==1)
//				count2++;
//		}
//		if(count1 > count2){
//			count=count1;
//			return -1;
//		}
//		else if(count1 == count2)
//		{
//			count=count1;
//			return 0;
//		}
//		else {
//			count=count2;
//			return 1;
//		}
//
//	}
}
