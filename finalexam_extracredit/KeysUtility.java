package finalexam_extracredit;

import java.util.ArrayList;
import java.util.LinkedList;

public class KeysUtility<E> {
    private ArrayList<E> list;

    public KeysUtility() {
        list = new ArrayList<>();
    }

    public ArrayList<E> getList() {
        return list;
    }

    public void setList(ArrayList<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "KeysUtility{" +
                "list=" + list +
                '}';
    }

    public void reverseKeyList(ArrayList<E> list) {
        //i.	Declare a LinkedList reference variable lList:LinkedList<E>, and
        //               create a LinkedList and assign its reference to lList
        LinkedList<E> lList = new LinkedList<>();

        // until the ArrayList is empty
        while(!list.isEmpty()) {
            ////ii.	Remove the elements one by one from the front of the ArrayList and
            //        //      add them to the LinkedList
            lList.add(list.remove(0));

        }
        //iii.	Remove the elements one by one from the end of the LinkedList and
        //      add them to the ArrayList instance variable until the LinkedList is empty
        while (!lList.isEmpty()) {
            list.add(lList.remove(lList.size() -1));

        }
    }


}
