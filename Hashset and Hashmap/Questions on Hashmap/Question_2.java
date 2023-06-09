import java.util.HashSet;

/*
 * Question on HashSet =>
 * 
 *  given 2 arrays behaving 2 set's set-A and set-B as per mathmatics
 * after union need to print the total number of elemets present 
 * 
 * union ->> combination 
 */
public class Question_2 {
    public static int union(int arr_1[], int arr_2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr_1.length; i++) {
            set.add(arr_1[i]);
        }
        for (int j = 0; j < arr_2.length; j++) {
            set.add(arr_2[j]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int arr_1[] = { 7, 3, 9 };
        int arr_2[] = { 6, 3, 9, 2, 9, 4 };
        System.out.println(union(arr_1, arr_2));
    }
}
