package chapter19;

import java.util.ArrayList;

/**
 * @author Raghu Khanal
 *
 */

public class EncryptionDecryptionUtilities <E> {

    private ArrayList<E> list;

    public EncryptionDecryptionUtilities() {
        this.list = new ArrayList<>();
    }

    public EncryptionDecryptionUtilities(int capacity) {
        this.list = new ArrayList<>(capacity);
    }

    public ArrayList<E> getList() {
        return list;
    }

    public void setList(ArrayList<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "EncryptionDecryptionUtilities{" +
                "list=" + list +
                '}';
    }

    public int getSizeOfList() {
        //Returns the size of the ArrayList
        return list.size();

    }

    public boolean isListEmpty() {
        //Returns true if the list contains no objects
        //Returns false otherwise
        return list.isEmpty();
    }

    //This method can accept any object passed to EncryptionDecryptionUtilities
    public void addElementToMiddleOfList(E o) {

        //The method will add the object to the list
        //      at position: size/2

        list.add(getSizeOfList()/2, o);
    }
    //This method can return any object passed to EncryptionDecryptionUtilities
    public E removeElementFromMiddleOfList() {
        //If the list is not empty the method will remove and return the object from
        //  the list at position (size-1)/2. Otherwise it will return null
        if(!list.isEmpty()) {
            return list.remove((getSizeOfList() - 1)/2);
        }
        else
            return null;
    }
    //This method can accept any object passed to EncryptionDecryptionUtilities
    public void addAsLastElementToList(E o) {
        //The method will add the object as the last element in the list
        list.add(getSizeOfList(), o);
    }

    ////This method can return any object passed to EncryptionDecryptionUtilities
    public E removeFirstElementFromList() {
    //If the list is not empty the method will remove and return the first
    //  object from the list. Otherwise it will return null
        if(!list.isEmpty()) {
            return list.remove(0);
        }
        else
            return null;
    }
}
