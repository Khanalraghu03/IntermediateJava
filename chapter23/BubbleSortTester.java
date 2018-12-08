package chapter23;


import java.util.Arrays;

public class BubbleSortTester {
    public static void main(String[] args) {
        int[] array = {2,3,2,5,6,1,-2,3,14,12};

        BubbleSort.bubbleSort(array);

        System.out.print(Arrays.toString(array));

    }
}
