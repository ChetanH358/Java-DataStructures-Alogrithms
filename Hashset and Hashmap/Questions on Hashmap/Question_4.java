import java.util.HashMap;

/*
 * Find Itinerary from Tickets =>
 * 
 *    key     |    value
 * "chennai" -> "bangalore"
 * "mumbai" -> "delhi"
 * "goa" -> "chennai"
 * "delhi" -> "goa"
 *   value    |    key    <- reversing hashmap
 * 
 * for 1-st case Tickets -> chennai,mumbai,goa,delhi are the keys and bangalore,delhi,chennai,goa are correspondig values
 * In 2-nd case ReverseTickets -> bangalore,delhi,chennai,goa are keys and chennai,mumbai,goa,delhi are correspondinig values
 */

public class Question_4 {
    public static String getStart(HashMap<String, String> tickets) {
        /*
         * 1) create a object of HashMap and run a foreach loop add key and value
         * in second for loop check weather key exist in reverseHashMap or not
         * 2) if key not found if->condition will execute and reuturn's key
         */
        HashMap<String, String> reverseHashMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            // key -> key ; val-> tickets.get(key)
            reverseHashMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!reverseHashMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengalore");
        tickets.put("Mumabi", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);

        /*
         * => once we get start we check weather start(key) is present in our map or not
         * if prsent then we will print and
         * => updation -> we get the value corresponding to the key and it will become
         * start(key). loop runs until condition is true when loop terminates
         * last key is printed
         */
        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start);

    }
}
