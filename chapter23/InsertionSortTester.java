package chapter23;

import java.util.Arrays;

public class InsertionSortTester {
    public static void main(String[] args){
        int list[] = {12,31,12,55,64,10,-22,30,141,-112};

        InsertionSort.insertionSort(list);

        System.out.println(Arrays.toString(list));
    }


}
