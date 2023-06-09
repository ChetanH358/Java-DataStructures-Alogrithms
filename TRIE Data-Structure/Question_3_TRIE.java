
/*
 * Count Unique Substrings / count distinct substrings
 * given a string of length n of lowercase alphabet characters , we need to count total number of distinct substrings of this string
 * 
 * str = "ababa"
 * O/p : 10
 * 
 * These are the possible substring's :- (note these are not unique)
 * a    ab      aba     abab    ababa
 * b    ba      bab     baba    " "(null)
 * a    ab      aba
 * b    ba
 * a
 * 
 * after removing dubplicates count of substring's is 10
 * 
 * Approach :
 * get all suffix's of the string 
 * the get all possible prefix's of the each and every suffix that got earlier
 * here (#n) -->indicates to reomve the dupicate elements 
 * 
 * suffix's 
 * ababa --> a, ab, aba, abab, a
 * baba  --> b, ba, bab, baba
 * aba   --> a(#n), ab(#n), aba(#n)
 * ba    --> b(#n), ba(#n)
 * a     --> a(#n)
 * " "   --> " "
 * total nodes of TRIE = count of unique prefix
 * Steps to proceed with are :
 * 1) find all suffix of string
 * 2) create a TRIE from suffix
 * 3) count nodes of TRIE
 * 
 * step 1:  for(int i=0 to n){
 *              substring(i) -> suffix
 *          }
 * 
 * 
 * step 2: insert(suffix)
 * 
 * step 3:
 * count = 0;
 * for(int i=0 to 26)
 * if(root.children[i] != null){
 *     count += countNodes(root.children[i])
 * }
 * return count+1;
 * 
 * it is a function
 * countNodes(root) -> if (root == null) {return 0}
 *
 */

public class Question_3_TRIE {
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

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNode(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        // String str = "ababa";
        String str = "apple";
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            // System.out.println(suffix);
            /*
             * ---> we get all suffix's
             * ababa
             * baba
             * aba
             * ba
             * a
             */
            insert(suffix);
        }
        System.out.println(countNode(root));
    }
}
