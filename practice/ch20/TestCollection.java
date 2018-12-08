package practice.ch20;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        ArrayList<String> collection1 = new ArrayList<>();
        collection1.add("New York");
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");

        System.out.println("A list of cities in collection1");
        System.out.println(collection1);

        System.out.println("\nIs Dallas in collection1?");
        collection1.remove("Dallas");

        Collection<String> collection2 = new ArrayList<>();
        collection2.add("Seattle");
        collection2.add("Portland");
        collection2.add("Los angales");
        collection2.add("Atlanta");



        System.out.println("A list of cities in collection2");
        System.out.println(collection2);


        ArrayList<String> c1 = (ArrayList<String>)(collection1.clone());
        c1.addAll(collection2);
        System.out.println("\nCities in collection 1 or 2: ");
        System.out.println(c1);

        c1 = (ArrayList<String>) (collection1.clone());
        c1.retainAll(collection2);
        System.out.println("collection1 and 2: ");
        System.out.println(c1);

        c1 = (ArrayList<String>) (collection1.clone());
        c1.removeAll(collection2);
        System.out.println("Collecction 1 but not in 2");
        System.out.println(c1);





    }
}