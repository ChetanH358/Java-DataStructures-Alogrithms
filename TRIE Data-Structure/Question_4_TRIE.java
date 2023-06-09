
/*
 * Find the longest string in words such that every prefix of it is also in words
 * words = {"a","banana","app","appl","ap","apply","apple"}
 * ans = "apple"
 * 
 * In the above given array banana is longest but no prefix's of banana is exist so discard
 * In apple vs apply all possible prefix's of both words exist but based on lexiographic(Ascending)
 * order of characters apple is our answer
 * In apple we found that all prefix's exist 
 * 
 * case 1: longest length
 * case 2: equal length -> lexiographically smaller
 * case 3: empty string
 * 
 * Approach :
 * objecive : To find the longest word for which nodes End_of_word true
 * to check the nodes whose root.children[i] != null and aslo End_of_word = true
 * 
 * psudocode:
 * static String ans=""
 * longest_word(root, String builder temp){
 * 
 *      //base case
 *      if(root == null){return}
 *      
 *      for(int i=0 to 26){
 *          if(root.children[i] != null && root.child[i].End_Of_word == true){
 *              temp.append((char)(i+'a)'))
 *           }
 *           if(temp.length()>ans.length()){
 *                  ans = temp      
 *           }
 *           longestword(root.children[i],temp)
 *           temp.deletecharAt(temp.length-1)
 *      }
 * }
 * 
 */

public class Question_4_TRIE {
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

    public static String ans = "";

    public static void longestword(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].End_Of_Word == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestword(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestword(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
