package chapter23;

import java.util.Arrays;

public class QuickSortTester {
    public static void main(String[] args) {
        int list[] = {1,4,-1,5,6,1,-3,-10,41,11};
        QuickSort.quickSortHelper(list);
        System.out.println(Arrays.toString(list));
    }
}
