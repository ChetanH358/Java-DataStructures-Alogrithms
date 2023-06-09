
public class Create_TRIE {
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

    public static void main(String[] args) {
        String words[] = { "the", "a", "there", "their", "any" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        System.out.println(search("their"));
        System.out.println(search("thor"));
        System.out.println(search("an"));
    }
}