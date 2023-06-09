import java.util.*;
/*
 * Subarray sum equal to K
 * arr={1,2,3} for given k=3 
 * O/p -> 2
 */

public class Question_5 {
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 }; // ans -> 3
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>(); // <sum,frequency>
        map.put(0, 1);// empty subarray
        int ans = 0;
        int sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        System.out.println(ans);

    }
}
