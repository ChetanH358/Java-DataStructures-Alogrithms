import java.util.HashSet;

/*
 * Question on Intersection =>
 * 
 * given two arrays need to find all intersecting elemets -> intersection->> common elements
 * arr_1[] = {7,3,9}
 * arr_2[] = {6,3,9,2,4}
 * 
 * O/p -> intersection = 2 (3,9)
 * Approach :
 * pick any one of the array and it as unique -> creating a Hashset
 * for(int i=0 to n1) - set.add(arr1[i])
 * for(int j=0 to n2) - if(set.contains(arr2[j])) -> matched then do count++ and reomve that element form the set
 * return count as Answer
 * 
 */

public class Question_3 {
    public static int Intersection(int arr_1[], int arr_2[]) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr_1.length; i++) {
            set.add(arr_1[i]);
        }
        for (int j = 0; j < arr_2.length; j++) {
            if (set.contains(arr_2[j])) {
                count++;
                set.remove(arr_2[j]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr_1[] = { 7, 3, 9 };
        int arr_2[] = { 6, 3, 9, 2, 9, 4 };
        System.out.println(Intersection(arr_1, arr_2));
    }
}
