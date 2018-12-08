package practice.check;

public class Tester {
    public static void main(String[] args)
    {
        A obj = new C();
        B b = new C();
        C c = new C();
        obj = c;
//        obj = b; //Interface is not related to class B at all
        System.out.println();
        System.out.println();


    }

}
