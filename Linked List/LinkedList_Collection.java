
import java.util.*;

public class LinkedList_Collection {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.addFirst("for a walk");
        ll.addFirst("going");
        ll.addFirst("am");
        ll.addFirst("I");
        System.out.println(ll);
        System.out.println(ll.size());

        // using for each loop
        for (String s1 : ll) {
            System.out.print(s1 + " ");
        }
        System.out.println();

        // using for loop
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " -> ");
        }
        System.out.println("null");

        ll.removeLast();
        ll.removeFirst();

        System.out.println(ll);

    }

}
