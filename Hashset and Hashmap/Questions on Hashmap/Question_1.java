import java.util.HashMap;

/*
 * Given an integer array of size , n find all elements that appear
 * morethan[n/3] times
 * 
 * nums[] = {1,3,2,5,1,3,1,5,1} , o/p -> 1
 * nums[] = {1,2} , o/p -> 1,2
 * 
 * Approach :
 * 1) nums as key and frequency as value
 * 2) create a object of hashmap
 * 3) find frequency of all nums and store it in map
 * 4) if key exist -> update value freq = freq + 1 and if key doesnot exist add
 * new pair
 * Time complexity of the code is O(n)
 * 
 */
public class Question_1 {
    public static void majorityElement(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > n / 3) {
                System.out.println(key);
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        majorityElement(nums);
    }
}