import java.util.HashSet;
import java.util.Iterator;

/*
 * Set doesnot allow duplicates all elements must be unique
 * 
 * 
 * 
 * In HashSet these are the time complexity's ->
 * Insert/Add -> O(1)
 * Search/contains -> 0(1)
 * Delete Remove -> 0(1)
 * 
 * In Array ->
 * Insert/Add -> O(1)
 * Search/contains -> 0(n)
 * Delete Remove -> 0(n)
 * 
 * Sorted Array ->
 * Insert/Add -> O(n)
 * Search/contains -> 0(log n)
 * Delete Remove -> 0(n)
 * 
 * In Binary Search Tree ->
 * Insert/Add -> O(H) - O(n) <- if we have n nodes it will be O(n)
 * Search/contains -> 0(H) - O(n) 
 * Delete Remove -> 0(H) - O(n)
 * 
 * 
 */
public class First_Hashset_programme {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        // size
        System.out.println("size of the set is:" + set.size());

        // to print all elements of the set
        System.out.println(set);

        // search -> contains
        if (set.contains(1)) {
            System.out.println("set contains element");
        }
        if (!set.contains(6)) {
            System.out.println("does not contain element");
        }

        // delete
        set.remove(1);
        if (!set.contains(1)) {
            System.out.println("does not contain 1 we deleted 1");
        }

        /*
         * Interator
         * set and hashmap iterate with help of iterator
         * In for loop i=0.......... is a iterator(variable) helps for iteration
         * set do not have index
         * firstly import Iterator
         * it makes no guarantee as to the iteration order of the set
         * hashset does not gurantee that the order will remain constant over time
         */

        Iterator it = set.iterator();
        /*
         * iterator has 2 meathods next() and hasnext()
         * at first it-> null and after calling next() it starts pointing to 1 then
         * 2.....3
         * 
         * hasnext() -> retrurn's true or false -> checks next iterator present or not
         */
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}