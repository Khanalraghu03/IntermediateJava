package chapter23;

public class BubbleSort {


    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        int temp;
        for(int k = 1; k < list.length &&needNextPass; k++) {
            for(int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i+1]) {
                    //make list[i] to the next position
                        //make the next position to the list[i]
                    temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }

            }
        }
    }
}
