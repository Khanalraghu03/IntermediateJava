package chapter23;

public class InsertionSort {

    public static void insertionSort(int[] list) {
        for(int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k = 0;
            int temp;
            for(k = i - 1; k>= 0 && list[k] >currentElement; k--) {
                temp = list[k];
                list[k] = list[k+1];
                list[k+1] = temp;
            }
            currentElement = list[k+1];
        }
    }
}
