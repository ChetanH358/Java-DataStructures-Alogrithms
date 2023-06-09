import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 
 * hashmap consit's of key and value pair
 * put(), get(),containskey(),reomove(),size(),keyset() all have time complexity of O(n)
 * 
 * hashmap internally implemented as Array of Linked List
 * Hashing means changing the form of data
 * 
 * Many Algorithms exist for Hashing -> this technique is used to store passwords
 * converted form of hashed value(i/p : string_name) is always remain same every time we want to know hashed form
 * 
 * If Node exist it will update otherwise it creates a new node to the existing linked list
 * In Avg-Case n/N = lambda -> nodes are evenly distributed along the length of the array
 * when lambda >= k (k is constant/thrushhold value) -> Increase the size of the array -> this process is also known as ReHashing
 * 
 * put meathod will have time complexity of O(lambda) lambda will be constant we say O(1)
 * 
 * worstcase complexity of HashMap is O(n) -> if all pairs get inserted into single Index of Array of Linked list 
 * our LL will go in single direction leading to O(n)
 * 
 * Time complexity of ReHashing is O(n)
 * 
 * get() -> key exist -> return value or else return null;
 * reomove() -> key exist then reomove and also return the value or else return null
 * 
 */

public class Implementation_of_Hashmap {
    static class HashMap<Key, Value> {
        // this node is meant for linked list
        private class Node {
            Key key;
            Value value;

            public Node(Key key, Value value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // total number of nodes
        private int N; // total number of buckets
        private LinkedList<Node> buckets[]; // N = buckets.length , declaring buckets[] of type LinkedList<Node>

        // constructor of HashMap class
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4]; // initilizing the buckets[]
            for (int i = 0; i < 4; i++) {
                // creating an empty linked list
                this.buckets[i] = new LinkedList<>();
            }
        }

        /*
         * 1) hash function which return's bucket index
         * 2) hashcode function will return integer value
         * 3) it will change the key form and return's a integer value
         * 4) it will return any integer value and that may be positive or negative to
         * make it absolute positive value we use Math library
         * 5) constraint bucket index must be between 0 to (n-1) , to overcome from this
         * we take mod/reminder within N
         * ex : if we take reminder upto 3 we get like this [1 % 3 = 1] ,[ 2 % 3 = 2 ]
         * 
         */
        private int hashFunction(Key key) { //
            int bucket_index = key.hashCode();
            return Math.abs(bucket_index) % N;
        }

        /*
         * search_In_LinkedList accpet's two arguments (key,bucket_index)
         * first go to bucket_index
         */
        private int searchInLL(Key key, int bucket_index) {
            LinkedList<Node> ll = buckets[bucket_index];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        /*
         * ReHash() ---->
         * 1)At first we need to store the buckets into oldBucket[] , then reinitilize
         * the
         * existing array i.e buckets
         * 2) go to the index position and add all nodes with help of for loop
         * 3) before that run a for loop and initilize the linked list with null
         */
        @SuppressWarnings("unchecked")
        private void ReHash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];

            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }

        }

        // put function ----->
        /*
         * step's for implementation of put-function ----->
         * 
         * 1) find bucket index
         * 2) hashFunction will return a bucket index
         * 3) the linked list stored on that index, check weather key exist's or not in
         * that linked list
         * 4) another function search_In_LinkedList which gives data_index
         * 5) if data_index value is a valid value which means -> 0 or more than 0 key
         * exist earlier and if key = -1 ,key doesnot exist from earlier
         * 6) from linkedlist get the value from data index where in ,key exist in
         * data_index
         * 7) value is stored in data of type Node and reinitilize the value
         * 8) check weather lambda value > n or not
         * 
         */
        public void put(Key key, Value value) {

            int bucket_index = hashFunction(key);
            int data_index = searchInLL(key, bucket_index);
            if (data_index == -1) {
                // key doesn't exist in that case create a new node
                buckets[bucket_index].add(new Node(key, value));
                n++;
            } else {
                // key already exist , get the value present in data index -> in data_index key
                // will be stored
                Node node = buckets[bucket_index].get(data_index);
                node.value = value;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                ReHash();
                // rehash
            }
        }

        public boolean containsKey(Key key) {
            int bucket_index = hashFunction(key);
            int data_index = searchInLL(key, bucket_index);
            if (data_index == -1) {
                // key doesn't exist in that case create a new node
                return false;
            } else {
                return true;
            }
        }

        public Value remove(Key key) {
            int bucket_index = hashFunction(key);
            int data_index = searchInLL(key, bucket_index);
            if (data_index == -1) {
                // key doesn't exist in that case create a new node
                return null;
            } else {
                Node node = buckets[bucket_index].remove(data_index);
                n--;
                return node.value;
            }
        }

        /*
         * for the key search bucket_index first and search in linkedlist
         */

        public Value get(Key key) {
            int bucket_index = hashFunction(key);
            int data_index = searchInLL(key, bucket_index);
            if (data_index == -1) {
                // key doesn't exist in that case return null;
                return null;
            } else {
                // key already exist , get the value present in data index -> in data_index key
                // will be stored
                Node node = buckets[bucket_index].get(data_index);
                return node.value;
            }
        }

        public ArrayList<Key> keyset() {
            ArrayList<Key> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i]; // bucket_index
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j); // data_index
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            // if nodes are 0 then we say list is empty
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        ArrayList<String> keys = map.keyset();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println("key is : " + keys.get(i) + " & value is : " + map.get(keys.get(i)));
        }

    }
}