import java.util.*;

/*
 * HashMap is pair of key and value
 * key will be unique where as value may be same
 * hashmap are unorderd maps -> values get printed in unorder manner
 * if we reinsert key once again the value get updated
 * 
 * map.put() ->
 * if key ->exist-> update value
 * if key does not exist -> new pair is created is inserted
 * 
 * .get() ->
 * key exist -> value
 * key doesnot exist -> null
 * 
 * .containskey() ->
 * if exist -> true or else -> false
 * 
 */

public class First_Hashmap_Programme {
    public static void main(String[] args) {
        // coutry(key) , population(value)
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        System.out.println(map);
        map.put("China", 180);
        System.out.println(map);

        // search
        if (map.containsKey("China")) {
            System.out.println("key is present in the map");
        } else {
            System.out.println("key is not present in map");
        }

        // to get value corresponding to key
        System.out.println(map.get("China")); // key exist
        System.out.println(map.get("Russia")); // key does not exist

        // printing both key and it's correspondig value
        for (Map.Entry<String, Integer> ele : map.entrySet()) {
            System.out.println("key is : " + ele.getKey() + " and value is : " + ele.getValue());
        }

        /*
         * storig only key into type set and printing both key and value using for each
         * loop
         */
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
