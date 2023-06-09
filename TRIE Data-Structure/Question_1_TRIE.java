
/*
 * Word Break Problem
 * Given an input string and a dictonary of words , find out if the input string
 * can be broken int a space-seperated sequence of dictonary words
 * 
 * words[] = {"i","like","samsung","mobile",ice}
 * key = "ilikesamsung"
 * O/p --> true
 * 
 * Approach :
 * 1) firstly add the string into the TRIE data structure
 * 2) by making cuts we go by each and every word.in that check weather first part is true or not 
 * 3) if true then check for second part. for example i|likesamsung ,il|ikesamsung...ilikesamsun|g
 * 4) first and second part will run by recurssion and base case is ,if key length is == 0 return true (null string)
 * 
 * psudocode :
 *  boolean word_break(String key){
 *   if(key.length == 0){
 *      return true
 *   }
 *   for(int i=1 to n){
 *     1-st part key(0,i)
 *     2-nd part key(i,n)
 *     if(search(1-st part) && word_break(2_nd part)){
 *     return true
 *     }
 *   }
 *   return false;
 *  }
 */

public class Question_1_TRIE {
    static class Node {
        Node[] children;
        boolean End_Of_Word;

        public Node() {
            // 26 : a to z
            children = new Node[26];// intilizing array of nodes
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            End_Of_Word = false;
        }
    }

    static Node root = new Node();

    // in this function at every time single word is allowed
    public static void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                // add new node
                current.children[index] = new Node();
            }
            if (i == word.length() - 1) {
                current.children[index].End_Of_Word = true;
            }
            current = current.children[index];// updation
        }
    }

    public static boolean search(String key) {
        Node current = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            Node node = current.children[index];

            if (node == null) {
                return false;
            }
            if (i == key.length() - 1 && current.children[index].End_Of_Word == false) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public static boolean word_break(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String first_part = key.substring(0, i);
            String second_part = key.substring(i);
            if (search(first_part) && word_break(second_part)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = { "i", "like", "sam", "samsung", "mobile" };
        String key = "ilikesung";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(word_break(key));
    }
}
